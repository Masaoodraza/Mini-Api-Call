package com.example.miniapicall

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.miniapicall.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getTodo()
    }

    private fun getTodo() {
        RetrofitInstance.apiInterface.getTodo().enqueue(object : Callback<ResponseDataClass> {
            override fun onResponse(
                call: Call<ResponseDataClass>,
                response: Response<ResponseDataClass>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    val todo = response.body()
                    binding.textViewTitle.text = "Title: ${todo?.title}"
                    binding.textViewCompleted.text = "Completed: ${todo?.completed}"
                } else {
                    Toast.makeText(this@MainActivity, "No data received", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ResponseDataClass>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error: ${t.localizedMessage}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
