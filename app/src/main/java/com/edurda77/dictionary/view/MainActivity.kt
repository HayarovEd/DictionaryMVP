package com.edurda77.dictionary.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.edurda77.dictionary.databinding.ActivityMainBinding
import com.edurda77.dictionary.model.data.datasource.WordTranslate
import com.edurda77.dictionary.model.datasource.CaseRepo
import io.reactivex.Scheduler


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val currentData: CaseRepo by lazy { app.caseRepoImpl}
    private var dataInput = emptyList<WordTranslate>().toMutableList()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val searchWord = binding.enter
        val searchButtom = binding.search
        searchButtom.setOnClickListener {
            val word = searchWord.text.toString()
           val wert = currentData.getData(word).observeOn(Scheduler)
        }
    }
}