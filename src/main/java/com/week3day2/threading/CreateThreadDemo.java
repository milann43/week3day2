/*
 *  DeveloperName: Suraj Gautam
 *  College Name: ShankerDev Campus
 *  Semester: 4th
 *  Company: XYZ IT Solution
 */
package com.week3day2.threading;

import static java.lang.Thread.currentThread;

/**
 *
 * @author SurajGautam
 */
public class CreateThreadDemo {
    public static void main(String[] args) {
        runApp();
        String name = currentThread().getName();
        System.out.println(name);
    }

    public static void runApp() {
        //If Thread Class subclass
        FileStore f = new FileStore();
        
        //If implemented class of Runnable Interface
        Thread t2 = new Thread(new FileDownloader());
        
        f.start();
        t2.start();
   }

}


//Runnable Interface
class FileDownloader implements Runnable {

    @Override
    public void run() {
        System.out.println("FileDownloader#");
    }

}

//Thread Class
class FileStore extends Thread {

    @Override
    public void run() {
        System.out.println("FileStore#");
    }

}
