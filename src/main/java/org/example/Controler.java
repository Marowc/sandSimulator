package org.example;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Controler extends JPanel implements MouseListener, MouseMotionListener {
    private Board board;
    private int cellSize;
    boolean click;

    public Controler(Board board, int cellSize) {
        this.board = board;
        this.cellSize = cellSize;
        this.click = false;
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

    public boolean isPressed(){
        return this.click;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        addSand(e.getX(), e.getY());
        this.click = true;
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
        this.click = false;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        addSand(e.getX(), e.getY());
        this.click = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.click = false;
    }
}
