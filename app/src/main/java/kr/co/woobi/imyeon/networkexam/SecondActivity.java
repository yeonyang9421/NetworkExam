package kr.co.woobi.imyeon.networkexam;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;


import kr.co.woobi.imyeon.networkexam.adapter.PagerAdapter;
import kr.co.woobi.imyeon.networkexam.fragment.PhotoFragment;
import kr.co.woobi.imyeon.networkexam.fragment.TodosFragment;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TabLayout tabLayout = findViewById(R.id.tab);
        ViewPager viewPager = findViewById(R.id.pager);

        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        Toast.makeText(this, ""+id, Toast.LENGTH_SHORT).show();
        PhotoFragment.newInstance(id);
        TodosFragment.newInstance(id);

        PagerAdapter pageradapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pageradapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EventImageResize event) {
        String imageUrl=event.photo.getThumbnailUrl();
        Toast.makeText(this, "" +event, Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, TransitionTargetActivity.class);
        intent.putExtra("image",imageUrl);
        startActivity(intent);
//        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this,   ,"ani");
//        ActivityCompat.startActivity(this,intent,options.toBundle());

    }


    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

}
