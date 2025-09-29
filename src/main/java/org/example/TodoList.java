package org.example;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
    private final List<String> items = new ArrayList<>();

    public void add(String item) {
        if (item != null) {
            item = item.trim();
            if (!item.isEmpty()) {
                items.add(item);
            }
        }
    }

    public boolean remove(int index){
        if (index >= 0 && index < items.size()) {
            items.remove(index);
            return true;
        }
        return false;
    }

    public  boolean markDone(int index) {
        if (index >= 0 && index < items.size()) {
            String item = items.get(index);
            items.set(index, "[DONE] " + item);
            return true;
        }
        return false;
    }

    public  void clear() {
        items.clear();
    }

    public  List<String> search(String query) {
        List<String> result = new ArrayList<>();
        for (String item : items) {
            if (item.contains(query)) {
                result.add(item);
            }
        }
        return result;
    }


    public List<String> getAll() {
        return new ArrayList<>(items);
    }

    public int size() {
        return items.size();
    }
}
