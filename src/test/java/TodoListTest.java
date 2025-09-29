import org.example.TodoList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TodoListTest {
    @Test
    void addAndList() {
        TodoList t = new TodoList();
        t.add(" task1 ");
        assertEquals(1, t.size());
        assertEquals("task1", t.getAll().getFirst());
    }
    @Test
    void remove() {
        TodoList t = new TodoList();
        t.add("a");
        t.add("b");
        assertTrue(t.remove(0));
        assertEquals(1, t.size());
        assertFalse(t.remove(10));
    }
    @Test
    void addEmptyIgnored() {
        TodoList t = new TodoList();
        t.add(" ");
        assertEquals(0, t.size());
    }

    @Test
    void testMarkDone() {
        TodoList t = new TodoList();
        t.add("a");
        t.add("b");

        assertTrue(t.markDone(0));
        assertTrue(t.markDone(1));

        List<String> allTasks = t.getAll();
        assertTrue(allTasks.get(0).startsWith("[DONE]"));
        assertTrue(allTasks.get(1).startsWith("[DONE]"));
        assertTrue(allTasks.get(0).contains("a"));
    }
    @Test
    void testClear() {
        TodoList t = new TodoList();
        t.add("1");
        t.add("2");
        t.add("3");

        assertEquals(3, t.size());

        t.clear(); // Очищаем все

        assertEquals(0, t.size());
        assertTrue(t.getAll().isEmpty());
    }
    @Test
    void testSearch() {
        TodoList t = new TodoList();
        t.add("1");
        t.add("2");
        t.add("3");
        t.add("4");

        List<String> exactResults = t.search("3");
        assertEquals(1, exactResults.size());
        assertEquals("3", exactResults.get(0));
    }
}
