package com.example.aplicatiecarti.data

import com.example.aplicatiecarti.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NYTServices {

    @GET("lists.json")
    fun getBooks(
        @Query("api-key") apiKey: String = "aOHUED15m168vcFjUTUkITOvs30Hnf94",
        @Query("list") list: String = "hardcover-fiction"
    ): Call<BookBodyResponse>
}