package at.htlle.pos4.prio_messagequeue;

import java.util.Random;

public class Producer extends Thread {
    private final String name;
    private final PriorityMessageQueue queue;
    private final Random random = new Random();

    public Producer(String name, PriorityMessageQueue queue) {
        this.name = name;
        this.queue = queue;
    }

    @Override
    public void run() {
        int count = 1;
        try {
            while (true) {
                boolean isPriority = random.nextBoolean();
                String content = name + "_Message" + count++;
                Message msg = new Message(isPriority, content);
                queue.sendMessage(msg);

                Thread.sleep(500 + random.nextInt(1000)); // random sleep 0.5–1.5s
            }
        } catch (InterruptedException e) {
            System.out.println(name + " interrupted.");
        }
    }
}

