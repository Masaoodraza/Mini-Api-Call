package com.example.miniapicall

import retrofit2.Call
import retrofit2.http.GET

interface ApiResponse {
    @GET("todos/1")
    fun getTodo() : Call<ResponseDataClass>
}