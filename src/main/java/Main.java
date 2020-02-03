package main.java;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int shipCountCargo = 11;
        List<Ship> shipList = new ArrayList<>();
        Port port = new Port();
        port.readConsole();
        CommandPost cp = new CommandPost(port);
        Dock dock = new Dock(89);
        for (int i = 0; i < port.getCountShip(); i++){
            shipList.add(new Ship(cp,"Ship_" + i,shipCountCargo,dock));
        }
        for (int i = 0; i<shipList.size(); i++){
            while (shipList.get(i).shipThread.isAlive()){}
        }
            port.finalOutput(dock.getDockCargo());
    }

}
