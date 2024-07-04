package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.InMemoryTaskManager;
import service.TaskManager;
import model.Task;
import model.Epic;
import model.Subtask;
import model.Status;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class InMemoryTaskManagerTests {

    private TaskManager taskManager;

    @BeforeEach
    public void setUp() {
        taskManager = new InMemoryTaskManager();
    }

    @Test
    public void testAddTask() {
        Task task = new Task(1, "Test Task", "Test Description", Status.NEW);
        taskManager.addTask(task);
        assertEquals(1, taskManager.getAllTasks().size());
    }

    @Test
    public void testAddEpic() {
        Epic epic = new Epic(1, "Test Epic", "Test Epic Description", Status.NEW, new ArrayList<>());
        taskManager.addEpic(epic);
        assertEquals(1, taskManager.getAllEpics().size());
    }

    @Test
    public void testAddSubtask() {
        Epic epic = new Epic(1, "Test Epic", "Test Epic Description", Status.NEW, new ArrayList<>());
        taskManager.addEpic(epic);
        Subtask subtask = new Subtask(1, "Test Subtask", "Test Subtask Description", Status.NEW, epic.getId());
        taskManager.addSubtask(subtask);
        assertEquals(1, taskManager.getAllSubtasks().size());
    }


}

