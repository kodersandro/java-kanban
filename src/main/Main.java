package main;

import service.Managers;
import service.TaskManager;
import model.Task;
import model.Epic;
import model.Subtask;
import model.Status;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = Managers.getDefault();

        // Создание двух задач
        Task task1 = new Task(0, "Задача 1", "Описание задачи 1", Status.NEW);
        Task task2 = new Task(0, "Задача 2", "Описание задачи 2", Status.NEW);
        taskManager.addTask(task1);
        taskManager.addTask(task2);

        // Печать всех задач после создания задач
        printAllTasks(taskManager);

        // Создание первого эпика с двумя подзадачами
        Epic epic1 = new Epic(0, "Эпик 1", "Описание эпика 1", Status.NEW, new ArrayList<>());
        taskManager.addEpic(epic1);
        Subtask subTask1_1 = new Subtask(0, "Подзадача 1.1", "Описание подзадачи 1.1", Status.NEW, epic1.getId());
        Subtask subTask1_2 = new Subtask(0, "Подзадача 1.2", "Описание подзадачи 1.2", Status.NEW, epic1.getId());
        taskManager.addSubtask(subTask1_1);
        taskManager.addSubtask(subTask1_2);

        // Печать всех задач после создания первого эпика
        printAllTasks(taskManager);

        // Создание второго эпика с одной подзадачей
        Epic epic2 = new Epic(0, "Эпик 2", "Описание эпика 2", Status.NEW, new ArrayList<>());
        taskManager.addEpic(epic2);
        Subtask subTask2_1 = new Subtask(0, "Подзадача 2.1", "Описание подзадачи 2.1", Status.NEW, epic2.getId());
        taskManager.addSubtask(subTask2_1);

        // Печать всех задач после создания второго эпика
        printAllTasks(taskManager);

        // Получение задач и эпиков для обновления истории
        taskManager.getTaskById(task1.getId());
        taskManager.getTaskById(task2.getId());
        taskManager.getEpicById(epic1.getId());
        taskManager.getSubtaskById(subTask1_1.getId());
        taskManager.getSubtaskById(subTask1_2.getId());
        taskManager.getEpicById(epic2.getId());
        taskManager.getSubtaskById(subTask2_1.getId());

        // Печать истории просмотров после получения задач и эпиков
        printAllTasks(taskManager);

        // Изменение статусов задач и подзадач
        task1.setStatus(Status.IN_PROGRESS);
        task2.setStatus(Status.DONE);
        subTask1_1.setStatus(Status.IN_PROGRESS);
        subTask1_2.setStatus(Status.DONE);
        subTask2_1.setStatus(Status.DONE);

        // Обновление задач в менеджере
        taskManager.updateTask(task1);
        taskManager.updateTask(task2);
        taskManager.updateSubtask(subTask1_1);
        taskManager.updateSubtask(subTask1_2);
        taskManager.updateSubtask(subTask2_1);

        // Печать всех задач после обновления статусов
        printAllTasks(taskManager);

        // Удаление задачи и эпика
        taskManager.deleteTaskById(task1.getId());
        taskManager.deleteEpicById(epic1.getId());

        // Печать всех задач после удаления
        printAllTasks(taskManager);
    }

    private static void printAllTasks(TaskManager manager) {
        System.out.println("Задачи:");
        for (Task task : manager.getAllTasks()) {
            System.out.println(task);
        }
        System.out.println("Эпики:");
        for (Epic epic : manager.getAllEpics()) {
            System.out.println(epic);
            for (Subtask subtask : manager.getSubTasksOfEpic(epic.getId())) {
                System.out.println("--> " + subtask);
            }
        }
        System.out.println("Подзадачи:");
        for (Subtask subtask : manager.getAllSubtasks()) {
            System.out.println(subtask);
        }

        System.out.println("История:");
        for (Task task : manager.getHistory()) {
            System.out.println(task);
        }
    }
}


