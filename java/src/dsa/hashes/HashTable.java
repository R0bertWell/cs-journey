package dsa.hashes;

import java.util.LinkedList;

class HashTable {
    private static class Entry {
        String key;
        int value;

        Entry(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int SIZE = 1; // Tamanho fixo da tabela hash
    private LinkedList<Entry>[] table; // Array de listas encadeadas

    @SuppressWarnings("unchecked")
    public HashTable() {
        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Método de hash baseado no algoritmo djb2
    private int hash(String key) {
        long hash = 5381; // Valor inicial
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            // hash * 33 + c usando shift para multiplicação
            hash = ((hash << 5) + hash) + c;
        }
        return (int) (hash % SIZE); // Mantém o índice dentro dos limites da tabela
    }

    public void put(String key, int value) {
        int index = hash(key);
        LinkedList<Entry> bucket = table[index];

        // Se a chave já existir, atualiza o valor
        for (Entry entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        // Se a chave não existir, adiciona um novo par
        bucket.add(new Entry(key, value));
    }

    public Integer get(String key) {
        int index = hash(key);
        LinkedList<Entry> bucket = table[index];

        for (Entry entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null; // Retorna null se a chave não existir
    }

    public void remove(String key) {
        int index = hash(key);
        LinkedList<Entry> bucket = table[index];

        bucket.removeIf(entry -> entry.key.equals(key));
    }

    public void printTable() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print("Index " + i + ": ");
            for (Entry entry : table[i]) {
                System.out.print("[" + entry.key + " -> " + entry.value + "] ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();

        // Inserindo elementos
        hashTable.put("joao", 10);
        hashTable.put("jooa", 20);
        hashTable.put("jaoo", 30);
        hashTable.put("ojao", 40);
        hashTable.put("ooja", 50);
        hashTable.put("ooaj", 60);
        hashTable.put("oajo", 70);
        hashTable.put("oaoj", 80);
        hashTable.put("aojo", 90);
        hashTable.put("aooj", 100);
        hashTable.put("ajoo", 110);

        // Imprimir tabela hash
        hashTable.printTable();

        // Buscar valores
        System.out.println("\nValor associado à chave 'joao': " + hashTable.get("joao"));

        // Remover um elemento
        hashTable.remove("joao");
        System.out.println("Após remover 'joao': ");
        hashTable.printTable();
    }
}