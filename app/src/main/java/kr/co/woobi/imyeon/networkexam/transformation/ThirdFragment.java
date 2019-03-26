package kr.co.woobi.imyeon.networkexam.transformation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import kr.co.woobi.imyeon.networkexam.R;

public class ThirdFragment extends Fragment {


    public ThirdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView three = (ImageView) view.findViewById(R.id.fragmentThreeBackground);

        Picasso.get().load("https://github.com/dipanshukr/Viewpager-Transformation/blob/master/app/src/main/res/drawable/three.jpg?raw=true").fit().centerCrop().into(three);
    }
}
