public class LinkedList<T> extends CheckBounds<T> {

    private class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public LinkedList() {
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
        size++;
        return true;
    }

    @Override
    public void add(int pos, T item) throws IndexOutOfBoundsException {
        checkBounds(pos, true);

        Node node = new Node(item);

        if (pos == 0) {
            node.next = head;
            head = node;
        } else {
            Node prev = head;
            for (int i = 0; i < pos - 1; i++) {
                prev = prev.next;
            }
            node.next = prev.next;
            prev.next = node;
        }
        size++;
    }

    @Override
    public T remove(int pos) throws IndexOutOfBoundsException {
        checkBounds(pos, false);

        Node removed;
        if (pos == 0) {
            removed = head;
            head = head.next;
        } else {
            Node prev = head;
            for (int i = 0; i < pos - 1; i++) {
                prev = prev.next;
            }
            removed = prev.next;
            prev.next = removed.next;
        }
        size--;
        return removed.data;
    }

    @Override
    public T get(int pos) throws IndexOutOfBoundsException {
        checkBounds(pos, false);

        Node curr = head;
        for (int i = 0; i < pos; i++) {
            curr = curr.next;
        }
        return curr.data;
    }
}
