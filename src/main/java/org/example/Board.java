package org.example;

import java.awt.*;

public class Board {
    private Cell[][] cells;
    private int width;
    private int height;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        cells = new Cell[height][width];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                cells[y][x] = new Cell(false);
            }
        }
    }

    public void update() {
        for (int y = height - 2; y >= 0; y--) {
            for (int x = 0; x < width; x++) {
                if (cells[y][x].isSand() && !cells[y + 1][x].isSand()) {
                    cells[y + 1][x].setSand(true);
                    cells[y][x].setSand(false);
                }
            }
        }
    }

    public void setCell(int x, int y, boolean sand){
        cells[x][y].setSand(sand);
    }

    public Cell getCell(int x, int y) {
        return cells[y][x];
    }

    public Cell[][] getCells(){
        return cells;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
