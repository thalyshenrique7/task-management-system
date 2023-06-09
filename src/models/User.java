package models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class User {

    private String name;
    private int age;
    private List<Task> tasks;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
        this.tasks = new ArrayList<>();
    }

    public int quantityTasks(){
        return tasks.size();
    }

    public List<Task> findAll(){
        return tasks.stream()
                .map(task -> {
                    task.getTaskName();
                    return task;
                }).collect(Collectors.toList());
    }

    public void addTask(Task task){
        tasks.add(task);
    }

    public void deleteTask(Task task){
        if(findAll().isEmpty()){
            System.out.println("Não existem tarefas cadastradas.");
        }
        tasks.remove(task);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", tasks=" + tasks +
                '}';
    }
}
