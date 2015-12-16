package com.codepath.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public List<TodoItem> todoItems;
    RecyclerView rvItems;
    TodoItemAdapter adapter;
    private final int EditActivity = 0;
    private int editedPos = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvItems = (RecyclerView) findViewById(R.id.rvTodoItems);
        todoItems = TodoItem.createItemList(1);
        rvItems.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        adapter = new TodoItemAdapter(todoItems);
        rvItems.setAdapter(adapter);
        //setupListViewListener();
        //setupEditListener();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == EditActivity) {
            String content = data.getExtras().getString("Content");
            String location = data.getExtras().getString("Location");
            TodoItem item = new TodoItem(content, location);
            todoItems.remove(editedPos);
            todoItems.add(editedPos, item);
            //TodoItemAdapter.notifyDataSetInvalidated();
        }
    }

    private void setupEditListener() {
        rvItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TodoItem item = todoItems.get(1);
                startEditItemActivity(item.content);

            }
        });
    }

    private void startEditItemActivity(String content) {
        Intent intent = new Intent(this, EditItemActivity.class);
        intent.putExtra("Content", content);
        startActivityForResult(intent, EditActivity);
    }


    /*private void setupListViewListener() {
        lvItems.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapter, View item, int pos, long id) {
                        todoItems.remove(pos);
                        //adapter.notifyDataSetInvalidated();
                        return true;
                    }
                }
        );
    }*/

    public void onAddItem(View v) {
        EditText etNewItem = (EditText)findViewById(R.id.etNewItem);
        String itemText = etNewItem.getText().toString();
        todoItems.add(new TodoItem(itemText, "(39.9, 116.4)"));
        etNewItem.setText("");
        //writeItems();
    }

    /*private void readItems() {
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");
        try {
            todoItems = new ArrayList<String>(FileUtils.readLines(todoFile));
        } catch (IOException e) {
            todoItems = new ArrayList<String>();
        }

    }

    private void writeItems() {
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");
        try {
            FileUtils.writeLines(todoFile, items);
        } catch (IOException e){
            e.printStackTrace();
        }
    }*/

}
