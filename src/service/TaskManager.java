package service;

import model.Task;
import model.Epic;
import model.Subtask;
import model.Status;
import java.util.ArrayList;
import java.util.HashMap;

public class TaskManager {
    int nextId = 1;
    HashMap<Integer, Task> tasks = new HashMap<>();
    HashMap<Integer, Subtask> subTasks = new HashMap<>();
    HashMap<Integer, Epic> epics = new HashMap<>();


    public void addTask(Task task) {
        task.setId(nextId++);
        tasks.put(task.getId(), task);
    }

    public void addEpic(Epic epic) {
        epic.setId(nextId++);
        epics.put(epic.getId(), epic);
    }

    public void addSubtask(Subtask subtask) {
        subtask.setId(nextId++);
        subTasks.put(subtask.getId(), subtask);
        Epic epic = epics.get(subtask.getEpicId());
        if (epic != null) {
            epic.getSubTasks().add(subtask.getId());
            updateEpicStatus(epic.getId());
        }
    }


    public Task getTaskById(int id) {
        return tasks.get(id);
    }

    public Epic getEpicById(int id) {
        return epics.get(id);
    }

    public Subtask getSubtaskById(int id) {
        return subTasks.get(id);
    }

    public ArrayList<Task> getAllTasks() {
        return new ArrayList<>(tasks.values());
    }

    public ArrayList<Epic> getAllEpics() {
        return new ArrayList<>(epics.values());
    }

    public ArrayList<Subtask> getAllSubtasks() {
        return new ArrayList<>(subTasks.values());
    }

    public ArrayList<Subtask> getSubTasksOfEpic(int epicId) {
        ArrayList<Subtask> result = new ArrayList<>();
        Epic epic = epics.get(epicId);
        if (epic != null) {
            for (Integer subTaskId : epic.getSubTasks()) {
                result.add(subTasks.get(subTaskId));
            }
        }
        return result;
    }

    public void updateTask(Task task) {
        tasks.put(task.getId(), task);
    }

    public void updateEpic(Epic epic) {
        epics.put(epic.getId(), epic);
        updateEpicStatus(epic.getId());
    }

    public void updateSubtask(Subtask subtask) {
        subTasks.put(subtask.getId(), subtask);
        Epic epic = epics.get(subtask.getEpicId());
        if (epic != null) {
            updateEpicStatus(epic.getId());
        }
    }


    public void deleteTaskById(int id) {
        tasks.remove(id);
    }

    public void deleteEpicById(int id) {
        Epic epic = epics.remove(id);
        if (epic != null) {
            for (Integer subTaskId : epic.getSubTasks()) {
                subTasks.remove(subTaskId);
            }
        }
    }

    public void deleteSubtaskById(int id) {
        Subtask subtask = subTasks.remove(id);
        if (subtask != null) {
            Epic epic = epics.get(subtask.getEpicId());
            if (epic != null) {
                epic.getSubTasks().remove(Integer.valueOf(subtask.getId()));
                updateEpicStatus(epic.getId());
            }
        }
    }

    public void deleteAllTasks() {
        tasks.clear();
    }

    public void deleteAllEpics() {
        epics.clear();
        subTasks.clear();
    }

    public void deleteAllSubtasks() {
        subTasks.clear();
        for (Epic epic : epics.values()) {
            epic.getSubTasks().clear();
            updateEpicStatus(epic.getId());
        }
    }

    private void updateEpicStatus(int epicId) {
        Epic epic = epics.get(epicId);
        if (epic != null) {
            boolean allNew = true;
            boolean allDone = true;
            for (Integer subTaskId : epic.getSubTasks()) {
                Status status = subTasks.get(subTaskId).getStatus();
                if (status != Status.NEW) {
                    allNew = false;
                }
                if (status != Status.DONE) {
                    allDone = false;
                }
            }
            if (allNew) {
                epic.setStatus(Status.NEW);
            } else if (allDone) {
                epic.setStatus(Status.DONE);
            } else {
                epic.setStatus(Status.IN_PROGRESS);
            }
        }
    }
}

