package org.howard.edu.lsp.midterm.crccards;

public class Driver {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        
        manager.addTask(new Task("Submit Midterm"));
        manager.addTask(new Task("Check GitHub Folder"));
        
        System.out.println("Current Tasks:");
        manager.displayTasks();
    }
}