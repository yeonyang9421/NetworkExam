package kr.co.woobi.imyeon.networkexam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import kr.co.woobi.imyeon.networkexam.model.Photo;

public class TransitionTargetActivity extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_target);
        imageView=findViewById(R.id.imageView);

        Photo photo=new Photo();

        Glide.with(this)
                .load(photo.getThumbnailUrl())
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .into(this.imageView);
    }
}
