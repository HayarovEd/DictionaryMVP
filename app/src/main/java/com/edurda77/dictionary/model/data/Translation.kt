package com.edurda77.dictionary.model.data.datasource

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Translation(
    @SerializedName("text")
    val textTranslation: String
): Serializable