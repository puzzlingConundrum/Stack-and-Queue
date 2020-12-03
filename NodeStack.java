import Exceptions.EmptyStackException;

public class NodeStack<E> implements Stack<E> {
    private Node<E> top;
    private int size;

    public NodeStack() {
        top = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void push(E e) {
        Node<E> newNode = new Node<>(e);
        newNode.setNext(top);
        top = newNode;
        size++;
    }

    @Override
    public E pop() {
        if (size == 0) {
            throw new EmptyStackException("Stack is Empty.");
        }
        E returnElem = top.getElement();
        top = top.getNext();
        size--;
        return returnElem;
    }

    @Override
    public E top() {
        return top.getElement();
    }

    @Override
    public String toString() {
        String stackString = "";
        Node last = top;
        if (size == 0) {
            return "Stack is Empty.";
        }
        while (last.getNext() != null) {
            stackString = last.getElement() + " " + stackString;
            last = last.getNext();
        }
        stackString = last.getElement() + " " + stackString;
        return stackString;
    }
}
