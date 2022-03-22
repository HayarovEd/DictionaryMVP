package com.edurda77.dictionary.model.data.datasource

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WordTranslate(
    @SerializedName("text")
    val text: String,
    @SerializedName("meanings")
    val meanings:List<Meanings>
):Serializable
