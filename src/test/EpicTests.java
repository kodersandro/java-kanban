package test;

import model.Epic;
import model.Status;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class EpicTests {

    @Test
    public void testEpicInitialization() {
        ArrayList<Integer> subTasks = new ArrayList<>();
        Epic epic = new Epic(1, "Test Epic", "Description", Status.NEW, subTasks);

        Assertions.assertEquals(1, epic.getId());
        Assertions.assertEquals("Test Epic", epic.getTitle());
        Assertions.assertEquals("Description", epic.getDescription());
        Assertions.assertEquals(Status.NEW, epic.getStatus());
        Assertions.assertEquals(subTasks, epic.getSubTasks());
    }


}
