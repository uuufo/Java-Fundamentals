package labs_examples.datastructures.stack.labs;

import java.util.Arrays;

/**
 *      Stacks - Exercise_02
 *
 *      Write a new custom (Generic) Stack class that uses a traditional Array as the underlying data structure
 *      rather than the LinkedList as in the example we have already seen.
 *
 *      Your custom Stack class must also do the following:
 *
 *      1) throw a custom exception when trying to pop an element from an empty Stack
 *      2) resize the Stack (the underlying array) to be twice the size when the Stack is more than 3/4 full
 *      3) resize the Stack (the underlying array) to be half the size when the Stack is more than 1/4 empty
 *      4) contain the methods peekFirst() and peekLast()
 *      5) contain a size() method
 *      6) contain a method to print out the data of all elements in the Stack
 *
 */

class Exercise_02 {
    public static void main(String[] args) throws EmptyStackException {
        MyStack<String> stack = new MyStack<>("1", "2", "3", "4");
        stack.print();
        stack.push("5");
        stack.print();
        stack.push("6");
        stack.print();
        stack.push("7");
        stack.print();
        stack.push("8");
        stack.print();

        System.out.println("First item in stack: " + stack.peakFirst());
        System.out.println("Last item in stack: " + stack.peakLast());

        stack.pop();
        stack.print();
        stack.pop();
        stack.print();
        stack.pop();
        stack.print();
        stack.pop();
        stack.print();
        stack.pop();
        stack.print();
        stack.pop();
        stack.print();
        stack.pop();
        stack.print();
        stack.pop();
        stack.print();
        System.out.println(stack.size());

        System.out.println("First item in stack: " + stack.peakFirst());
        System.out.println("Last item in stack: " + stack.peakLast());

        for (int i = 1; i < 101; i++) {
            stack.push(Integer.toString(i + 100));
        }
        stack.print();
        String s = stack.pop();
        System.out.println(s);

    }
}

class MyStack<T> {

    private T[] stack;
    private T[] tempStack;

    @SuppressWarnings("unchecked")
    public MyStack(T... data) {
        if (data.length < 1) {
            stack = null;
        } else {
            if (data.length < 4) {
                stack = (T[]) new Object[4];
            } else {
                stack = (T[]) new Object[data.length + (data.length / 4)];
            }
            for (T item : data) {
                push(item);
            }
        }
    }

    public void push(T data) {
        int count = 0;
        while (stack[count] != null) {
            count++;
            if (count + 1 >= stack.length - (stack.length / 4)) {
                tempStack = Arrays.copyOf(stack, stack.length * 2);
                stack = Arrays.copyOf(tempStack, tempStack.length);
            }
        }
        for (int i = count; i > -1; i--) {
            if (i > 0) {
                stack[i] = stack[i - 1];
            }
        }
        stack[0] = data;
    }

    public T pop() throws EmptyStackException {
        if (stack[0] == null) {
            throw new EmptyStackException();
        }
        T data = stack[0];
        System.arraycopy(stack, 1, stack, 0, stack.length - 1);

        int count = 0;
        while (stack[count] != null) {
            count++;
        }
        if (count <= stack.length / 4 && count > 1) {
            tempStack = Arrays.copyOf(stack, stack.length / 2);
            stack = Arrays.copyOf(tempStack, tempStack.length);
        }
        return data;
    }

    public int size() {
        int count = 0;
        for (T s : stack) {
            if (s != null) {
                count++;
            }
        }
        return count;
    }

    public void print() {
        for (T s : stack) {
            if (s != null) {
                System.out.println(s.toString());
            }
        }
        System.out.println("Current items in array: " + size());
        System.out.println("Current stack length: " + stack.length);
    }

    public T peakFirst() {
        if (stack[0] == null) {
            return null;
        }
        int count = 0;
        while (stack[count] != null) {
            count++;
        }
        return stack[count - 1];
    }

    public T peakLast() {
        return stack[0];
    }
}

class EmptyStackException extends Exception {
    @Override
    public String toString() {
        return "EmptyStackException - There is nothing to pop();";
    }
}

