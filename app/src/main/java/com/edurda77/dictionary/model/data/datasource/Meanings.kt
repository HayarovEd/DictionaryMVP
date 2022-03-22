package com.edurda77.dictionary.model.data.datasource

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Meanings(
    @SerializedName("translation")
    val translation: Translation,
    @SerializedName("imageUrl")
    val imageUrl: String
) : Serializable
