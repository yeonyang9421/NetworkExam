package kr.co.woobi.imyeon.networkexam.adapter;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import kr.co.woobi.imyeon.networkexam.EventImageResize;
import kr.co.woobi.imyeon.networkexam.EventUserItem;
import kr.co.woobi.imyeon.networkexam.TransitionTargetActivity;
import kr.co.woobi.imyeon.networkexam.model.Photo;
import kr.co.woobi.imyeon.networkexam.R;

public class PhotoRecyclerAdapter extends RecyclerView.Adapter<PhotoRecyclerAdapter.ViewHolder>{

/*
    public interface OnClickImageResizeListener{
        void onImageResize(String thumbnailUrl);
    }
    private OnClickImageResizeListener mListener;

    public void setOnClickImageResizeListener(OnClickImageResizeListener listener){
        mListener=listener;
    }
*/


        List<Photo> mItems = new ArrayList<>();

    public PhotoRecyclerAdapter(List<Photo> mItems) {
        this.mItems = mItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_photo, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        final Photo photo = mItems.get(i);
        //viewHolder.imageView.setImageResource(u);
        Glide.with(viewHolder.itemView)
                .load(photo.getThumbnailUrl())
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .into(viewHolder.imageView);

        viewHolder.textView.setText(photo.getTitle());
        viewHolder.textViewId.setText(photo.getId()+"");

        viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EventBus.getDefault().post(new EventImageResize(mItems.get(viewHolder.getAdapterPosition())));
//               mListener.onImageResize(photo.getThumbnailUrl());
//                Intent intent = new Intent(v.getContext(), TransitionTargetActivity.class);
//                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(v.getContext(), v, "ani");
//                ActivityCompat.startActivity(this,intent,options.toBundle());
            }
        });

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        TextView textViewId;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_thum);
            textView = itemView.findViewById(R.id.text_title);
            textViewId = itemView.findViewById(R.id.text_photos_id);

        }
    }
}
