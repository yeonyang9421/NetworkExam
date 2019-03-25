package kr.co.woobi.imyeon.networkexam;

import java.util.List;

import kr.co.woobi.imyeon.networkexam.model.Users;
import retrofit2.Call;
import retrofit2.http.GET;

public interface UserService {
    @GET("users")
    Call<List<Users>> listUsers();
}
