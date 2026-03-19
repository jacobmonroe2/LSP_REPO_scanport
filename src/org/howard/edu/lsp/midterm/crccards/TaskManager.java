package org.howard.edu.lsp.midterm.crccards;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void displayTasks() {
        for (Task t : tasks) {
            System.out.println("Task: " + t.getDescription() + " | Done: " + t.isCompleted());
        }
    }
}