package com.lysenko.callbackImplement;

import java.util.ArrayList;
import java.util.Random;

interface MyInterface {
    void callMeBack(int status);
}


public class CallBackDemo {
    public static void main(String[] args) {
        Caller caller = new Caller();
        for (int i = 0; i < 5; i++) {
            new Worker(caller).run();
        }
//        итого у нас 9 воркеров отработали и вернули ответ по калбеку в коллекцию
        System.out.println(caller.getList());
    }
}


class Caller implements MyInterface {
    private ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<Integer> getList() {
        return list;
    }
    @Override
    public void callMeBack(int status) {
//            тут может быть логика куда вернутся данные, может быть коллекция, я выбрал попроще
        synchronized (list) {
            System.out.println("Caller Status = " + status);
            list.add(status);
            System.out.println("Caller list = " + list +"\n");
        }
    }
}


class Worker extends Thread {
    private MyInterface myInterface;
    Worker(MyInterface myInterface) {
        System.out.println(" Worker Constructor myInterface = " + myInterface);
        this.myInterface = myInterface;
    }
    private int randonInt() {
        return new Random().nextInt();
    }
    @Override
    public void run() {
//            выполним работу
        int randonInt = randonInt();
        System.out.println(" Worker randomInt = " + randonInt);
//            и вернём данные вызывающему по калбеку интерфейсу
        myInterface.callMeBack(randonInt);
    }
}