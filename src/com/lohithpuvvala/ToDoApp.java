package com.lohithpuvvala;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ToDoApp {
    private JFrame frame;
    private JTextField taskInput;
    private JButton addTaskButton;
    private JPanel taskListPanel;
    private List<TaskPanel> tasks;

    public ToDoApp() {
        frame = new JFrame("To-Do App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,600);

        tasks = new ArrayList<>();

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());

        taskInput = new JTextField();
        addTaskButton = new JButton("Add");

        inputPanel.add(taskInput, BorderLayout.CENTER);
        inputPanel.add(addTaskButton, BorderLayout.EAST);

        taskListPanel = new JPanel();
        taskListPanel.setLayout(new BoxLayout(taskListPanel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(taskListPanel);

        frame.getContentPane().add(inputPanel, BorderLayout.NORTH);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        addTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String taskDescription = taskInput.getText().trim();
                if(!taskDescription.isEmpty()){
                    addTask(taskDescription);
                    taskInput.setText("");
                }
            }
        });

        frame.setVisible(true);
    }

    public void addTask(String taskDescription) {
        Task task = new Task(taskDescription);
        TaskPanel taskPanel = new TaskPanel(task, this);
        tasks.add(taskPanel);
        taskListPanel.add(taskPanel.getPanel());
        taskListPanel.revalidate();
        taskListPanel.repaint();
    }

    public void removeTask(TaskPanel taskPanel) {
        tasks.remove(taskPanel);
        taskListPanel.remove(taskPanel.getPanel());
        taskListPanel.revalidate();
        taskListPanel.repaint();
    }
}
