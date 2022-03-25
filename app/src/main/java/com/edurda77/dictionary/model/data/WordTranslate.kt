package com.edurda77.dictionary.model.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WordTranslate(
    @SerializedName(TEXT)
    val text: String,
    @SerializedName(MEANINGS)
    val meanings:List<Meanings>
):Serializable
