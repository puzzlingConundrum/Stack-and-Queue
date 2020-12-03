import Exceptions.EmptyQueueException;
import Exceptions.EmptyStackException;

public class NodeQueue<E> implements Queue<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;

    public NodeQueue() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public void enqueue(E e) {
        Node<E> newNode = new Node<>(e);
        newNode.setNext(first);
        if (size > 0)
            first.setPrev(newNode);
        first = newNode;
        if (size == 0)
            last = first;
        size++;
    }

    @Override
    public E dequeue() {
        if (size == 0) {
            throw new EmptyQueueException("Queue is empty.");
        }
        E returnElem = last.getElement();
        if (size == 1) {
            last = null;
            first = null;
        } else {
            last.getPrev().setNext(null);
            last = last.getPrev();
        }
        size--;
        return returnElem;
    }

    @Override
    public E first() {
        return first.getElement();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        String queueString = "";
        Node f = first;
        if (size == 0) {
            return "Queue is Empty.";
        }
        while (f.getNext() != null) {
            queueString += f.getElement() + " ";
            f = f.getNext();
        }
        queueString += f.getElement();
        return queueString;
    }
}
