package program;

import models.Task;
import models.User;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        User user = new User("Jax", 29);
        Task task = new Task("Task 1", "Description 1", "Concluded");
        Task task2 = new Task("Task 2", "Description 2", "Progress");
        Task task3 = new Task("Task 3", "Description 3", "Progress");

        user.addTask(task);
        user.addTask(task2);
        user.addTask(task3);
        System.out.println(user);

        List<Task> taskList = Arrays.asList(task, task2, task3);

        List<Task> getAll = taskList.stream()
                        .map(findTask -> {
                            findTask.getTaskName();
                            return findTask;
                        }).collect(Collectors.toList());

        System.out.println("\nAll Tasks Created");

        getAll.forEach(System.out::println);

        System.out.println("\nTasks with status equals 'Progress'");

        List<Task> filterTask = taskList.stream()
                .filter(findTask -> Objects.equals(findTask.getTaskStatus(), "Progress"))
                .toList();

        filterTask.forEach(System.out::println);

        System.out.println();

        long taskStatusConcluded = taskList.stream()
                .filter(taskConcluded -> taskConcluded.getTaskStatus() == "Concluded")
                .count();

        System.out.println("Quantity tasks with status 'Concluded': " + taskStatusConcluded);

        long taskStatusProgress = taskList.stream()
                .filter(taskProgress -> taskProgress.getTaskStatus() == "Progress")
                .count();

        System.out.println("Quantity tasks with status 'Progress': " + taskStatusProgress);

        System.out.println("\nUpdate Task Status");

        task.update("Task 1", "Progress");
        System.out.println(task);

        long newStatusProgress = taskList.stream()
                .filter(taskProgress -> taskProgress.getTaskStatus() == "Progress")
                .count();

        System.out.println("Quantity tasks with status 'Progress': " + newStatusProgress);
    }
}
