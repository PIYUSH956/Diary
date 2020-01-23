package com.piyushjaiswal121.diary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.MyViewHolder> {
private Context context;
private List<Task> taskList;

    public TaskAdapter(Context context, List<Task> taskList) {
        this.context = context;
        this.taskList = taskList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
       view = LayoutInflater.from(context).inflate(R.layout.view_task_list,parent,false);
       MyViewHolder myViewHolder = new MyViewHolder(view);
       return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
       holder.setData(taskList.get(position).getTask_name(),taskList.get(position).getTask_desc(),taskList.get(position).getComment());
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView t1,t2,t3;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            t1= itemView.findViewById(R.id.tvCommnt);
            t2=itemView.findViewById(R.id.tvDesc);
            t3=itemView.findViewById(R.id.tvName);
        }
        public void  setData(String t01,String t02,String t03)
        {
            t1.setText(t01);
            t2.setText(t02);
            t3.setText(t03);
        }
    }
}
