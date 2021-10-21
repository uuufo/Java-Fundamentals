package labs_examples.datastructures.hashmap.labs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * HashMaps Exercise_02
 * <p>
 * Rewrite the CustomHashMap class to meet the following requirements:
 * 1) no method has the same name as any in CustomHashMap
 * (do not use refactor - do it manually)
 * 2) no variable has the same name as any in CustomHashMap
 * (do not use refactor - do it manually)
 * 3) resize the HashMap when the underlying array is more than half full
 * 4) triple the size of the underlying array on resize()
 * 5) instead of checking the number of keys to resize, check the number of values
 * 6) on collisions, add new elements to the front of the LinkedList, not the end
 * 7) anytime someone tries to get/update/remove an element that does not exist, print
 * out a message indicating that the element does not exist
 * 8) add at least one more method that you think could be useful to the HashMap
 * review Java's built-in HashMap for inspiration
 */

class Exercise_02 {
    public static void main(String[] args) {
        MyHashMap<Integer, String> m = new MyHashMap<>();
        MyHashMap<String, Integer> m2 = new MyHashMap<>();


        System.out.println(m.isEmpty());
        System.out.println(m2.isEmpty());

        for (int i = 5000; i < 5100; i++) {
            m.put(i, "Test");
        }
        for (int i = 300; i < 400; i++) {
            m2.put("Test" + i, i);
        }

        Set<Integer> keys = m.keySet();
        Set<String> keys2 = m2.keySet();
        System.out.println(m.size());
        System.out.println(m2.size());

        System.out.println(m.get(100));
        System.out.println(m.get(5050));
        System.out.println(m2.get("Test500"));
        System.out.println(m2.get("Test361"));

        System.out.println(m.remove(100));
        System.out.println(m.remove(5050));
        System.out.println(m2.remove("Test500"));
        System.out.println(m2.remove("Test361"));

        keys = m.keySet();
        keys2 = m2.keySet();
        System.out.println(m.size());
        System.out.println(m2.size());

        System.out.println(m.get(5050));
        System.out.println(m2.get("Test361"));

        for (int i = 5000; i < 5050; i++) {
            m.remove(i);
        }

        keys = m.keySet();
        keys2 = m2.keySet();

        System.out.println(m.size());
        System.out.println(m2.size());

        System.out.println(m.isEmpty());
        System.out.println(m2.isEmpty());
    }
}

class MyHashMap<K, V> {
    private Entry<K, V>[] table = new Entry[16];
    private int size = 0;
    boolean growing = false;
    boolean shrinking = false;

    /**
     * Adds a new key-value pair or updates the value of an existing key
     *
     * @param key   to be added/updated
     * @param value value to be stored
     * @return previous value if existing key is being updated, or null if new pair is added
     */
    public V put(K key, V value) {

        Entry<K, V> entry = new Entry<>(key, value);
        int index = getIndex(key);
        V result;

        if (table[index] != null) {
            Entry<K, V> iterator = table[index];

            while (iterator.next != null && !iterator.getKey().equals(key)) {
                iterator = iterator.next;
            }
            if (iterator.getKey().equals(key)) {
                V previous = iterator.getValue();
                iterator.setValue(value);
                result = previous;
            } else {
                iterator.next = entry;
                if (!growing && !shrinking) {
                    size++;
                }
                result = null;
            }
        } else {
            table[index] = entry;
            if (!growing && !shrinking) {
                size++;
            }
            result = null;
        }
        if (size > table.length - (table.length / 4) && !shrinking) {
            grow();
        }
        return result;
    }

    /**
     * Returns the value mapped with the specified key
     *
     * @param key to be located
     * @return value, or null if key does not exist
     */
    public V get(K key) {
        int index = getIndex(key);
        V result;

        if (table[index] != null) {
            Entry<K, V> iterator = table[index];

            while (iterator.next != null && !iterator.getKey().equals(key)) {
                iterator = iterator.next;
            }
            if (iterator.getKey().equals(key)) {
                result = iterator.getValue();
            } else {
                result = null;
            }
        } else {
            result = null;
        }
        return result;
    }

    /**
     * Removes key-value pair specified by key.
     *
     * @param key of pair to be removed
     * @return value of removed pair, or null if key does not exist
     */
    public V remove(K key) {
        int index = getIndex(key);
        V result;

        if (table[index] != null) {
            Entry<K, V> iterator = table[index];
            Entry<K, V> previous = iterator;

            while (iterator.next != null && !iterator.getKey().equals(key)) {
                previous = iterator;
                iterator = iterator.next;
            }
            if (iterator.getKey().equals(key)) {
                result = iterator.getValue();
                if (!growing && !shrinking) {
                    size--;
                }
                if (previous.getKey().equals(iterator.getKey())) {
                    table[index] = null;
                } else {
                    previous.next = iterator.next;
                }
            } else {
                result = null;
            }
        } else {
            result = null;
        }
        if (size < table.length / 4 && table.length > 16 && !growing) {
            shrink();
        }
        return result;
    }

    /**
     * Increases size of underlying array when required (.75 load factor)
     */
    private void grow() {
        growing = true;
        Entry<K, V>[] tempTable = Arrays.copyOf(table, table.length * 2);
        table = new Entry[tempTable.length];
        for (Entry<K, V> entry : tempTable) {
            Entry<K, V> iterator = entry;
            if (entry != null) {
                put(entry.getKey(), entry.getValue());
                while (iterator.next != null) {
                    put(iterator.next.getKey(), iterator.next.getValue());
                    iterator = iterator.next;
                }
            }
        }
        growing = false;
    }

    /**
     * Reduces size of underlying array when able to.
     */
    private void shrink() {
        shrinking = true;
        Entry<K, V>[] tempTable = Arrays.copyOf(table, table.length);
        table = new Entry[tempTable.length / 2];
        for (Entry<K, V> entry : tempTable) {
            Entry<K, V> iterator = entry;
            if (entry != null) {
                put(entry.getKey(), entry.getValue());
                while (iterator.next != null) {
                    put(iterator.next.getKey(), iterator.next.getValue());
                    iterator = iterator.next;
                }
            }
        }
        shrinking = false;
    }

    /**
     * Returns the count of key-value pairs in the HashMap
     *
     * @return count
     */
    public int size() {
        return size;
    }

    /**
     * Returns all keys in the HashMap
     *
     * @return Set of keys
     */
    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();

        for (Entry<K, V> entry : table) {
            Entry<K, V> iterator = entry;
            if (entry != null) {
                keys.add(entry.getKey());
                while (iterator.next != null) {
                    keys.add(iterator.next.getKey());
                    iterator = iterator.next;
                }
            }
        }
        return keys;
    }

    /**
     * Returns location of key in array based on hashcode
     *
     * @param key to be located
     * @return index in table
     */
    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    /**
     * Removes all data from the HashMap
     */
    public void clear() {
        table = new Entry[16];
    }

    /**
     * Checks if HashMap is empty.
     *
     * @return true if HashMap contains no key-value pairs
     */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }
}

class Entry<K, V> {
    /**
     * Simple key-value pair.
     */
    private final K key;
    private V value;
    Entry<K, V> next = null;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Gets key of Entry.
     *
     * @return key
     */
    public K getKey() {
        return key;
    }

    /**
     * Gets current value of Entry.
     *
     * @return current value
     */
    public V getValue() {
        return value;
    }

    /**
     * Replaces value of Entry.
     *
     * @param value new value to be stored
     * @return previous value of this entry
     */
    public V setValue(V value) {
        V previous = this.value;
        this.value = value;
        return previous;
    }
}