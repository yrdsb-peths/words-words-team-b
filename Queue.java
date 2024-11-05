public class Queue<Item> {
    private Node first, last;

    // Inner node class 
    private class Node {
        Item item;
        Node next;
    }

    /*
     * Checks if queue is empty
     */
    public boolean isEmpty() {
        return first == null;
    }

    /*
     * Enqueue an item
     */
    public void enqueue(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;

        if (isEmpty()) {
            first = last;
        } else {
            oldlast.next = last;
        }
    }

    /*
     * Dequeue an item
     */
    public Item dequeue() {
        Item item = first.item;
        first = first.next;

        if (isEmpty()) {
            last = null;
        }

        return item;
    }
}
