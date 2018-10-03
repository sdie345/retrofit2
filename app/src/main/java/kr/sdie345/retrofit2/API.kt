package kr.sdie345.retrofit2

/**
 * Created by sdie3 on 2018-10-03.
 */
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

import java.util.*

interface API {
    @POST("/Login")
    //Post일 경우, FormUrlEmcoded 사용해줘야댐
    @FormUrlEncoded
    //보내고 싶은거 함수 호출 인자 추가해주면됨
    //@Field사용해서 정의
    fun getPerson(@Field("id") id : String, @Field("pw") pw : String) : Call<Person>
}
