/*
 *  DeveloperName: Suraj Gautam
 *  College Name: ShankerDev Campus
 *  Semester: 4th
 *  Company: XYZ IT Solution
 */
package com.week3day2.threading;

import java.io.FileOutputStream;

/**
 *
 * @author SurajGautam
 */
public class DaemonThreadDemo {

    public static void main(String[] args) {
        Thread thread = new Thread(new FileWriterDemo());
        thread.setDaemon(false);
        thread.start();
    }
}

class FileWriterDemo implements Runnable {

    @Override
    public void run() {

        try (FileOutputStream f = new FileOutputStream("E:\\thread.txt", true)) {
            String s = "This is the old data.";
            int i = 0;
            while (i < 10000) {
                String data = "This is the new data" + s;
                byte b[] = data.getBytes();
                Thread.sleep(2000);
                System.out.println(data);
                f.write(b);
                f.write("\n".getBytes());
                i++;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

}
