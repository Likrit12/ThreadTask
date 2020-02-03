package main.java;

public class Dock {
    private int dockCargo;

    public int getDockCargo() {
        return dockCargo;
    }
    public Dock(int dockCargo){
        this.dockCargo = dockCargo;
    }
    public  synchronized  void load(int n){
        dockCargo += n;
    }
    public  synchronized  void unload(int n){
        if (n > dockCargo)
        dockCargo -= dockCargo;
        else dockCargo -= n;

    }
}
