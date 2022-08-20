package ThreadMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Print1And2FromTwoThreads {
    static Print1And2FromTwoThreads obj = new Print1And2FromTwoThreads();
    static int count = 0;

    static class Producer implements Runnable {
        Print1And2FromTwoThreads obj;
        public Producer(Print1And2FromTwoThreads obj) {
            this.obj = obj;
        }

        @Override
        public void run() {
            System.out.println("The Producer thread started");
            synchronized (obj) {
                if(count < 10) {
                    try {
                        obj.wait();
                        System.out.println("producer = " + count);
                        count++;
                        obj.notify();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }


    static class Consumer implements Runnable {
        Print1And2FromTwoThreads obj;

        public Consumer(Print1And2FromTwoThreads obj) {
            this.obj = obj;
        }
        @Override
        public void run() {
            System.out.println("The Consumer thread started");
            synchronized (obj) {
                while(count < 10) {
                    try {
                        //if(count != 0){
                            obj.wait();
                        //}
                        System.out.println("consume=" + count);
                        count++;
                        obj.notify();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Thread producer = new Thread(new Producer(obj));
        Thread consumer = new Thread(new Consumer(obj));
        producer.start();
        Thread.sleep(1);
        consumer.start();

    }
}
