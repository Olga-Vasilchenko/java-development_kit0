package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GameWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 555; // высота
    private static final int WINDOW_WIDTH = 507; // ширина
    private static final int WINDOW_POSX = 0; // положение окна по оси X
    private static final int WINDOW_POSY = 0; // положение окна по оси Y

    // пишем элементы графического интерфейса
    JButton btnStart = new JButton("New Game"); // новая игра
    JButton btnExit = new JButton("Exit"); // завершение игры
    Map map;
    SettingsWindow settings;

    GameWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE); // завершение программы вместе с закрытием окна
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT); // устанавливаем в конструкторе размеры и размещение
        setTitle("TicTacToe"); // пишем заголовок
        setResizable(false); // запрещаем пользователю менять размеры окна

        map = new Map();
        settings = new SettingsWindow(this); // объект в качестве ссылки передает себя
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setVisible(true);
            }
        });

        JPanel panBottom = new JPanel(new GridLayout(1, 2)); // панель
        panBottom.add(btnStart);
        panBottom.add(btnExit);
        add(panBottom, BorderLayout.SOUTH);
        add(map);
        setVisible(true); // делаем окошко видимым
    }

    void startNewGame(int mode, int fSzX, int fSzY, int wLen) {
        map.startNewGame(mode, fSzX, fSzY, wLen);
    }
}
