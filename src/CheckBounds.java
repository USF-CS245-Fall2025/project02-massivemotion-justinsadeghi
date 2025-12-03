public abstract class CheckBounds<T> implements List<T> {
    protected int size;

    /**
     * Checks if a given index is within bounds for a list
     * @param pos the index to check
     * @param sizeInclusive true if upper bound is inclusive (in the case of add()), false for other operations
     * @throws IndexOutOfBoundsException if index is out of bounds
     */
    protected void checkBounds (int pos, boolean sizeInclusive) throws IndexOutOfBoundsException {
        int upperBounds = sizeInclusive ? size : size - 1; // for add() we can add at size (end of list), size - 1 for remove() and get()
        if(pos < 0 || pos > upperBounds) {
            throw new IndexOutOfBoundsException("Invalid Position: " + pos);
        }
    }

    /**
     * This method is needed in this class as checkBounds() needs to know current size of a list
     * @return number of elements in a list
     */
    public int size() {return size;}
}