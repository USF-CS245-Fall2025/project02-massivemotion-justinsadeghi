public class DummyHeadLL<T> implements List<T> {
    private Node head; // dummy head
    private int size;

    public DummyHeadLL() {
        head = new Node(null); // dummy node
        size = 0;
    }

    @Override
    public boolean add(T item) {
        Node prev = head;
        while (prev.next != null) {
            prev = prev.next;
        }
        prev.next = new Node(item);
        size++;
        return true;
    }

    @Override
    public void add(int pos, T item) {
        if (pos < 0 || pos > size) {
            throw new IndexOutOfBoundsException("Invalid position: " + pos);
        }

        Node prev = head;
        for (int i = 0; i < pos; i++) {
            prev = prev.next;
        }

        Node node = new Node(item);
        node.next = prev.next;
        prev.next = node;
        size++;
    }

    @Override
    public T remove(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Invalid position: " + pos);
        }

        Node prev = head;
        for (int i = 0; i < pos; i++) {
            prev = prev.next;
        }

        Node node = prev.next;
        prev.next = node.next;
        size--;
        return node.data;
    }

    @Override
    public T get(int pos)  {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Invalid position: " + pos);
        }

        Node curr = head.next; // skip dummy node
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
        Node next;

        public Node(T data) {
            this.data = data;
            next = null;
        }
    }
}
