package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        SandSimulator simulator = new SandSimulator();
        simulator.start();

        while (true) {
            Thread.getAllStackTraces().keySet().forEach((t)
                    -> System.out.println(t.getName()));
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("---------------");
        }
    }
}