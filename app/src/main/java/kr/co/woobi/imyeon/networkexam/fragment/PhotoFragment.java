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

import kr.co.woobi.imyeon.networkexam.JsonplaceholderService;
import kr.co.woobi.imyeon.networkexam.R;
import kr.co.woobi.imyeon.networkexam.adapter.PhotoRecyclerAdapter;
import kr.co.woobi.imyeon.networkexam.model.Photo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PhotoFragment extends Fragment {
    private int mId = 2;
    private static final String TAG = PhotoFragment.class.getSimpleName();
    private ProgressBar mProgressBar;
    private RecyclerView mRecycler;
    private PhotoRecyclerAdapter adapter;

    public static PhotoFragment newInstance(int id) {
        PhotoFragment photoFragment = new PhotoFragment();
        Bundle args = new Bundle();
        args.putInt("id", id);
        photoFragment.setArguments(args);
        return photoFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mId = getArguments().getInt("id",0);
            Toast.makeText(getContext(), ""+mId, Toast.LENGTH_SHORT).show();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_photo, container, false);

        mProgressBar = view.findViewById(R.id.progressBar);

        mRecycler = view.findViewById(R.id.recycler);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonplaceholderService service = retrofit.create(JsonplaceholderService.class);
        service.listPhots(mId).enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                //응답

                    mProgressBar.setVisibility(View.GONE);
                    List<Photo> photoList = response.body();
                    Log.d(TAG, "onResponse 크기: " + photoList.size());
                    Log.d(TAG, "onResponse: " + photoList);
                    adapter = new PhotoRecyclerAdapter(photoList);
                    mRecycler.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
                //실패시
                Toast.makeText(getActivity(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}

