package view.window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Program {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Программа");

        // Создание панели с макетом BorderLayout
        JPanel panel = new JPanel(new BorderLayout());

        // Создание текстового поля и кнопки
        JTextField textField = new JTextField();
        JButton button = new JButton("Применить");

        // Добавление обработчика событий для кнопки
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Отображение приветствия с использованием введенного текста
                JOptionPane.showMessageDialog(frame, "Добро пожаловать, " + textField.getText() + "!");
            }
        });

        // Добавление компонентов на панель
        panel.add(textField, BorderLayout.CENTER);
        panel.add(button, BorderLayout.SOUTH);

        // Добавление панели на фрейм и настройка размеров
        frame.getContentPane().add(panel);
        frame.setPreferredSize(new Dimension(300, 100));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null); // Позиционирование по центру
        frame.setVisible(true);
    }
}
