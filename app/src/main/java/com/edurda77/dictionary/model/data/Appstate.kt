package com.edurda77.dictionary.model.data

import com.edurda77.dictionary.model.data.datasource.WordTranslate

sealed class Appstate {
    data class Success(val data: List<WordTranslate>?) : Appstate()
    data class Error(val error: Throwable) : Appstate()
    data class Loading(val progress: Int?) : Appstate()
}
