import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RestorableTest {
	
	/**
	 * Tests reversal properties of restorable queue.
	 * First creates a restorable queue one with contents <1,2,3> and saves state.
	 * Queue one is cleared. A second queue is created with contents <1,2,3>.
	 * 
	 * True is expected when reverseState is called on the first queue, since it has saved a state.
	 * False is expected when reverseState is called on the second queue, since it never saved a state.
	 * 
	 * Queue one and two are compared for equality after queue ones state is reverted.
	 */
	@Test
	void test_queue_reversalProperties() {
		RestorableQueue<Integer> test = new RestorableQueue<>();
		
		test.enqueue(1);
		test.enqueue(2);
		test.enqueue(3); 
		test.saveState();
		
		test.clear();
		
		RestorableQueue<Integer> testTwo = new RestorableQueue<>();
		
		testTwo.enqueue(1);
		testTwo.enqueue(2);
		testTwo.enqueue(3); 
		
		boolean condition = test.revertState();
		
		assertArrayEquals(test.toArray(), testTwo.toArray());
		assertTrue(condition);
		
		boolean conditionTwo = testTwo.revertState();
		
		assertFalse(conditionTwo);
	}

}
