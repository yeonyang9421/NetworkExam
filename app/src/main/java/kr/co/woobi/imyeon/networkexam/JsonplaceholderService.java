package kr.co.woobi.imyeon.networkexam;

import java.util.List;

import kr.co.woobi.imyeon.networkexam.model.Photo;
import kr.co.woobi.imyeon.networkexam.model.Todos;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JsonplaceholderService {
    @GET("/posts/{id}")
    Call<Photo> listPhots1(@Path("id") int id);


    @GET("photos")
    Call<List<Photo>> listPhots(@Query("id") int id);


}
