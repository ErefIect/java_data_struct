package HashTable;

/*
 * @Author: Ereflect
 * @Date: 2023-02-07 12:33:32
 * @LastEditors: Please set LastEditors
 * @LastEditTime: 2023-02-07 12:34:41
 * @Description: 请填写简介
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashTable {
    private int size;
    private List<LinkedList<Integer>> table;

    public HashTable(int size) {
        this.size = size;
        this.table = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            table.add(new LinkedList<>());
        }
    }

    private int hash(int key) {
        return key % size;
    }

    public void put(int key) {
        int index = hash(key);
        table.get(index).add(key);
    }

    public boolean contains(int key) {
        int index = hash(key);
        return table.get(index).contains(key);
    }

    public void remove(int key) {
        int index = hash(key);
        table.get(index).remove((Integer) key);
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);
        hashTable.put(10);
        hashTable.put(20);
        hashTable.put(30);
        System.out.println("Contains 10: " + hashTable.contains(10));
        System.out.println("Contains 20: " + hashTable.contains(20));
        System.out.println("Contains 30: " + hashTable.contains(30));
        hashTable.remove(20);
        System.out.println("Contains 20: " + hashTable.contains(20));
    }
}

