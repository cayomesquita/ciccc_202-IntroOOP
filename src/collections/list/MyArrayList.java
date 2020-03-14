package collections.list;

import java.util.*;

// "generic" type <E> : Element
public class MyArrayList<E> implements List<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elementData;
    private int size;

    public MyArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity >= 0) {
            elementData = new Object[initialCapacity];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    // <? extends E> -> any type that extends E
    public MyArrayList(Collection<? extends E> c) {
        elementData = c.toArray();
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
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            return (T[]) Arrays.copyOf(elementData, size, a.getClass());
        }
        System.arraycopy(elementData, 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    @Override
    public boolean add(E e) {
        if (size == elementData.length) {
            // grow (increases by 50%)
            elementData = grow(size + 1);
        }
        elementData[size] = e;
        size++;
        return true;
    }

    private Object[] grow(int minCapacity) {
        return elementData = Arrays.copyOf(elementData, newCapacity(minCapacity));
    }

    /*
    The maximum size of array to allocate.
    Attempts to allocate larger arrays "may" result in OutOfMemoryOrder
     */
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    /**
     * @param minCapacity the desired minimum capacity
     * @return
     */
    private int newCapacity(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity <= minCapacity) {
            if (minCapacity < 0 || minCapacity > MAX_ARRAY_SIZE) {
                throw new OutOfMemoryError("integer overflow");
            }
            return minCapacity;
        }
        return (newCapacity <= MAX_ARRAY_SIZE) ? newCapacity : Integer.MAX_VALUE;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(o)) {
                for (; i < size - 1; i++) {
                    elementData[i] = elementData[i + 1];
                }
                elementData[--size] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (indexOf(o) < 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E e : c) {
            add(e);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        // FIXME
        if (c == null || c.isEmpty()) {
            return false;
        }
        int oldSize = size;
        Object[] arrayAux = c.toArray();
        int iAux = 0;
        int limitAux = c.size();
        Object aux = null;
        for (int i = index; i < size; i++) {
            aux = elementData[i];
            elementData[i] = arrayAux[iAux];
            arrayAux[iAux++] = aux;
            if (iAux == limitAux) {
                iAux = 0;
            }
        }
        int i = iAux;
        do {
            add((E) arrayAux[i++]);
            if (i == limitAux) {
                i = 0;
            }
        }while (i != iAux);
        return oldSize != size;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        int oldSize = size;
        for (int i = size - 1; i >= 0; i--) {
            if (c.contains(elementData[i])) {
                remove(i);
            }
        }
        return oldSize != size;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        int oldSize = size;
        for (int i = size - 1; i >= 0; i--) {
            if (!c.contains(elementData[i])) {
                remove(i);
            }
        }
        return oldSize != size;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    @Override
    public E get(int index) {
        checkBounds(index);
        return (E) elementData[index];
    }

    private void checkBounds(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + ", size: " + size);
        }
    }

    @Override
    public E set(int index, E element) {
        checkBounds(index);
        E oldValue = (E) elementData[index];
        elementData[index] = element;
        return oldValue;
    }

    @Override
    public void add(int index, E element) {
        checkBounds(index);
        E aux = null;
        for (int i = index; i < size; i++) {
            aux = (E) elementData[i];
            elementData[i] = element;
            element = aux;
        }
        add(element);
    }

    @Override
    public E remove(int index) {
        checkBounds(index);
        E obj = (E) elementData[index];
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        elementData[size--] = null;
        return obj;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (o == null ? get(i) == null : o.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int lastIndex = -1;
        for (int i = 0; i < size; i++) {
            if (o == null ? get(i) == null : o.equals(get(i))) {
                lastIndex = i;
            }
        }
        return lastIndex;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        checkBounds(fromIndex);
        checkBounds(toIndex);
        if (fromIndex > toIndex) {
            throw new IllegalArgumentException("fromIndex > toIndex");
        }
        int length = toIndex - fromIndex;
        List<E> list = new ArrayList<>(length);
        for (int i = fromIndex; i < toIndex; i++) {
            list.add((E) elementData[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        MyArrayList<Integer> a = new MyArrayList<>(10);
        for (int i = 0; i < 15; i++) {
            a.add(i + 1);
        }
        printList(a);

        // test    public int indexOf(Object o) {
        System.out.printf("a.indexOf(4) = %d\n", a.indexOf(4));

        // test    public int lastIndexOf(Object o) {
        System.out.printf("a.contains(6) = %b\n", a.contains(6));
        System.out.printf("a.contains(16) = %b\n", a.contains(16));
        // test         public boolean containsAll(Collection<?> c) {
        Collection<Integer> c = Arrays.asList(2, 4, 6, 8);
        Collection<Integer> d = Arrays.asList(2, 4, 16, 8);
        System.out.printf("a.containsAll(2,4,6,8) = %b\n", a.containsAll(c));
        System.out.printf("a.containsAll(2,4,16,8) = %b\n", a.containsAll(d));
        // test    public List<E> subList(int fromIndex, int toIndex) {
        System.out.printf("a.subList(4,8) = ");
        printList(a.subList(4, 8));
        // test toArray(t[] a)
        Integer[] arr = a.toArray(new Integer[5]);
        System.out.printf("a.toArray(new Integer[5]) = ");
        printArray(arr);
        arr = a.toArray(new Integer[25]);
        System.out.printf("a.toArray(new Integer[25]) = ");
        printArray(arr);
        // test    public boolean addAll(Collection<? extends E> c) {
        a.addAll(Arrays.asList(20, 30, 40));
        System.out.printf("a.addAll(Arrays.asList(20,30,40)) = ");
        printList(a);
        // test    public void add(int index, E element) {
        a.add(7, 100);
        System.out.printf("a.add(7,100) = ");
        printList(a);
        // test    public boolean addAll(int index, Collection<? extends E> c) {
        a.addAll(2, Arrays.asList(10, 20, 30));
        System.out.printf("a.addAll(2,(10,20,30)) = ");
        printList(a);
        a.addAll(11, Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 1, 0));
        System.out.printf("a.addAll(11,(9,8,7,6,5,4,3,2,1,0)) = ");
        printList(a);

        // test     public boolean remove(Object o) {
        System.out.printf("a.remove(100) = %b | ",a.remove(Integer.valueOf(100)));
        printList(a);
        System.out.printf("a.remove(100) = %b | ",a.remove(Integer.valueOf(100)));
        printList(a);
        // test    public E remove(int index) {
        System.out.printf("a.remove(15) = %s | ",a.remove(15));
        printList(a);
        // test    public boolean removeAll(Collection<?> c) {
        System.out.printf("a.removeAll((20,30,40)) = %b | ",a.removeAll(Arrays.asList(20,30,40)));
        printList(a);
        System.out.printf("a.removeAll((20,30,40)) = %b | ",a.removeAll(Arrays.asList(20,30,40)));
        printList(a);
        // test    public boolean retainAll(Collection<?> c) {
        System.out.printf("a.retainAll((10,11,12,13,15,16,17,18,19)) = %b | ",a.retainAll(Arrays.asList(10,11,12,13,15,16,17,18,19)));
        printList(a);
        System.out.printf("a.retainAll((10,11,12,13,15,16,17,18,19)) = %b | ",a.retainAll(Arrays.asList(10,11,12,13,15,16,17,18,19)));
        printList(a);
        // test    public void clear() {
        a.clear();
        System.out.printf("a.clear() = ");
        printList(a);
    }

    private static void printArray(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void printList(List<Integer> a) {
        System.out.print("[ ");
        for (int i = 0; i < a.size(); i++) {
            System.out.print(a.get(i) + " ");
        }
        System.out.println("]");
    }
}
