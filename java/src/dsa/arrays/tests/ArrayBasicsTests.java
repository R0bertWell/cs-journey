package dsa.arrays.tests;

import dsa.arrays.ArrayBasics;

public class ArrayBasicsTests {
    public static void main(String[] args) {
        testInsertMiddle();
        testInsertBeginning();
        testInsertEnd();
        testInsertNullArray();
        testInsertInvalidIndex();
        System.out.println("Todos os testes passaram!");
    }

    static void testInsertMiddle() {
        int[] original = {10, 20, 30};
        int[] expected = {10, 99, 20, 30};
        int[] result = ArrayBasics.insert(original, 1, 99);
        assert arraysEqual(result, expected) : "testInsertMiddle falhou";
    }

    static void testInsertBeginning() {
        int[] original = {1, 2, 3};
        int[] expected = {99, 1, 2, 3};
        int[] result = ArrayBasics.insert(original, 0, 99);
        assert arraysEqual(result, expected) : "testInsertBeginning falhou";
    }

    static void testInsertEnd() {
        int[] original = {5, 6, 7};
        int[] expected = {5, 6, 7, 99};
        int[] result = ArrayBasics.insert(original, 3, 99);
        assert arraysEqual(result, expected) : "testInsertEnd falhou";
    }

    static void testInsertNullArray() {
        try {
            ArrayBasics.insert(null, 0, 5);
            assert false : "testInsertNullArray deveria lançar IllegalArgumentException";
        } catch (IllegalArgumentException e) {
            // esperado
        }
    }

    static void testInsertInvalidIndex() {
        try {
            ArrayBasics.insert(new int[]{1, 2, 3}, 5, 99);
            assert false : "testInsertInvalidIndex deveria lançar IndexOutOfBoundsException";
        } catch (IndexOutOfBoundsException e) {
            // esperado
        }
    }

    static boolean arraysEqual(int[] a, int[] b) {
        if (a == null || b == null) return false;
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
