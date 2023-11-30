package Server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ServerRun extends JFrame implements Listener {
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;
    JButton btnStart = new JButton("Start Server");
    JButton btnStop = new JButton("Stop Server");
    ServerListener server;
    List<String> log = new ArrayList<>();

    ServerRun() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Server");
        setResizable(false);
        server = new ChatServer(this);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.listenKey(true);
            }
        });
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.listenKey(false);
            }
        });
        setLayout(new GridLayout(2, 2));
        add(btnStart);
        add(btnStop);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ServerRun();
    }
    @Override
    public void messageRes(String message) {
        System.out.println(message);
        log.add(message);
    }
}
