package com.edurda77.dictionary.view

import com.edurda77.dictionary.model.data.WordTranslate

interface BaseMainActivity {
    fun loadData (wordTranslate: List<WordTranslate>)
}