package testes.thread;

import java.util.ArrayList;
import java.util.List;

public class ListThreadExample {
    public static void main(String[] args) throws InterruptedException {
        // Shared non thread-safe List
        List<Integer> sharedList = new ArrayList<>();

        // Thread 1 adds 1000 items
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                sharedList.add(i);
            }
        });

        // Thread 2 adds 1000 items
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                sharedList.add(i);
            }
        });

        t1.start();
        t2.start();

        // Wait for both threads to finish
        t1.join();
        t2.join();

        // Output will NOT always be 2000
        System.out.println("Final List Size: " + sharedList.size());
    }
}