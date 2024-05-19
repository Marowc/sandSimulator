package org.example;

import javax.swing.*;
import java.awt.*;

public class SandSimulator {
    private Board board;
    private Renderer renderer;
    private Controler controler;
    private ButtonsPanel buttonsPanel;
    private boolean isRunning;
    Thread[] threads;
    Thread renderThread;
    private static final int CELL_SIZE = 8;
    private static final int WIDTH = 800;
    private static final int HEIGTH = 640+28;
    private static final int NUM_OF_THREADS = 3;


    public SandSimulator() {
        board = new Board(80,80);
        renderer = new Renderer(board, CELL_SIZE);
        controler = new Controler(board, CELL_SIZE);
        buttonsPanel = new ButtonsPanel(this);

        JFrame frame = new JFrame("Sand Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel simulationPanel = new JPanel();
        simulationPanel.setLayout(new OverlayLayout(simulationPanel));
        simulationPanel.add(renderer);
        simulationPanel.add(controler);

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BorderLayout());
        menuPanel.add(buttonsPanel);

        mainPanel.add(simulationPanel, BorderLayout.CENTER);
        mainPanel.add(menuPanel, BorderLayout.EAST);

        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setSize(WIDTH, HEIGTH);
        frame.setVisible(true);

        isRunning = false;
        threads = new Thread[NUM_OF_THREADS];
    }

    /*public void start(){
        isRunning = true;

        new Thread(() -> {
            while(isRunning){
                board.update();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            while(isRunning){
                renderer.repaint();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }*/

    public void start() {
        if (!isRunning) {
            isRunning = true;
            int step = board.getHeight() / NUM_OF_THREADS;
            int rest = board.getHeight() % NUM_OF_THREADS;
            int begin = 0, end = 0;

            for (int n = 0; n < NUM_OF_THREADS; n++) {
                begin = end;
                end += (n == NUM_OF_THREADS - 1) ? step + rest : step;

                int threadBegin = begin;
                int threadEnd = end;
                threads[n] = new Thread(() -> {
                    while (isRunning) {
                        board.updatePart(threadBegin, threadEnd);
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
                threads[n].setName("updateThread-" + n);
                threads[n].start();
            }

            renderThread = new Thread(() -> {
                while (isRunning) {
                    renderer.repaint();
                }
            });
            renderThread.setName("renderThread");
            renderThread.start();
        }
    }

    public void stop() {
        isRunning = false;
        for (int i = 0; i < NUM_OF_THREADS; i++) {
            if (threads[i] != null) {
                try {
                    threads[i].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        if (renderThread != null) {
            try {
                renderThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void restart() {
        board.initializeBoard();
        if (!isRunning) renderer.repaint();
    }
}
