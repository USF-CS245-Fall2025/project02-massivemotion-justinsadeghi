public class ArrayList<T> implements List<T> {
    private T[] arr;
    private int size;

    public ArrayList() {
        arr = (T[]) new Object[10];
        size = 0;
    }

    @Override
    public boolean add(T item) {
        if (size == arr.length) {
            growArray();
        }
        arr[size++] = item;
        return true;
    }

    @Override
    public void add(int pos, T item) {
        if (pos < 0 || pos > size) {
            throw new IndexOutOfBoundsException("Invalid position: " + pos);
        }
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
    public T remove(int pos)  {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Invalid position: " + pos);
        }
        T removedItem = arr[pos];
        // Shift elements to the left
        for (int i = pos; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        return removedItem;
    }

    @Override
    public T get(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Invalid position: " + pos);
        }
        return arr[pos];
    }

    @Override
    public int size() {
        return size;
    }

    private void growArray() {
        T[] newArr = (T[]) new Object[arr.length * 3 / 2 + 1];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }
}
