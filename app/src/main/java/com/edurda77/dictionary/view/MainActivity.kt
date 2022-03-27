package com.edurda77.dictionary.view

import TranslateAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.edurda77.dictionary.App
import com.edurda77.dictionary.databinding.ActivityMainBinding
import com.edurda77.dictionary.model.data.WordTranslate
import com.edurda77.dictionary.viewmodel.MainActivityViewModel
import com.edurda77.dictionary.viewmodel.MainActivityViewModelContract
import dagger.android.AndroidInjection
import javax.inject.Inject


class MainActivity : AppCompatActivity() /*, BaseMainActivity*/ {
    private lateinit var binding: ActivityMainBinding
    @Inject
    internal lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: MainActivityViewModel
    /*private val viewModel: MainActivityViewModelContract.ViewModel by lazy {
        ViewModelProvider(this)[MainActivityViewModel::class.java]
    }*/
    //private val presenter = App.instance.presenterMainActivity
    //private var dataInput = emptyList<WordTranslate>().toMutableList()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel = viewModelFactory.create(MainActivityViewModel::class.java)
        //presenter.attachView(this)
        viewModel.liveData.observe(this) {
            setOotRecycledView(it)
        }
        binding.search.setOnClickListener {
            val searchWord = binding.enter.text.toString()
            viewModel.getData(searchWord, this)
            //presenter.getData(searchWord.text.toString())
        }
    }

    private fun setOotRecycledView(list: List<WordTranslate>) {

        val recyclerView: RecyclerView = binding.recycledView
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL, false
        )
        recyclerView.adapter = TranslateAdapter(list)
    }

    /*override fun loadData(wordTranslate: List<WordTranslate>) {
        dataInput.clear()
        Thread {
            wordTranslate.forEach {
                dataInput.add(it)
            }
            runOnUiThread {
                setOotRecycledView()
            }
        }.start()
    }*/

    /*override fun onStop() {
        presenter.detachView(this)
        super.onStop()
    }*/
}
