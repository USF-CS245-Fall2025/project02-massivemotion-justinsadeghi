public interface List<T> {

    /**
     * Insert element at given index within the list
     * @param index position that element will be inserted at
     * @param element to insert
     * @throws IndexOutOfBoundsException if index is out of bounds
     */
    void add (int index, T element) throws IndexOutOfBoundsException;

    /**
     * Insert element to the end of the list
     * @param element to insert
     * @return
     */
    boolean add (T element);

    /**
     * Get element at a given index
     * @param index position of the element
     * @return element at given index
     * @throws IndexOutOfBoundsException if index is out of bounds
     */
    T get (int index) throws IndexOutOfBoundsException;

    /**
     * Remove element at given index
     * @param index where element will be removed
     * @return removed element
     * @throws IndexOutOfBoundsException if index is out of bounds
     */
    T remove (int index) throws IndexOutOfBoundsException;

    /**
     * Number of elements in a list
     * @return size of list
     */
    int size();
}
