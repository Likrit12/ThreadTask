package main.java;

public class Ship extends Thread {
    int countCargo;
    int loadCountCargo = 5;
    String name;
    Thread shipThread;
    CommandPost commandPost;
    Dock dock;
    Ship(CommandPost commandPost, String name, int countCargo, Dock dock){
        this.commandPost = commandPost;
        this.name = name;
        this.countCargo = countCargo;
        this.dock = dock;
        shipThread = new Thread(this,name);
        shipThread.start();
    }
    public  synchronized  void load(int n){

        countCargo += n;
    }
    public  synchronized  void unload(int n){
        countCargo -= n;

    }

    @Override
    public void run() {
        try {
            while (commandPost.goInDock(this)){
                Thread.sleep(3000); //Попробовать переделать на нормальное ожидание
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
