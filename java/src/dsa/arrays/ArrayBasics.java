package dsa.arrays;


public class ArrayBasics {
    /*
        Arrays by itself has fixed length!
        Usually in production we use ArrayLists that can shrink and expand the array,
        copying the values from the current array to a new array with more size!
     */


    /*
     * Inserir elementos
     * Remover elementos
     * Atualizar um valor
     * Imprimir array
     * Redimensionar array (simular dynamic array)
     */

    public static void main(String[] args) {
        printArray(new int[]{1,2,3,4,5,6,7});
        printArray(expandArray(new int[]{1,2,3,4,5,6,7}));
    }

    public static int[] insert(int[] arr, int index, int value){
        checkArrayConstraint(arr, index);

        int[] newArr = new int[arr.length + 1];

        for(int i = 0, j = 0; i < newArr.length; i++){
            if(index == i){
                newArr[i] = value;
            } else {
                newArr[i] = arr[j++];
            }
        }

        return newArr;
    }

    public static int[] remove(int[] arr, int index){
        checkArrayConstraint(arr, index);

        int[] newArr = new int[arr.length - 1];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (i == index) continue; // pula o índice a ser removido
            newArr[j++] = arr[i];
        }
        return newArr;
    }

    public static int[] update(int[] arr, int index, int value){
        checkArrayConstraint(arr, index);

        for (int i = 0; i < arr.length; i++) {
            if (i == index) arr[i] = value;
        }
        return arr;
    }

    public static void printArray(int[] arr){
        StringBuilder str = new StringBuilder("[");
        for(int i = 0; i < arr.length; i++){
            str.append(arr[i]);

            if(i < arr.length - 1) str.append(", ");
        }
        str.append("]");
        System.out.println(str);
    }

    private static int[] expandArray(int[] arr){
        int[] newArr = new int[arr.length * 2];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        return newArr;
    }

    private static void checkArrayConstraint(int[] arr, int index){
        if (arr == null)
            throw new IllegalArgumentException("Array cannot be null");

        if (index < 0 || index >= arr.length)
            throw new IndexOutOfBoundsException("Index out of bounds: " + index + " to " + (arr.length - 1));
    }
}
