package dsa.hashes;

import java.util.LinkedList;

public class MyHashTable {
    int SIZE = 10;

    public static class KeyValue {
        String key;
        int value;

        KeyValue(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<KeyValue>[] table; // Array de listas encadeadas

    /*
     * [[]][[]][[]] <- LinkedList[]
     * .[]  []  []
     * .[]  []  []
     * .    []
     *      []
     */

    @SuppressWarnings("unchecked")
    public MyHashTable() {
        table = (LinkedList<KeyValue>[]) new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public void put(String key, int value){
        if(key.isBlank()){
            System.out.println("A chave e/ou valor não devem ser nulas");
            return;
        }

        int index = hash2(key);
        LinkedList<KeyValue> bucket = table[index];

        for(KeyValue keyValue : bucket){
            if(keyValue.key.equals(key)){
                keyValue.value = value;
                return;
            }
        }

        bucket.add(new KeyValue(key, value));
    }

    public int hash2(String key){
//        String salt = "salt";
        String temp = key;
        int hash = 0;
        for(int i = 0; i < temp.length(); i++){
            hash += Math.pow(((i+1)*temp.charAt(i)), 2);
        }

        return hash % SIZE;
    }

    public int contains(String key){
        int index = hash2(key);
        LinkedList<KeyValue> bucket = table[index];

        for(KeyValue keyValue : bucket){
            if(keyValue.key.equals(key)){
                return keyValue.value;
            }
        }

        return -1;
    }

    public int delete(String key){
        int index = hash2(key);
        int value = -1;
        int indexRemove = -1;
        LinkedList<KeyValue> bucket = table[index];
        for(int i = 0; i < bucket.size(); i++){
            KeyValue keyValue = bucket.get(i);
            if(keyValue.key.equals(key)){
                indexRemove = i;
                value = keyValue.value;
                break;
            }
        }

        if(indexRemove == -1){
            return -1;
        }

        bucket.remove(indexRemove);
        return value;
    }

    public void print(){
        for(LinkedList<KeyValue> list : table){
            System.out.print("[");
            for(KeyValue keyValue : list){
                System.out.print("{\""+keyValue.key+"\"" + ":" + " \""+keyValue.value+"\"}");
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) {
        MyHashTable myHashTable = new MyHashTable();
        myHashTable.put("banana", 7);
        myHashTable.put("laranja", 8);
        myHashTable.put("uva", 9);
        myHashTable.put("abacaxi", 10);
        myHashTable.put("manga", 11);
        myHashTable.put("melancia", 12);
        myHashTable.put("pera", 13);
        myHashTable.put("morango", 14);
//        myHashTable.put("kiwi", 15);
//        myHashTable.put("cereja", 16);
//        myHashTable.put("ameixa", 17);
//        myHashTable.put("limão", 18);
//        myHashTable.put("caqui", 19);
//        myHashTable.put("goiaba", 20);
//        myHashTable.put("figo", 21);
//        myHashTable.put("jabuticaba", 22);
//        myHashTable.put("pêssego", 23);
//        myHashTable.put("tangerina", 24);
//        myHashTable.put("pitanga", 25);
//        myHashTable.put("maracujá", 26);
//
//        myHashTable.put("cadeira", 27);
//        myHashTable.put("mesa", 28);
//        myHashTable.put("computador", 29);
//        myHashTable.put("teclado", 30);
//        myHashTable.put("monitor", 31);
//        myHashTable.put("fone", 32);
//        myHashTable.put("caneta", 33);
//        myHashTable.put("lápis", 34);
//        myHashTable.put("borracha", 35);
//        myHashTable.put("livro", 36);
//        myHashTable.put("caderno", 37);
//        myHashTable.put("janela", 38);
//        myHashTable.put("porta", 39);
//        myHashTable.put("mouse", 40);
//        myHashTable.put("gaveta", 41);
//        myHashTable.put("quadro", 42);
//        myHashTable.put("papel", 43);
//        myHashTable.put("carro", 44);
//        myHashTable.put("bicicleta", 45);
//        myHashTable.put("avião", 46);
//        myHashTable.put("barco", 47);
//        myHashTable.put("ônibus", 48);
//        myHashTable.put("moto", 49);
//        myHashTable.put("caminhão", 50);
//        myHashTable.put("relógio", 51);
//        myHashTable.put("óculos", 52);
//        myHashTable.put("celular", 53);
//        myHashTable.put("tablet", 54);
//        myHashTable.put("notebook", 55);
//        myHashTable.put("televisão", 56);
//        myHashTable.put("controle", 57);
//        myHashTable.put("ventilador", 58);
//        myHashTable.put("arcondicionado", 59);
//        myHashTable.put("geladeira", 60);
//        myHashTable.put("fogão", 61);
//        myHashTable.put("microondas", 62);
//        myHashTable.put("liquidificador", 63);
//        myHashTable.put("aspirador", 64);
//        myHashTable.put("batedeira", 65);
//        myHashTable.put("panela", 66);
//        myHashTable.put("colher", 67);
//        myHashTable.put("garfo", 68);
//        myHashTable.put("faca", 69);
//        myHashTable.put("prato", 70);
//        myHashTable.put("copo", 71);
//        myHashTable.put("toalha", 72);
//        myHashTable.put("sabonete", 73);
//        myHashTable.put("shampoo", 74);
//        myHashTable.put("escova", 75);
//        myHashTable.put("pente", 76);

        myHashTable.print();

        System.out.println(myHashTable.delete("6546456"));
        myHashTable.print();

    }

}
