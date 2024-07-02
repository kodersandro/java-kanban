package main;

import model.Epic;
import model.Status;
import model.Subtask;
import model.Task;
import service.Managers;
import service.TaskManager;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = Managers.getDefault();

        Task task1 = new Task(0, "Задача 1", "Описание задачи 1", Status.NEW);
        Task task2 = new Task(0, "Задача 2", "Описание задачи 2", Status.NEW);
        taskManager.addTask(task1);
        taskManager.addTask(task2);

        Epic epic1 = new Epic(0, "Эпик 1", "Описание эпика 1", Status.NEW, new ArrayList<>());
        taskManager.addEpic(epic1);
        Subtask subTask1_1 = new Subtask(0, "Подзадача 1.1", "Описание подзадачи 1.1", Status.NEW, epic1.getId());
        Subtask subTask1_2 = new Subtask(0, "Подзадача 1.2", "Описание подзадачи 1.2", Status.NEW, epic1.getId());
        taskManager.addSubtask(subTask1_1);
        taskManager.addSubtask(subTask1_2);

        Epic epic2 = new Epic(0, "Эпик 2", "Описание эпика 2", Status.NEW, new ArrayList<>());
        taskManager.addEpic(epic2);
        Subtask subTask2_1 = new Subtask(0, "Подзадача 2.1", "Описание подзадачи 2.1", Status.NEW, epic2.getId());
        taskManager.addSubtask(subTask2_1);

        taskManager.getTaskById(task1.getId());
        printAllTasks(taskManager);

        taskManager.getTaskById(task2.getId());
        printAllTasks(taskManager);

        taskManager.getEpicById(epic1.getId());
        printAllTasks(taskManager);

        taskManager.getSubtaskById(subTask1_1.getId());
        printAllTasks(taskManager);

        taskManager.getSubtaskById(subTask1_2.getId());
        printAllTasks(taskManager);

        taskManager.getEpicById(epic2.getId());
        printAllTasks(taskManager);

        taskManager.getSubtaskById(subTask2_1.getId());
        printAllTasks(taskManager);
    }

    private static void printAllTasks(TaskManager manager) {
        System.out.println("Задачи:");
        for (Task task : manager.getTasks()) {
            System.out.println(task);
        }
        System.out.println("Эпики:");
        for (Task epic : manager.getEpics()) {
            System.out.println(epic);

            for (Task task : manager.getEpicSubtasks(epic.getId())) {
                System.out.println("--> " + task);
            }
        }
        System.out.println("Подзадачи:");
        for (Task subtask : manager.getSubtasks()) {
            System.out.println(subtask);
        }

        System.out.println("История:");
        for (Task task : manager.getHistory()) {
            System.out.println(task);
        }
    }
}
