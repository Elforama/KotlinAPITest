package com.example.lawrencemuller.kotlinapitest.net

import com.google.gson.annotations.SerializedName

/**
 * Created by Jonathan Muller on 9/14/16.
 */
data class User (
        val login: String?,
        val id: Int?,
        val type: String?,
        @SerializedName("site_admin") val siteAdmin: Boolean?) {}