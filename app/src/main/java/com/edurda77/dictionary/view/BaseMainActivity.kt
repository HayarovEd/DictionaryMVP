package com.edurda77.dictionary.view

import com.edurda77.dictionary.model.data.datasource.WordTranslate

interface BaseMainActivity {
    fun loadData (dataInputCurrent:MutableList<WordTranslate>)
}