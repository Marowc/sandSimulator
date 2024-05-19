package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        SandSimulator simulator = new SandSimulator();
        simulator.start();

        String choice = null;
        Scanner scan = new Scanner(System.in);
        do {
            choice = scan.nextLine();
            switch (choice) {
                case "a": simulator.start(); System.out.println("started"); break;
                case "b": simulator.stop(); System.out.println("stopped"); break;
            }
        } while (!choice.equals("q"));
    }
}