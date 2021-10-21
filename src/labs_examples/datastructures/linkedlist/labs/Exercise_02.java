package labs_examples.datastructures.linkedlist.labs;

/**
 * LinkedLists - Exercise_02
 * <p>
 * Write your own custom LinkedList class. Although it can mimic the CustomLinkedList
 * class we used here, it must be entirely unique. Please also add at least two
 * additional helper methods that you think could be useful. Refer to Java's built-in
 * LinkedList class for inspiration. Your new LinkedList class should ONLY allow users
 * to add and remove elements from the front of the list AND the end of the list.
 * Also, instead of using the index in the get() and remove() methods, these methods should
 * get() and remove() based by the Node's value, not it's index.
 */

class Exercise_02 {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>("Talon", "Rider");

        list.addLast("Jared");
        list.addFirst("Rowan");
        list.addLast("Jen");
        list.addFirst("Miley");

        System.out.println(list.contains("Jared"));
        System.out.println(list.contains("Sally"));
        System.out.println("- - - - -");

        list.print();

        list.removeFirst();
        list.print();

        list.removeLast();
        list.print();

        list.remove("Talon");
        list.print();
    }
}

class MyLinkedList<T> {

    Node<T> head;

    public MyLinkedList(T... data) {
        if (data.length < 1) {
            head = null;
        } else {
            for (int i = 0; i < data.length; i++) {
                addLast(data[i]);
            }
        }
    }

    public void print() {
        System.out.println(size());
        for (int i = 0; i < size(); i++) {
            System.out.println(get(i));
        }
        System.out.println("- - - - -");
    }

    /**
     * This methods checks to see if the linkedlist contains a given element
     *
     * @param data - and element to search
     * @return true or false - true if the linkedlist contains the element
     */
    public boolean contains(T data) {
        if (head != null) {
            Node iterator = head;
            for (int i = 0; i < size(); i++) {
                if (iterator.data != data) {
                    iterator = iterator.next;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public void addLast(T data) {
        if (head != null) {
            Node iterator = head;
            Node next = null;
            for (int i = 0; i < size(); i++) {
                if (iterator.next != null) {
                    iterator = iterator.next;
                } else {
                    iterator.next = new Node(data, iterator);
                }
            }
        } else {
            head = new Node(data);
        }
    }

    public void addFirst(T data) {
        Node<T> first = new Node<>(data);
        first.next = head;
        head.prev = first;
        head = first;
    }

    public void remove(T data) {
        if (head != null) {
            Node iterator = head;
            for (int i = 0; i < size(); i++) {
                if (iterator.data != data) {
                    iterator = iterator.next;
                } else {
                    iterator.prev.next = iterator.next;
                }
            }
        }
    }

    public void removeFirst() {
        if (head != null) {
            head = head.next;
        }
    }

    public void removeLast() {
        if (head != null) {
            Node iterator = head;
            for (int i = 0; i < size(); i++) {
                if (iterator.next != null) {
                    iterator = iterator.next;
                } else {
                    iterator = iterator.prev;
                    iterator.next = null;
                }
            }
        }
    }

    public int size() {
        if (head == null) {
            return 0;
        }
        int count = 1;
        Node iterator = head;
        while (iterator.next != null) {
            count++;
            iterator = iterator.next;
        }
        return count;
    }

    public T get(int index) {
        Node iterator = head;
        for (int i = 0; i < index; i++) {
            iterator = iterator.next;
        }
        return (T) iterator.data;
    }

}

class Node<T> {
    T data;
    Node next;
    Node prev;

    public Node(T data, Node prev) {
        this.data = data;
        this.next = null;
        this.prev = prev;
    }

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}