public class DoublyLL<T> implements List<T> {
    private Node head;
    private int size;

    public DoublyLL() {
        head = null;
        size = 0;
    }

    @Override
    public boolean add(T item) {
        Node node = new Node(item);

        if (head == null) {
            head = node;
            size++;
            return true;
        }

        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = node;
        node.prev = curr;
        size++;
        return true;
    }

    @Override
    public void add(int pos, T item) {
        if (pos < 0 || pos > size) { // insert at size allowed
            throw new IndexOutOfBoundsException("Invalid position: " + pos);
        }

        Node node = new Node(item);

        if (pos == 0) {
            node.next = head;
            if (head != null) {
                head.prev = node;
            }
            head = node;
        } else {
            Node prev = head;
            for (int i = 0; i < pos - 1; i++) {
                prev = prev.next;
            }
            node.next = prev.next;
            node.prev = prev;
            if (prev.next != null) {
                prev.next.prev = node;
            }
            prev.next = node;
        }

        size++;
    }

    @Override
    public T remove(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Invalid position: " + pos);
        }

        Node curr = head;

        if (pos == 0) {
            T data = head.data;
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            size--;
            return data;
        }

        for (int i = 0; i < pos; i++) {
            curr = curr.next;
        }

        T data = curr.data;

        if (curr.prev != null) {
            curr.prev.next = curr.next;
        }
        if (curr.next != null) {
            curr.next.prev = curr.prev;
        }

        size--;
        return data;
    }

    @Override
    public T get(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Invalid position: " + pos);
        }

        Node curr = head;
        for (int i = 0; i < pos; i++) {
            curr = curr.next;
        }
        return curr.data;
    }

    @Override
    public int size() {
        return size;
    }

    private class Node {
        T data;
        Node prev;
        Node next;

        Node(T data) {
            this.data = data;
            prev = null;
            next = null;
        }
    }
}
