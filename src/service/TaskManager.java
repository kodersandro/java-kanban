package service;

import model.Task;
import model.Epic;
import model.Subtask;

import java.util.List;

public interface TaskManager {
    Task getTaskById(int id);
    Epic getEpicById(int id);
    Subtask getSubtaskById(int id);

    void addTask(Task task);
    void addEpic(Epic epic);
    void addSubtask(Subtask subtask);

    List<Task> getTasks();
    List<Epic> getEpics();
    List<Subtask> getSubtasks();
    List<Subtask> getEpicSubtasks(int epicId);
    List<Task> getHistory();

    void deleteAllTasks();
    void deleteAllEpics();
    void deleteAllSubtasks();
}

