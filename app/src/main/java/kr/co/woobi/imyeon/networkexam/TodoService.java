package kr.co.woobi.imyeon.networkexam;

import java.util.List;

import kr.co.woobi.imyeon.networkexam.model.Todos;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TodoService {
    @GET("/posts/{id}")
    Call<List<Todos>> listTodo1(@Path("id") int id);



    @GET("todos")
    Call<List<Todos>> listTodo(@Query("userId") int id);

}
