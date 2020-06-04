package de.hfu;

import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor(){
        Queue q = new Queue(0);
    }

    //Test Queue
    Queue queue = new Queue(3);

    @Test
    public void testInputOverride(){
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        assertEquals(4,queue.queue[2]);
    }

    @Test
    public void testOutput(){
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(1,queue.dequeue());
        assertEquals(2,queue.dequeue());
        assertEquals(3,queue.dequeue());
    }

    @Test(expected = IllegalStateException.class)
    public void testEmptyQueueException(){
        queue.dequeue();
    }
}
