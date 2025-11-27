public class DummyHeadLL<T> extends CheckBounds<T> {

    private class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            next = null;
        }
    }

    private Node head; // dummy head

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
    public void add(int pos, T item) throws IndexOutOfBoundsException {
        checkBounds(pos, true);

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
    public T remove(int pos) throws IndexOutOfBoundsException {
        checkBounds(pos, false);

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
    public T get(int pos) throws IndexOutOfBoundsException {
        checkBounds(pos, false);

        Node curr = head.next; // skip dummy node
        for (int i = 0; i < pos; i++) {
            curr = curr.next;
        }
        return curr.data;
    }
}
