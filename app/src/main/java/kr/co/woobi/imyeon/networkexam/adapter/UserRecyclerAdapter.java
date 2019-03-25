package kr.co.woobi.imyeon.networkexam.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import kr.co.woobi.imyeon.networkexam.EventUserItem;
import kr.co.woobi.imyeon.networkexam.R;
import kr.co.woobi.imyeon.networkexam.model.Users;

public class UserRecyclerAdapter extends RecyclerView.Adapter<UserRecyclerAdapter.ViewHolder> {
    List<Users>  mItem=new ArrayList<>();

    public UserRecyclerAdapter(List<Users> mItem) {
        this.mItem = mItem;
    }

/*    //인터페이스 정의
    public  interface  OnSelectUserListener{
        void onSelect(int position);
    }

    private OnSelectUserListener mListener;

    public void setOnSelectUserListener(OnSelectUserListener listener){
        mListener = listener;

    }*/

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_user, viewGroup, false);

       final ViewHolder viewHolder = new ViewHolder(view);
       viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
         /*      if(mListener !=null){
                   Users users = mItem.get(viewHolder.getAdapterPosition());
                   mListener.onSelect(viewHolder.getAdapterPosition());
               }*/
               Toast.makeText(viewGroup.getContext(), ""+viewHolder.getAdapterPosition(), Toast.LENGTH_SHORT).show();
               EventBus.getDefault().post(new EventUserItem(mItem.get(viewHolder.getAdapterPosition())));

           }
       });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Users users=mItem.get(i);
        viewHolder.textView.setText(users.getUsername());
        viewHolder.textViewId.setText(users.getId()+"");

    }

    @Override
    public int getItemCount() {
        return mItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        TextView textViewId;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.text_users_id);
            textViewId=itemView.findViewById(R.id.text_id);
        }
    }
}
