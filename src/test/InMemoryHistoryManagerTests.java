package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.InMemoryHistoryManager;
import service.HistoryManager;
import model.Task;
import model.Status;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class InMemoryHistoryManagerTests {

    private HistoryManager historyManager;

    @BeforeEach
    public void setUp() {
        historyManager = new InMemoryHistoryManager();
    }

    @Test
    public void testAddToHistory() {
        Task task = new Task(1, "Test Task", "Test Description", Status.NEW);
        historyManager.add(task);
        List<Task> history = historyManager.getHistory();
        assertEquals(1, history.size());
        assertTrue(history.contains(task));
    }


}
