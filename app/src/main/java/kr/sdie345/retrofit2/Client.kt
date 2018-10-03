package kr.sdie345.retrofit2

/**
 * Created by sdie3 on 2018-10-03.
 */
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Client {
    var retrofitService: API
    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val logger = OkHttpClient.Builder().addInterceptor(interceptor).readTimeout(20, TimeUnit.SECONDS).writeTimeout(20, TimeUnit.SECONDS).build()

        val retrofit = Retrofit.Builder()
                .baseUrl("서버의 주소를 넣어주면 됨")
                .addConverterFactory(GsonConverterFactory.create())
                .client(logger)
                .build()

        retrofitService = retrofit.create(API::class.java)
    }
}