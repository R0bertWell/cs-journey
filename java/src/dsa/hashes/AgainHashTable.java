package dsa.hashes;

import java.util.ArrayList;
import java.util.LinkedList;

public class AgainHashTable<V> {

    public int length = 0;
    public int SIZE = 10;
    private LinkedList<KeyValue<V>>[] table;


    static class KeyValue<T> {
        String key;
        T value;

        public KeyValue(String key, T value){
            this.key = key;
            this.value = value;
        }
    }

    @SuppressWarnings("unchecked")
    public AgainHashTable() {
        // Inicializa o array com LinkedLists
        this.table = (LinkedList<KeyValue<V>>[]) new LinkedList[this.SIZE];
        for (int i = 0; i < this.SIZE; i++) {
            this.table[i] = new LinkedList<>();
        }
    }


    public AgainHashTable<V> put(String key, V value) {
        int index = _hash(key);

        LinkedList<KeyValue<V>> row = table[index];

        for (KeyValue<V> keyvalue : row) {
            if (keyvalue.key.equals(key)) {
                keyvalue.value = value;
                return this;
            }
        }

        row.push(new KeyValue<>(key, value));
        this.length++;
        return this;
    }

    public V get(String key){
        int index = _hash(key);

        LinkedList<KeyValue<V>>   row = this.table[index];

        for(KeyValue<V> kv : row){
            if(kv.key.equals(key)){
                return kv.value;
            }
        }

        return null;
    }

    public V delete(String key){
        int index = _hash(key);

        LinkedList<KeyValue<V>> row = this.table[index];

//        row.removeIf(line -> line.key.equals(key)); easy

        int ind = -1;
        for(int i = 0; i < row.size(); i++){
            KeyValue<V> keyValue = row.get(i);
            if(keyValue.key.equals(key)){
                ind = i;
                break;
            }
        }

        if(ind == -1) return null;

        V value = row.get(ind).value;
        row.remove(ind);
        this.length--;

        return value;

//
//        for (Iterator<KeyValue<V>> iterator = row.iterator(); iterator.hasNext();) {
//            KeyValue<V> kv = iterator.next();
//            if (kv.key.equals(key)) {
//                V value = kv.value;
//                iterator.remove(); // Remove de forma segura durante a iteração
//                return value;
//            }
//        }
//
//        return null; // Chave não encontrada
    }

    public ArrayList<String> getAllKeys(){
        ArrayList<String> keys = new ArrayList<>(this.length);
        for(LinkedList<KeyValue<V>> list : this.table){
            for(KeyValue<V> kv : list){
                keys.add(kv.key);
            }
        }

        return keys;
    }

    public ArrayList<V> getAllValues(){
        ArrayList<V> values = new ArrayList<>(this.length);

        for(LinkedList<KeyValue<V>> list : this.table){
            for(KeyValue<V> kv : list){
                values.add(kv.value);
            }
        }

        return values;
    }

    private int _hash(String key) {
        int index = 5831;

        for(char c : key.toCharArray()){
            index *= c ;
        }

        if(index < 0) index *= -1;

        return index % SIZE;
    }

    public static void main(String[] args) {
        AgainHashTable<Integer> againHashTable = new AgainHashTable<>();
        againHashTable.put("teste", 1);
        againHashTable.put("testes", 2);
        againHashTable.put("joana", 3);
        againHashTable.put("padarao", 4);
        againHashTable.put("a", 5);

        againHashTable.delete("testes");

        System.out.println("Keys : ");
        System.out.println(againHashTable.getAllKeys());
        System.out.println("Values : ");
        System.out.println(againHashTable.getAllValues());
    }
}
