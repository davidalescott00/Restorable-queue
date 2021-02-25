/* * 
 * Implementation of a Queue with restorable properties.
 * 
 * @author David Scott & Jackson St. Louis
 * @date   <2/24/21> 
 * */

import java.util.Stack;

public class RestorableQueue<T> implements Restorable{
    DoublyLinkedList<T> _queue;
    Stack<Memento> _reversions;

    /**
     * Creates a new restorable queue and stack of mementos.
     */
    public RestorableQueue(){
        _queue = new DoublyLinkedList<>();
        _reversions = new Stack<Memento>();
    }

	/**
	 * Returns int - the number of elements in the collection
	 * 
	 * @param: none
	 * @size - will return the number of elements in the collection
	 */
    public int size(){
        return _queue.size();
    }
    
    /**
    * Returns boolean 
    * @param: none
    * @isEmpty will return true if the collection contains no elements,    otherwise will return false. 
    */
    public boolean isEmpty(){
        return _queue.isEmpty();
    }

    /**
    * Returns boolean
    * @param: Object o - the object you will be looking for
    * @contains - wll take in an object o and search the collection. if found will return true, otherwise will return false 
    */
    public boolean contains(Object o){
    	
        for (T item : _queue){
            if(item.equals(o)){
                return true;
            }
        }
        return false;
    }

    /**
    * Returns object[]
    * @param: none
    * @toArray will return an array containing all the elemetns in this collection 
    */
    public Object[] toArray(){
        Object[] arr = new Object[_queue.size()];
        
        int i = 0;
        for (T item : _queue){ //For item in queue, add to created array and move pointer forward
            arr[i] = item;
            i++;
        }
        return arr;
    }

    /**
    * Returns void
    * @param: none
    * @clear - will empty the queue resulting in queue size of 0
    */
    public void clear(){
        _queue.clear();
    }

    /**
    * Returns void
    * @param: T item - a specific element
    * @enqueue- will insert the specific element into the queue at the tail end 
    */
    public void enqueue(T item){
        _queue.push_back(item);
    }

    /**
    * Returns T
    * @param: none
    * @dequeue- will insert the specific element into the queue at the tail end 
    */
    public T dequeue(){
        return _queue.pop_front();
    }

    /**
    * Returns T
    * @param: none
    * @peek retrieves but does not remove the head of the queue
    */
    
    public T peek(){
    	if (_queue.isEmpty()){
    		return null;
    	}
        return _queue.peek_front();
    }

    /**
    * Returns void
    * @param: none
    * @saveState saves current state of queue as a Memento object,
    * Adds to the top of save state stack.
    */
    public void saveState(){
        Memento m = new Memento(this.toArray());
        _reversions.add(m);
    }
    
    /**
     * Returns boolean
     * @param: none
     * revertState clears current queue and restores with memento at the top of reversions stack and returns true.
     * Returns false if no states have been saved.
     */
    @SuppressWarnings("unchecked")
	public boolean revertState(){
        if (_reversions.isEmpty()){
            return false;
        }
        
        this.clear(); //If state exists, clear current queue and fill with memento contents from top of stack.

        Memento m = _reversions.pop();
        for (Object o : m._data){
            _queue.push_back((T) o); //Objects need to be casted
        }
        return true;
    }

    /**
     * Memento object acts as a save state for restorable queues.
     * _data object array holds the contents of a state.
     */
    private class Memento{
        Object[] _data;

        /**
         * Private empty constructor prevents user from creating memento with no contents.
         */
        @SuppressWarnings("unused")
		private Memento(){
            //Blocks empty creation of Memento
        }

        /**
         * Fills _data array with items array given by _items which contains save state data.
         */
        public Memento(Object[] items){
        	_data = new Object[items.length];
     
        	
        	for (int i = 0; i < _data.length; i++) { 
                _data[i] = items[i];
             }

        }

    }

}

