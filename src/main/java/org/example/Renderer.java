package org.example;

import javax.swing.*;
import java.awt.*;

public class Renderer extends JPanel {
    private Board board;
    private int cellSize;

    public Renderer(Board board, int cellSize) {
        this.board = board;
        this.cellSize = cellSize;
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
                g.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
            }
        }
    }
}
