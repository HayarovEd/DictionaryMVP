package com.edurda77.dictionary.view

import TranslateAdapter
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.edurda77.dictionary.databinding.ActivityMainBinding
import com.edurda77.dictionary.model.data.datasource.WordTranslate
import com.edurda77.dictionary.model.datasource.CaseRepo
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val currentData: CaseRepo by lazy { app.caseRepoImpl }
    private var dataInput = emptyList<WordTranslate>().toMutableList()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val searchWord = binding.enter
        val searchButtom = binding.search
        val progressBar = binding.progressBarRound
        searchButtom.setOnClickListener {
            dataInput.clear()
            progressBar.isVisible
            val word = searchWord.text.toString()
            val loadnigData = currentData.getData(word)
            loadnigData.subscribeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .map { it }
                .subscribeBy(
                    onError = {
                        Toast.makeText(this, "Ошибка $it", Toast.LENGTH_SHORT).show()
                        progressBar.isInvisible
                    },
                    onNext = { list ->
                        list.forEach {
                            dataInput.add(it)
                        }
                    },
                    onComplete = {
                        Toast.makeText(this, "Все загружено", Toast.LENGTH_SHORT).show()
                        progressBar.isInvisible
                    })
            setOotRecycledView()
        }

    }
    private fun setOotRecycledView() {

        val recyclerView: RecyclerView = binding.recycledView
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL, false
        )
        val adapter = TranslateAdapter(dataInput)
        recyclerView.adapter = adapter
        recyclerView.adapter = TranslateAdapter(dataInput)
        adapter.notifyDataSetChanged()
    }
}
