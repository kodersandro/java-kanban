package test;

import model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.InMemoryTaskManager;
import service.TaskManager;

import java.util.ArrayList;

public class TaskManagerTests {

    private TaskManager taskManager;

    @BeforeEach
    public void setUp() {
        taskManager = new InMemoryTaskManager();
    }

    @Test
    public void testAddAndGetTask() {
        Task task = new Task(1, "Test Task", "Description", Status.NEW);
        taskManager.addTask(task);

        Task retrievedTask = taskManager.getTaskById(1);
        Assertions.assertEquals(task, retrievedTask);
    }

    @Test
    public void testAddAndGetEpic() {
        ArrayList<Integer> subTasks = new ArrayList<>();
        Epic epic = new Epic(1, "Test Epic", "Description", Status.NEW, subTasks);
        taskManager.addEpic(epic);

        Epic retrievedEpic = taskManager.getEpicById(1);
        Assertions.assertEquals(epic, retrievedEpic);
    }

    @Test
    public void testAddAndGetSubtask() {
        Subtask subtask = new Subtask(1, "Test Subtask", "Description", Status.NEW, 1);
        taskManager.addSubtask(subtask);

        Subtask retrievedSubtask = taskManager.getSubtaskById(1);
        Assertions.assertEquals(subtask, retrievedSubtask);
    }


}
