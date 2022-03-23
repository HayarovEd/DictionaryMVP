package com.edurda77.dictionary.view

import TranslateAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.edurda77.dictionary.databinding.ActivityMainBinding
import com.edurda77.dictionary.model.data.WordTranslate


class MainActivity : AppCompatActivity(), BaseMainActivity {
    private lateinit var binding: ActivityMainBinding
    //private val currentData: CaseRepo by lazy { app.caseRepoImpl }
    private val presenter = App.instance.presenterMainActivity
    //private val presenter2 = Presenter(CaseRepoImpl(),this)
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
        /*val searchWord = binding.enter
        val searchBottom = binding.search
        searchBottom.setOnClickListener {
            dataInput.clear()
            val word = searchWord.text.toString()
            val loadingData = currentData.getData(word)
            loadingData.subscribeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .map { it }
                .subscribeBy(
                    onError = {
                        Toast.makeText(this, "Ошибка $it", Toast.LENGTH_SHORT).show()
                    },
                    onNext = { list ->
                        list.forEach {
                            dataInput.add(it)
                        }
                    },
                    onComplete = {
                        Toast.makeText(this, "Все загружено", Toast.LENGTH_SHORT).show()
                    })
            setOotRecycledView()
        }*/

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
