package org.example;

import javax.swing.*;
import java.awt.*;

public class Renderer extends JPanel {
    private Board board;

    public Renderer(Board board) {
        this.board = board;
        JFrame frame = new JFrame("SandSimulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setSize(800, 800);
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Cell[][] cells = board.getCells();
        for (int y = 0; y < board.getHeight(); y++) {
            for (int x = 0; x < board.getWidth(); x++) {
                if (cells[y][x].isSand()) {
                    g.setColor(Color.YELLOW);
                } else {
                    g.setColor(Color.BLACK);
                }
                g.fillRect(x * 8, y * 8, 8, 8); // Rozmiar pojedynczej komórki
            }
        }
    }
}
