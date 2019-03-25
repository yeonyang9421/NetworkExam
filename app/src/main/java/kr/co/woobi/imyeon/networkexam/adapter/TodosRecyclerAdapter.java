package kr.co.woobi.imyeon.networkexam.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import kr.co.woobi.imyeon.networkexam.R;
import kr.co.woobi.imyeon.networkexam.model.Todos;

public class TodosRecyclerAdapter extends RecyclerView.Adapter<TodosRecyclerAdapter.ViewHolder> {
    List<Todos> mItem = new ArrayList<>();

    public TodosRecyclerAdapter(List<Todos> mItem) {
        this.mItem = mItem;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_todos,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Todos todos=mItem.get(i);
        viewHolder.textView.setText(todos.getTitle());
        viewHolder.checkBox.setChecked(todos.isCompleted());

    }

    @Override
    public int getItemCount() {
        return mItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView, textViewId;
        CheckBox checkBox;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.text_todos_title);
            checkBox=itemView.findViewById(R.id.check_todos);
        }
    }
}
