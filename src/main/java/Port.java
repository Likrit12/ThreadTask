package main.java;

import java.util.Scanner;

public class Port {
    private int totalCargo;
    private int countShip;
    private int countDocks;
    private int countLoader;
    public int getTotalCargo() {
        return totalCargo;
    }

    public int getCountShip() {
        return countShip;
    }

    public int getCountDocks() {
        return countDocks;
    }

    public int getCountLoader() {
        return countLoader;
    }
    public void readConsole(){
        Scanner in = new Scanner(System.in);
        System.out.print("Количество кораблей: ");
        countShip = Integer.parseInt(in.nextLine());
        System.out.print("Количество доков: ");
        countDocks = Integer.parseInt(in.nextLine());
        System.out.print("Общее количество грузов: ");
        totalCargo = Integer.parseInt(in.nextLine());
        System.out.print("Количество грузчиков обслуживающих 1 корабль: ");
        countLoader = Integer.parseInt(in.nextLine());
    }
    public void finalOutput(int totalCargo){
        System.out.println("Total cargo at the system is " + totalCargo);
        if (this.totalCargo == totalCargo){
            System.out.println("Congratulations!");
        } else System.out.println("Attantion");
        System.out.println(totalCargo + " out of " + this.totalCargo + " units of cargo delivered to the destination.");
    }
}



