package com.edurda77.dictionary.view

/**/import TranslateAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.edurda77.dictionary.App
import com.edurda77.dictionary.databinding.ActivityMainBinding
import com.edurda77.dictionary.model.data.WordTranslate

class MainActivity : AppCompatActivity(), BaseMainActivity {
    private lateinit var binding: ActivityMainBinding

    //private val viewModel: MainActivityViewModel by viewModel()
    //@Inject
    //Dagger - internal lateinit var viewModelFactory: ViewModelProvider.Factory
    //Dagger - lateinit var viewModel: MainActivityViewModel
    /*private val viewModel: MainActivityViewModelContract.ViewModel by lazy {
        ViewModelProvider(this)[MainActivityViewModel::class.java]
    } without DI */
    private val presenter = App.instance.presenterMainActivity
    private var dataInput = emptyList<WordTranslate>().toMutableList()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        //Dagger - AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        //Dagger - viewModel = viewModelFactory.create(MainActivityViewModel::class.java)
        presenter.attachView(this)

        binding.search.setOnClickListener {
            val searchWord = binding.enter.text.toString()

            presenter.getData(searchWord)
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

    override fun loadData(wordTranslate: List<WordTranslate>) {
        dataInput.clear()
        Thread {
            wordTranslate.forEach {
                dataInput.add(it)
            }
            runOnUiThread {
                setOotRecycledView(dataInput)
            }
        }.start()
    }

    override fun onStop() {
        presenter.detachView(this)
        super.onStop()
    }
}




