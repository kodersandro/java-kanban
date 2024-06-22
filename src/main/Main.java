package main;

import service.TaskManager;
import model.Task;
import model.Epic;
import model.Subtask;
import model.Status;
import java.util.ArrayList;



public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        // Создание двух задач
        Task task1 = new Task(0, "Задача 1", "Описание задачи 1", Status.NEW);
        Task task2 = new Task(0, "Задача 2", "Описание задачи 2", Status.NEW);
        taskManager.addTask(task1);
        taskManager.addTask(task2);

        // Создание первого эпика с двумя подзадачами
        Epic epic1 = new Epic(0, "Эпик 1", "Описание эпика 1", Status.NEW, new ArrayList<>());
        taskManager.addEpic(epic1);
        Subtask subTask1_1 = new Subtask(0, "Подзадача 1.1", "Описание подзадачи 1.1", Status.NEW, epic1.getId());
        Subtask subTask1_2 = new Subtask(0, "Подзадача 1.2", "Описание подзадачи 1.2", Status.NEW, epic1.getId());
        taskManager.addSubtask(subTask1_1);
        taskManager.addSubtask(subTask1_2);

        // Создание второго эпика с одной подзадачей
        Epic epic2 = new Epic(0, "Эпик 2", "Описание эпика 2", Status.NEW, new ArrayList<>());
        taskManager.addEpic(epic2);
        Subtask subTask2_1 = new Subtask(0, "Подзадача 2.1", "Описание подзадачи 2.1", Status.NEW, epic2.getId());
        taskManager.addSubtask(subTask2_1);

        // Вывод всех задач
        ArrayList<Task> allTasks = taskManager.getAllTasks();
        System.out.println("Список всех задач:");
        for (Task task : allTasks) {
            System.out.println(task);
        }

        // Вывод всех эпиков
        ArrayList<Epic> allEpics = taskManager.getAllEpics();
        System.out.println("\nСписок всех эпиков:");
        for (Epic epic : allEpics) {
            System.out.println(epic);
        }

        // Вывод всех подзадач
        ArrayList<Subtask> allSubTasks = taskManager.getAllSubtasks();
        System.out.println("\nСписок всех подзадач:");
        for (Subtask subtask : allSubTasks) {
            System.out.println(subtask);
        }

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

        // Вывод обновленных задач
        System.out.println("\nОбновленный список всех задач:");
        for (Task task : allTasks) {
            System.out.println(task);
        }

        // Вывод обновленных эпиков
        System.out.println("\nОбновленный список всех эпиков:");
        for (Epic epic : allEpics) {
            System.out.println(epic);
        }

        // Вывод обновленных подзадач
        System.out.println("\nОбновленный список всех подзадач:");
        for (Subtask subtask : allSubTasks) {
            System.out.println(subtask);
        }

        // Удаление задачи и эпика
        taskManager.deleteTaskById(task1.getId());
        taskManager.deleteEpicById(epic1.getId());

        // Вывод после удаления
        System.out.println("\nСписок всех задач после удаления:");
        allTasks = taskManager.getAllTasks();
        for (Task task : allTasks) {
            System.out.println(task);
        }

        System.out.println("\nСписок всех эпиков после удаления:");
        allEpics = taskManager.getAllEpics();
        for (Epic epic : allEpics) {
            System.out.println(epic);
        }

        System.out.println("\nСписок всех подзадач после удаления:");
        allSubTasks = taskManager.getAllSubtasks();
        for (Subtask subtask : allSubTasks) {
            System.out.println(subtask);
        }
    }
}

