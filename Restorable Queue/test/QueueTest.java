import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

//Tests Queue methods
class QueueTest {
	
	/**
	 * Tests size() method of restorable queue.
	 * Tests populated queue and empty queue.
	 */
	@Test
	void test_queue_size() {
		RestorableQueue<Integer> testQ = new RestorableQueue<>();

		testQ.enqueue(1);
		testQ.enqueue(2);
		testQ.enqueue(3);

		assertEquals(3, testQ.size());

		testQ.clear();
		assertEquals(0, testQ.size());
	}

	/**
	 * Tests isEmpty() method of restorable queue.
	 * Tests populated queue and empty queue.
	 */
	@Test
	void test_queue_isEmpty() {
		RestorableQueue<Integer> testQ = new RestorableQueue<>();

		assertTrue(testQ.isEmpty());

		testQ.enqueue(1);
		assertFalse(testQ.isEmpty());
	}

	/**
	 * Tests contains() method of restorable queue.
	 * Tests hit and miss.
	 */
	@Test
	void test_queue_contains() {
		RestorableQueue<Integer> testQ = new RestorableQueue<>();

		assertFalse(testQ.contains(1));

		testQ.enqueue(1);
		testQ.enqueue(2);
		testQ.enqueue(3);

		assertTrue(testQ.contains(2));

	}

	/**
	 * Tests toArray() method of restorable queue.
	 * Compares toArray results with created integer array.
	 */
	@Test
	void test_queue_toArray() {
		Integer[] test = new Integer[3];
		test[0] = 1;
		test[1] = 2;
		test[2] = 3;

		RestorableQueue<Integer> testQ = new RestorableQueue<>();

		testQ.enqueue(1);
		testQ.enqueue(2);
		testQ.enqueue(3);

		assertArrayEquals(test, testQ.toArray());

	}

	/**
	 * Tests clear() method of restorable queue.
	 * Clears populated queue and checks if it is empty.
	 */
	@Test
	void test_queue_clear() {
		RestorableQueue<Integer> testQ = new RestorableQueue<>();

		testQ.enqueue(1);
		testQ.enqueue(2);
		testQ.enqueue(3);

		testQ.clear();

		assertTrue(testQ.isEmpty());
	}

	/**
	 * Tests enqueue() method of restorable queue.
	 * Tests if integer is added and if it is in the correct position.
	 */
	@Test
	void test_queue_enqueue() {
		RestorableQueue<Integer> testQ = new RestorableQueue<>();

		testQ.enqueue(1);
		testQ.enqueue(2);
		testQ.enqueue(3);

		assertEquals(1, testQ.peek());
	}

	/**
	 * Tests dequeue() method of restorable queue.
	 * Tests if correct integer is removed from queue.
	 */
	@Test
	void test_queue_dequeue() {
		RestorableQueue<Integer> testQ = new RestorableQueue<>();

		testQ.enqueue(1);
		testQ.enqueue(2);
		testQ.enqueue(3);

		testQ.dequeue();

		assertEquals(2, testQ.peek());
		assertFalse(testQ.peek() == 3);

	}

	/**
	 * Tests peek() method of restorable queue.
	 * Tests if integer at front of queue is returned.
	 */
	@Test
	void test_queue_peek() {
		RestorableQueue<Character> testQ = new RestorableQueue<>();
		assertNull(testQ.peek());

		testQ.enqueue('a');
		testQ.enqueue('b');
		testQ.enqueue('c');

		testQ.dequeue();
		assertEquals('b', testQ.peek());
	}

}
