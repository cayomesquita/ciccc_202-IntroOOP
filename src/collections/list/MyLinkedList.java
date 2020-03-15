package collections.list;

import java.util.Objects;

// Doubly-Linked list
public class MyLinkedList<E> {
    private int size;
    private Node head, tail;

    private static class Node<E> {
        E data;
        Node next;
        Node prev;

        Node(E data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public boolean contains(E data) {
        Node<E> currentNode = head;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(currentNode.data, data)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public void add(E data) {
        if (size == 0) {
            head = new Node<E>(data, null, null);
            tail = head;
        } else {
            Node newNode = new Node<E>(data, null, tail);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void add(int index, E data) {
        if (index == size) {
            add(data);
        } else {
            checkBounds(index);
            Node currentNode = getNode(index);
            Node newNode = new Node<E>(data, currentNode, currentNode.prev);
            if (currentNode.prev != null) {
                currentNode.prev.next = newNode;
            }
            currentNode.prev = newNode;
            if (index == 0) {
                head = newNode;
            }
            size++;
        }

    }

    public E remove(int index) {
        Node currentNode = getNode(index);
        if (currentNode.prev == null) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        } else {
            currentNode.prev.next = currentNode.next;
        }
        if (currentNode.next == null) {
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            }
        } else {
            currentNode.next.prev = currentNode.prev;
        }
        size--;
        return (E) currentNode.data;
    }

    public E get(int index) {
        checkBounds(index);
        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return getNode(index).data;
    }

    private Node<E> getNode(int index) {
        checkBounds(index);
        Node<E> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    public E set(int index, E newData) {
        // should return the previous data
        Node<E> node = getNode(index);
        E oldData = node.data;
        node.data = newData;
        return oldData;
    }

    @Override
    public String toString() {
        // ex) "Obj0"=="Obj1"==null
        StringBuilder sb = new StringBuilder();
        Node<E> currentNode = head;
        for (int i = 0; i < size; i++) {
//            sb.append(String.format("\"Obj%d\"==", i));
            sb.append(String.format("{%s}==", currentNode.data.toString()));
            currentNode = currentNode.next;
        }
        sb.append("null");
        return sb.toString();
    }

    private void checkBounds(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + ", size: " + size);
        }
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> myList = new MyLinkedList<>();
//        public String toString() {
        System.out.printf("myList.toString() = %s\n", myList.toString());
//        public void add(E data) {
        myList.add(2);
        System.out.println("myList.add(2) = void");
        System.out.printf("myList.toString() = %s\n", myList.toString());
        myList.add(4);
        System.out.println("myList.add(4) = void");
        System.out.printf("myList.toString() = %s\n", myList.toString());
//        public void add(int i, E data) {
        myList.add(0, 1);
        System.out.println("myList.add(0, 1) = void");
        System.out.printf("myList.toString() = %s\n", myList.toString());
        myList.add(2, 3);
        System.out.println("myList.add(2, 3) = void");
        System.out.printf("myList.toString() = %s\n", myList.toString());
        myList.add(4, 5);
        System.out.println("myList.add(5, 5) = void");
        System.out.printf("myList.toString() = %s\n", myList.toString());
//        public E get(int i) {
        System.out.printf("myList.get(0) = %s\n", myList.get(0).toString());
        System.out.printf("myList.get(2) = %s\n", myList.get(2).toString());
        System.out.printf("myList.get(4) = %s\n", myList.get(4).toString());
//        public boolean contains(E data) {
        System.out.printf("myList.contains(3) = %b\n", myList.contains(3));
        System.out.printf("myList.contains(6) = %b\n", myList.contains(6));
//        public E remove(int i) {
        System.out.printf("myList.toString() = %s\n", myList.toString());
        System.out.printf("myList.remove(0) = %s\n", myList.remove(0).toString());
        System.out.printf("myList.toString() = %s\n", myList.toString());
        System.out.printf("myList.remove(3) = %s\n", myList.remove(3).toString());
        System.out.printf("myList.toString() = %s\n", myList.toString());
        System.out.printf("myList.remove(1) = %s\n", myList.remove(1).toString());
        System.out.printf("myList.toString() = %s\n", myList.toString());
//        public E set(int i, E newData) {
        System.out.printf("myList.set(0, 1) = %s\n", myList.set(0, 1).toString());
        System.out.printf("myList.toString() = %s\n", myList.toString());
        System.out.printf("myList.set(1, 2) = %s\n", myList.set(1, 2).toString());
        System.out.printf("myList.toString() = %s\n", myList.toString());
//

    }

}