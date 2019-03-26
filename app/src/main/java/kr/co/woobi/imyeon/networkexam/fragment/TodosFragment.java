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
import kr.co.woobi.imyeon.networkexam.service.TodoService;
import kr.co.woobi.imyeon.networkexam.adapter.TodosRecyclerAdapter;
import kr.co.woobi.imyeon.networkexam.model.Todos;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TodosFragment extends Fragment {
    private int mId=2;
    private static final String TAG = TodosFragment.class.getSimpleName();
    private ProgressBar mProgressBar;
    private RecyclerView mRecycler;
    private TodosRecyclerAdapter adapter;

    public TodosFragment() {
    }

    public static TodosFragment newInstance(int id) {
        TodosFragment fragment = new TodosFragment();
        Bundle args = new Bundle();
        args.putInt("id",id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            mId=getArguments().getInt("id",0);

        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment_todos, container,false);

        mProgressBar = view.findViewById(R.id.progressBar_todos);

        mRecycler = view.findViewById(R.id.recycler_todos);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TodoService service = retrofit.create(TodoService.class);
        service.listTodo(mId).enqueue(new Callback<List<Todos>>() {
            @Override
            public void onResponse(Call<List<Todos>> call, Response<List<Todos>> response) {
                //응답

                mProgressBar.setVisibility(View.GONE);
                List<Todos> todosList = response.body();
                Log.d(TAG, "onResponse 크기: " + todosList.size());
                Log.d(TAG, "onResponse: " + todosList);

                adapter = new TodosRecyclerAdapter(todosList);
                mRecycler.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Todos>> call, Throwable t) {
                //실패시
                Toast.makeText(getActivity(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
       return view;
    }
}
