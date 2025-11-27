public abstract class CheckBounds<T> implements List<T> {
    protected int size;

    protected void checkBounds (int pos, boolean sizeInclusive) throws IndexOutOfBoundsException {
        int upperBounds = sizeInclusive ? size : size - 1; // for add() we can add at size (end of list), size - 1 for remove() and get()
        if(pos < 0 || pos > upperBounds) {
            throw new IndexOutOfBoundsException("Invalid Position: " + pos);
        }
    }

    public int size() {return size;}
}