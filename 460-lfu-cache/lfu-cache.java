
import java.util.HashMap;
import java.util.Map;

class LFUCache {

    class Node {
        int key, value, freq;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DoublyLinkedList {
        Node head, tail;
        int size;

        DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeLast() {
            if (size == 0) return null;

            Node node = tail.prev;
            remove(node);
            return node;
        }
    }

    private int capacity;
    private int minFreq;

    private Map<Integer, Node> keyMap;
    private Map<Integer, DoublyLinkedList> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        keyMap = new HashMap<>();
        freqMap = new HashMap<>();
    }

    private void updateFreq(Node node) {
        int oldFreq = node.freq;

        DoublyLinkedList oldList = freqMap.get(oldFreq);
        oldList.remove(node);

        if (oldFreq == minFreq && oldList.size == 0) {
            minFreq++;
        }

        node.freq++;

        DoublyLinkedList newList =
            freqMap.computeIfAbsent(node.freq,
                k -> new DoublyLinkedList());

        newList.addFirst(node);
    }

    public int get(int key) {
        if (!keyMap.containsKey(key)) {
            return -1;
        }

        Node node = keyMap.get(key);
        updateFreq(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (keyMap.containsKey(key)) {
            Node node = keyMap.get(key);
            node.value = value;
            updateFreq(node);
            return;
        }

        if (keyMap.size() == capacity) {
            DoublyLinkedList list = freqMap.get(minFreq);
            Node lfu = list.removeLast();
            keyMap.remove(lfu.key);
        }

        Node node = new Node(key, value);
        minFreq = 1;

        DoublyLinkedList list =
            freqMap.computeIfAbsent(1,
                k -> new DoublyLinkedList());

        list.addFirst(node);
        keyMap.put(key, node);
    }
}
