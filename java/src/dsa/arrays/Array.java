package dsa.arrays;

public class Array {
    /**
     * Quando você fala de array, você fala de uma estrutura de dados que aloca espaço na memória no momento da instanciação da mesma.
     * <p>
     *  Em Java, um array é um objeto especial que pode conter múltiplos elementos do mesmo tipo. Ele é:
     *  Indexado (você acessa os elementos por posição: args[0], args[1], etc.)
     *  De tamanho fixo (não pode crescer ou diminuir após criado)
     *  Alocado dinamicamente (na heap)
     * </p>
     */

    public int SIZE = 10;
    public int LENGTH = 0;
    public int[] data;


    public Array() {
        this.data = new int[SIZE];
    }

    public Array(int[] data) {
        LENGTH =  data.length;
        this.data = data;
    }

    public void push(int value){
        if(LENGTH >= SIZE){
            this.resize(SIZE);
        }

        this.data[LENGTH] = value;
        LENGTH++;
    }

    public int get(int index){
        if(index >= LENGTH){
            throw new IndexOutOfBoundsException("Indice está fora dos limites");
        }

        return this.data[index];
    }

    public void pop(){
        if(LENGTH > 0){
            this.data[LENGTH - 1] = 0;
            LENGTH--;
            this.shrink();
        }
    }


    public void resize(int size){
        if (size <= 0) return;

        SIZE = size * 2;
        int[] temp = new int[SIZE];
        for(int i = 0; i < LENGTH; i++){
            temp[i] = this.data[i];
        }
        this.data = temp;
    }

    public void shrink(){
        if (SIZE <= 10) return; // não encolhe abaixo do inicial

        if(LENGTH < SIZE / 4){
            SIZE /= 2;
            int[] temp = new int[SIZE];
            for(int i = 0; i < LENGTH; i++){
                temp[i] = this.data[i];
            }
            this.data = temp;
        }
    }

    public Integer shift(){
        if(LENGTH <= 0) return null;

        int value = this.data[0];

        for(int i = 0; i < LENGTH; i++){
            this.data[i] = this.data[i + 1];
        }

        this.data[LENGTH - 1] = 0;

        LENGTH--;

        return value;
    }

    public void shiftChange(int offset){
        if(offset == 0) return;

        int shift = offset;
        if(offset > LENGTH){
            shift = offset % LENGTH;
        }

        int[] temp = new int[SIZE];
        int j = 0;
        for(int i = shift; i < LENGTH; i++){
            temp[j] = this.data[i];
            j++;
        }

        j = 0;
        for(int z = (LENGTH - shift); z < LENGTH; z++){
            temp[z] = this.data[j];
            j++;
        }

        this.data = temp;
        printArray();
    }

    public Integer deleteByIndex(int index){
        if(index > LENGTH - 1 || index < 0){
            return null;
        }

        int value = this.data[index];
        for(int i = index; i < LENGTH - 1; i++){
            this.data[i] = this.data[i + 1];
        }

        this.data[LENGTH - 1] = 0;
        LENGTH--;

        return value;
    }

    public void clear(){
        this.data = new int[SIZE];
        this.LENGTH = 0;
    }

    public void printArray(){
        String arrayString = "[";
        for(int i = 0; i < LENGTH; i++){
            if( (i + 1) < LENGTH ){
                arrayString = arrayString.concat(String.valueOf(this.data[i])).concat(",");
            } else {
                arrayString = arrayString.concat(String.valueOf(this.data[i]));
            }
        }
        arrayString = arrayString.concat("]");
        System.out.println(arrayString);

//        StringBuilder sb = new StringBuilder("[");
//        for(int i = 0; i < LENGTH; i++){
//            sb.append(data[i]);
//            if (i < LENGTH - 1) {
//                sb.append(", ");
//            }
//        }
//        sb.append("]");
    }

    public static void main(String[] args) {
        Array array = new Array();
        array.push(1);
        array.push(2);
        array.push(3);
        array.push(4);
        array.push(5);
        array.push(6);
        array.push(7);
        array.push(8);
        array.push(9);
        array.push(10);
        array.push(11);
        array.push(12);
        array.push(13);
        array.printArray();
        System.out.printf("Array capacity : %d , Array Length : %d", array.SIZE, array.LENGTH);
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.printArray();
        System.out.printf("Array capacity : %d , Array Length : %d", array.SIZE, array.LENGTH);
        array.push(1);
        array.push(2);
        array.push(3);
        array.push(4);
        array.push(5);
        array.push(6);
        array.push(7);
        array.push(8);
        array.push(9);
        array.push(10);
        array.push(11);
        array.push(12);
        array.push(13);
        array.push(1);
        array.push(2);
        array.push(3);
        array.push(4);
        array.push(5);
        array.push(6);
        array.push(7);
        array.push(8);
        array.push(9);
        array.push(10);
        array.push(11);
        array.push(12);
        array.push(13);
        array.push(1);
        array.push(2);
        array.push(3);
        array.push(4);
        array.push(5);
        array.push(6);
        array.push(7);
        array.push(8);
        array.push(9);
        array.push(10);
        array.push(11);
        array.push(12);
        array.push(13);
        array.push(1);
        array.push(2);
        array.push(3);
        array.push(4);
        array.push(5);
        array.push(6);
        array.push(7);
        array.push(8);
        array.push(9);
        array.push(10);
        array.push(11);
        array.push(12);
        array.push(13);
        array.push(1);
        array.push(2);
        array.push(3);
        array.push(4);
        array.push(5);
        array.push(6);
        array.push(7);
        array.push(8);
        array.push(9);
        array.push(10);
        array.push(11);
        array.push(12);
        array.push(13);
        array.printArray();
        System.out.printf("Array capacity : %d , Array Length : %d", array.SIZE, array.LENGTH);
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.printArray();
        System.out.printf("Array capacity : %d , Array Length : %d", array.SIZE, array.LENGTH);
        System.out.println(array.get(8));
        System.out.println();
        array.clear();
        array.push(1);
        array.push(2);
        array.push(3);
        array.push(4);
        array.push(5);
        array.push(6);
        array.push(7);
        array.push(8);
        array.push(9);
        array.push(10);
        array.printArray();
        array.shiftChange(15);
        System.out.println(array.shift());
        array.printArray();
        System.out.println(array.deleteByIndex(15));
        array.printArray();
        System.out.println(array.deleteByIndex(0));
        array.printArray();

    }
}
