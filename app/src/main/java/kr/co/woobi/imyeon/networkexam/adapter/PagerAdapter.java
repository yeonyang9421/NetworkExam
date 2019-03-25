package kr.co.woobi.imyeon.networkexam.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import kr.co.woobi.imyeon.networkexam.fragment.PhotoFragment;
import kr.co.woobi.imyeon.networkexam.fragment.TodosFragment;

public  class PagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mData;

    public PagerAdapter(FragmentManager fm) {
        super(fm);
//
//            mData.add(PhotoFragment.newInstance(1));
//            mData.add(TodosFragment.newInstance(1));
        mData=new ArrayList<>();
        mData.add(new PhotoFragment());
        mData.add(new TodosFragment());

    }

    @Override
    public Fragment getItem(int i) {
        return mData.get(i);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "title";
        if(position==0){
            title="photo page";
        }else if (position==1){
            title="todos page";
        }
        return title;
    }
}