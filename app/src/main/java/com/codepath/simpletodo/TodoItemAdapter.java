package com.codepath.simpletodo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Lin on 12/14/15.
 */
public class TodoItemAdapter extends RecyclerView.Adapter<TodoItemAdapter.TodoItemHolder>{
    List<TodoItem> todoItems;
    static Context context;
    public TodoItemAdapter(List<TodoItem> todoItems) {
        this.todoItems = todoItems;
    }

    @Override
    public TodoItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.layout_item_todo, parent, false);

        TodoItemHolder itemHolder = new TodoItemHolder(contactView);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(TodoItemHolder holder, int position) {
        TodoItem todoItem = todoItems.get(position);
        holder.tvContent.setText(todoItem.content);
        holder.tvLocation.setText(todoItem.location);

    }

    @Override
    public int getItemCount() {
        return todoItems.size();
    }

    public static class TodoItemHolder extends RecyclerView.ViewHolder {
        TextView tvContent;
        TextView tvLocation;

        public TodoItemHolder(View itemView) {
            super(itemView);
            tvContent = (TextView) itemView.findViewById(R.id.tvContent);
            tvLocation = (TextView) itemView.findViewById(R.id.tvLocation);
        }
    }
}
