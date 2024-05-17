package org.example;

public class Cell {
    private boolean isSand;

    public Cell(boolean isSand) {
        this.isSand = isSand;
    }

    public boolean isSand() {
        return isSand;
    }

    public void setSand(boolean sand) {
        isSand = sand;
    }
}
