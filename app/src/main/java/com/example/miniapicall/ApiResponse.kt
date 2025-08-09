package com.example.miniapicall

import retrofit2.Call
import retrofit2.http.GET

interface ApiResponse {
    @GET("todos/1") // end point of an url
    fun getTodo() : Call<ResponseDataClass>
}