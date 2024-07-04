package test;

import model.Status;
import model.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTests {

    @Test
    public void testTaskInitialization() {
        Task task = new Task(1, "Test Task", "Description", Status.NEW);

        Assertions.assertEquals(1, task.getId());
        Assertions.assertEquals("Test Task", task.getTitle());
        Assertions.assertEquals("Description", task.getDescription());
        Assertions.assertEquals(Status.NEW, task.getStatus());
    }

    @Test
    public void testTaskStatusUpdate() {
        Task task = new Task(1, "Test Task", "Description", Status.NEW);
        task.setStatus(Status.IN_PROGRESS);

        Assertions.assertEquals(Status.IN_PROGRESS, task.getStatus());
    }

}

