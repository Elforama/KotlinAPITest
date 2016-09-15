package com.example.lawrencemuller.kotlinapitest.net

import com.google.gson.annotations.SerializedName

/**
 * Created by Jonathan Muller on 8/31/16.
 */
data class Repo(val name: String?,
                val id: Int?,
                @SerializedName("language") val lang: String?,
                val owner: User?) {}