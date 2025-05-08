package at.htlle.pos4.prio_messagequeue;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) {
        PriorityMessageQueue queue = new PriorityMessageQueue(5); // max 5 messages

        Producer p1 = new Producer("Producer1", queue);
        Producer p2 = new Producer("Producer2", queue);

        Consumer c1 = new Consumer("Consumer1", queue);
        Consumer c2 = new Consumer("Consumer2", queue);

        p1.start();
        p2.start();
        c1.start();
        c2.start();
    }
}
