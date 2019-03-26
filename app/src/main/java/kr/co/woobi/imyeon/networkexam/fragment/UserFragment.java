package kr.co.woobi.imyeon.networkexam.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import kr.co.woobi.imyeon.networkexam.R;
import kr.co.woobi.imyeon.networkexam.service.UserService;
import kr.co.woobi.imyeon.networkexam.adapter.UserRecyclerAdapter;
import kr.co.woobi.imyeon.networkexam.model.Users;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserFragment extends Fragment {
    private static final String TAG = UserFragment.class.getSimpleName();

    RecyclerView mUserRecycer;
    ProgressBar mProgressBar;
    UserRecyclerAdapter mUserApdater;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        mUserRecycer = view.findViewById(R.id.recycler_users);

        mProgressBar = view.findViewById(R.id.progressBar);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UserService service = retrofit.create(UserService.class);
        service.listUsers().enqueue(new Callback<List<Users>>() {
            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {
                mProgressBar.setVisibility(View.GONE);
                List<Users> userList = response.body();
                Log.d(TAG, "onResponse 크기: " + userList.size());
                Log.d(TAG, "onResponse: " + userList);

                mUserApdater = new UserRecyclerAdapter(userList);
                mUserRecycer.setAdapter(mUserApdater);
                mUserApdater.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {
                Toast.makeText(getActivity(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
