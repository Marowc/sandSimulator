package org.example;

public class SandSimulator {
    private Board board;
    private Renderer renderer;
    private boolean isRunning;

    public SandSimulator() {
        board = new Board(100, 100);
        renderer = new Renderer(board);
        isRunning = true;
    }

    public void start(){
        /*while(true){
            board.update();
            renderer.repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
        new Thread(() -> {
            while(isRunning){
                board.update();
                renderer.repaint(); // Wywołanie repaint() dla odświeżenia panelu
                try {
                    Thread.sleep(100); // Opóźnienie dla lepszego efektu wizualnego
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void stop(){
        isRunning = false;
    }

    public void addSand(int x, int y){
        boolean sand = true;
        board.setCell(x, y, sand);
        renderer.repaint();
    }

}
