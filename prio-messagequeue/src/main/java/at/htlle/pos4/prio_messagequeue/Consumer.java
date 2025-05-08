package at.htlle.pos4.prio_messagequeue;

import java.util.Random;

public class Consumer extends Thread {
    private final String name;
    private final PriorityMessageQueue queue;
    private final Random random = new Random();

    public Consumer(String name, PriorityMessageQueue queue) {
        this.name = name;
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Message msg = queue.receiveMessage();
                System.out.println(name + " processed: " + msg);

                Thread.sleep(500 + random.nextInt(1000)); // random sleep 0.5–1.5s
            }
        } catch (InterruptedException e) {
            System.out.println(name + " interrupted.");
        }
    }
}

