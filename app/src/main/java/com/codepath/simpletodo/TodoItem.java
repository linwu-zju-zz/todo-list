package com.codepath.simpletodo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lin on 12/14/15.
 */
public class TodoItem {
    public String content;
    public String location;

    public TodoItem(String content, String location) {
        this.content = content;
        this.location = location;
    }

    public static List<TodoItem> createItemList(int count) {
        List<TodoItem> list = new ArrayList<>();
        for (int i = 0; i < count; ++i) {
            list.add(new TodoItem("Current Location", "(37.78, -122.41)"));
        }
        return list;
    }

}
