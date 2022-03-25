package com.edurda77.dictionary.model.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Meanings(
    @SerializedName(TRANSLATION)
    val translation: Translation,
    @SerializedName(IMAGE_URL)
    val imageUrl: String
) : Serializable
