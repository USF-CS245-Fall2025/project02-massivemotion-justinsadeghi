/**
 * Doubly Linked List
 * Each node has prev and next pointers, allowing for traversal in both directions
 * Checking bounds of an index and keeping track of the size for a list is accounted for by CheckBounds
 * @param <T> type of element stored in the list
 */
public class DoublyLL<T> extends CheckBounds<T> {

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

    private Node head;

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
    public void add(int pos, T item) throws IndexOutOfBoundsException {
        checkBounds(pos, true); //insert at size allowed

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
    public T remove(int pos) throws IndexOutOfBoundsException {
        checkBounds(pos, false);

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
    public T get(int pos) throws IndexOutOfBoundsException {
        checkBounds(pos, false);

        Node curr = head;
        for (int i = 0; i < pos; i++) {
            curr = curr.next;
        }
        return curr.data;
    }
}
