package ThreadMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProducerConsumerProblem {
    static List<Integer> list = new ArrayList<Integer>();

    static class Producer implements Runnable {
        List<Integer> list;
        public Producer(List<Integer> list) {
            this.list = list;
        }

        @Override
        public void run() {
            synchronized (list) {
                for (int i = 0; i < 10; i++) {
                    if (list.size() >= 1) {
                        try {
                            System.out.println("producer is waiting ");
                            list.wait();
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }

                    System.out.println("produce=" + i);
                    list.add(i);
                    list.notifyAll();
                }
            }
        }
    }

    static class Consumer implements Runnable {
        List<Integer> list;
        public Consumer(List<Integer> list) {
            this.list = list;
        }

        @Override
        public void run() {

            synchronized (list) {
                for (int i = 0; i < 10; i++) {
                    while (list.isEmpty()) {
                        System.out.println("Consumer is waiting");
                        try {
                            list.wait();
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();;
                        }
                    }
                    int k = list.remove(0);
                    System.out.println("consume=" + k);
                    list.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread producer = new Thread(new Producer(list));
        Thread consumer = new Thread(new Consumer(list));
        producer.start();
        consumer.start();

    }
}



/*

Output:
produce=0
producer is waiting
consume=0
Consumer is waiting
produce=1
producer is waiting
consume=1
Consumer is waiting
produce=2
producer is waiting
consume=2
Consumer is waiting
produce=3
producer is waiting
consume=3
Consumer is waiting
produce=4
producer is waiting
consume=4
Consumer is waiting
produce=5
producer is waiting
consume=5
Consumer is waiting
produce=6
producer is waiting
consume=6
Consumer is waiting
produce=7
producer is waiting
consume=7
Consumer is waiting
produce=8
producer is waiting
consume=8
Consumer is waiting
produce=9
consume=9

 */