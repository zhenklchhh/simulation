package program;

import java.util.Scanner;

public class Main{
    private final static Scanner scanner = new Scanner(System.in);
    private static Simulation simulation;
    public static void main(String[] args){
        System.out.println("Для старта симуляции введите (s), для остановки - (p).");
        System.out.println("Размеры карты: 20х20 ");
        simulation = new Simulation();
        simulation.initSimulation();
        Thread inputThread = new Thread(Main::handleInput);
        inputThread.start();
    }
    public static void handleInput(){
        while(true){
            String input = scanner.next();
            if(input.equals("s")){
                simulation.startSimulation();
            }else if(input.equals("p")){
                simulation.pauseSimulation();
            }else{
                System.out.println("Ошибка");
            }
        }
    }
}