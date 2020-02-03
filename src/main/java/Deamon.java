package main.java;

public class Deamon implements Runnable {
    private CommandPost commandPost;
    private Ship ship;
    private int countLoader;

    Deamon(CommandPost commandPost, Ship ship, int countLoader) {
        this.commandPost = commandPost;
        this.ship = ship;
        this.countLoader = countLoader;
        Thread t = new Thread(this, "CommandPost");
        t.setDaemon(true);
        t.start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            while (ship.countCargo != 0) {
                ship.unload(Math.min(ship.countCargo, countLoader));
                ship.dock.load(Math.min(ship.countCargo, countLoader));
                Thread.sleep(1000);
                System.out.println("Осталось " + ship.countCargo + " груза на корабле " + ship.name);
            }
     while ((ship.dock.getDockCargo()!= 0) && ship.countCargo != ship.loadCountCargo){
                int min = Math.min(ship.loadCountCargo - ship.countCargo, countLoader);
                ship.load(Math.min(min,ship.dock.getDockCargo()));
                ship.dock.unload(Math.min(min,ship.dock.getDockCargo()));
                Thread.sleep(1000);
                System.out.println("Загруженно " + ship.countCargo + " груза на корабль " + ship.name);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        commandPost.goOutDock(ship.name);
    }
}
