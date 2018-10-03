package kr.sdie345.retrofit2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.widget.TextView
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var t : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        t = findViewById(R.id.text22)
        Client.retrofitService.getPerson("asdf123","asdf123").enqueue(object : retrofit2.Callback<Person> {
            override fun onResponse(call: retrofit2.Call<Person>?, response: Response<Person>?) { // 200이 보통 성공임
                if (response!!.isSuccessful) {
                    t.text = response.body().toString()
                }
            }

            override fun onFailure(call: retrofit2.Call<Person>?, t: Throwable?) { // 서버에러
            }

        })
    }
}
