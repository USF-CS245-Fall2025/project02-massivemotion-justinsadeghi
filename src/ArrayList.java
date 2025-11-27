public class ArrayList<T> extends CheckBounds<T> {
    private T[] arr;

    public ArrayList() {
        arr = (T[]) new Object[10];
        size = 0;
    }

    @Override
    public boolean add(T item)  {
        if (size == arr.length) {
            growArray();
        }
        arr[size++] = item;
        return true;
    }

    @Override
    public void add(int pos, T item) throws IndexOutOfBoundsException {
        checkBounds(pos, true);

        if (size == arr.length) {
            growArray();
        }
        // Shift elements to the right
        for (int i = size; i > pos; i--) {
            arr[i] = arr[i - 1];
        }
        arr[pos] = item;
        size++;
    }

    @Override
    public T remove(int pos) throws IndexOutOfBoundsException {
        checkBounds(pos, false);

        T removedItem = arr[pos];
        // Shift elements to the left
        for (int i = pos; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        return removedItem;
    }

    @Override
    public T get(int pos) throws IndexOutOfBoundsException {
        checkBounds(pos, false);
        return arr[pos];
    }


    private void growArray() {
        T[] newArr = (T[]) new Object[arr.length * 3 / 2 + 1];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }
}
