package testes.thread;

import java.util.Vector;

public class VectorThreadExample {
    public static void main(String[] args) throws InterruptedException {
        // Shared thread-safe Vector
        Vector<Integer> sharedVector = new Vector<>();

        // Thread 1 adds 1000 items
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                sharedVector.add(i);
            }
        });

        // Thread 2 adds 1000 items
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                sharedVector.add(i);
            }
        });

        t1.start();
        t2.start();

        // Wait for both threads to finish
        t1.join();
        t2.join();

        // Output will always be 2000
        System.out.println("Final Vector Size: " + sharedVector.size());
    }
}