/*
 *  DeveloperName: Suraj Gautam
 *  College Name: ShankerDev Campus
 *  Semester: 4th
 *  Company: XYZ IT Solution
 */
package com.week3day2.threading;

/**
 *
 * @author SurajGautam
 */
public class ThreadsMethodDemo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(runnable);
            thread.setName("mythread : " + i);
            thread.setDaemon(true);
            threads[i] = thread;
        }
        for (Thread t : threads) {
            t.start();
            t.join();
        }
        
        final Operand operand = new Operand();
        // if using any value inside run then we have to make that final
        
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(0);
                    operand.setA(10);
                } catch (InterruptedException ex) {

                }
            }
        });
        
        
        
        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(0);
                    operand.setB(20);
                } catch (InterruptedException ex) {

                }
            }
        });
        
        System.out.printf("Name = %s, Status = %s\n",t1.getName(), t1.getState().name() );
        t1.start();
        t2.start();
        System.out.printf("Name = %s, Status = %s\n",t1.getName(), t1.getState().name() );
        
        System.out.println("T2 is Alive?" + t2.isAlive());
        
        /*Static Methods*/
        System.out.println(Thread.currentThread().getName());
        Thread.dumpStack();
        System.out.println(Thread.holdsLock(t2));
        
        Thread.yield();
      
        
        t1.join();
        
        System.out.printf("Name = %s, Status = %s\n",t1.getName(), t1.getState().name() );
        System.out.println("Sum"+ (operand.getA()+ operand.getB()));
    }
}

class Operand{
    
    int a, b;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
    
    
}