package com.edurda77.dictionary.view

import TranslateAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.edurda77.dictionary.App
import com.edurda77.dictionary.databinding.ActivityMainBinding
import com.edurda77.dictionary.model.data.WordTranslate


class MainActivity : AppCompatActivity(), BaseMainActivity {
    private lateinit var binding: ActivityMainBinding

    private val presenter = App.instance.presenterMainActivity

    private var dataInput = emptyList<WordTranslate>().toMutableList()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        presenter.attachView(this)
        binding.search.setOnClickListener {
            val searchWord = binding.enter
            presenter.getData(searchWord.text.toString())
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

    override fun loadData(wordTranslate: List<WordTranslate>) {
        dataInput.clear()
        Thread {
            wordTranslate.forEach {
                dataInput.add(it)
            }
            runOnUiThread {
                setOotRecycledView()
            }
        }.start()
    }

    override fun onStop() {
        presenter.detachView(this)
        super.onStop()
    }
}
