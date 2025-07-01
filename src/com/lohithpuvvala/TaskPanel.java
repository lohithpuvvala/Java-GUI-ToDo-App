package com.lohithpuvvala;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskPanel {
    private JPanel panel;
    private JLabel taskLabel;
    private JButton deleteButton;
    private ToDoApp parent;

    public TaskPanel(Task task, ToDoApp parent) {
        this.parent = parent;
        panel = new JPanel(new BorderLayout());
        taskLabel = new JLabel(task.getDescription());
        deleteButton = new JButton("Delete");

        panel.add(taskLabel, BorderLayout.CENTER);
        panel.add(deleteButton, BorderLayout.EAST);

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.removeTask(TaskPanel.this);
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}
