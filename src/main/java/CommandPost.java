package main.java;

import java.util.ArrayList;
import java.util.List;

public class CommandPost {


    private Port port;
    private List<Ship> shipInDock = new ArrayList<>();
    public CommandPost(Port port){
        this.port = port;
    }
    public Port getPort() {
        return port;
    }
    public synchronized boolean goInDock(Ship ship) throws InterruptedException {
        if (shipInDock.size() < port.getCountDocks()){
            shipInDock.add(ship);
            System.out.println("Корабль заплыл в док: " + ship.name );
            new Deamon(this,ship,port.getCountLoader());
            wait();
            return false;
        }
        else {
            System.out.println("Корабль не заплыл в док: " + ship.name );
        return true;
    }
    }
    public synchronized void goOutDock(String name){
        shipInDock.removeIf(nextShip -> nextShip.name.equals(name));
        System.out.println("Корабль отплыл из дока: " + name);
        notify();
    }

}
