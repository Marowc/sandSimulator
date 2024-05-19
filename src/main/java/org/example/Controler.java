package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Controler extends JPanel implements MouseListener, MouseMotionListener {
    private Board board;
    private int cellSize;

    public Controler(Board board, int cellSize) {
        this.board = board;
        this.cellSize = cellSize;
        addMouseListener(this);
        addMouseMotionListener(this);
        setOpaque(false);
    }

    private void addSand(int mouseX, int mouseY) {
        int x = mouseX / cellSize;
        int y = mouseY / cellSize;
        if (x >= 0 && x < board.getWidth() && y >= 0 && y < board.getHeight()) {
            board.setCell(x, y, true);
            repaint();
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        addSand(e.getX(), e.getY());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        addSand(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }
}
