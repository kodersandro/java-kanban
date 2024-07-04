package model;

import model.Status;
import model.Subtask;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SubtaskTests {

    @Test
    public void testSubtaskInitialization() {
        Subtask subtask = new Subtask(1, "Test Subtask", "Description", Status.NEW, 1);

        Assertions.assertEquals(1, subtask.getId());
        Assertions.assertEquals("Test Subtask", subtask.getTitle());
        Assertions.assertEquals("Description", subtask.getDescription());
        Assertions.assertEquals(Status.NEW, subtask.getStatus());
        Assertions.assertEquals(1, subtask.getEpicId());
    }


}

