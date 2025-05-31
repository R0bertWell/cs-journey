package problem_solving.challenges;

import java.util.Arrays;

public class ArrayChunk {

    public static int[][] chunkArray(int[] arr, int chunkSize) throws Exception {
        int length = arr.length;

        if(chunkSize > length){
            throw new Exception("ChunkSize maior que o Tamanho do array!");
        }

        int eachChunkLength = (int) Math.ceil((double) length / chunkSize);
        int lastArray = length % chunkSize;



        int[][] finalChunk = new int[eachChunkLength][chunkSize];
        int index = 0;
        for(int i = 0; i < eachChunkLength; i ++){
            if(lastArray != 0 && (i == eachChunkLength - 1)) {
                chunkSize = lastArray;
                finalChunk[i] = new int[chunkSize];
            }
            for(int j = 0; j < chunkSize; j ++){
                if(index > length  - 1) break;
                finalChunk[i][j] = arr[index];
                index++;
            }
        }

        return finalChunk;
    }

    public static int[][] chunkArrayQuantity(int[] arr, int chunkQuantity) throws Exception {
        int length = arr.length;

        int chunksSize = length / chunkQuantity;

        int[][] finalChunk = new int[chunkQuantity][chunksSize];
        int index = 0;
        for(int i = 0; i < chunkQuantity; i ++){
            for(int j = 0; j < chunksSize; j ++){
                if(index > length  - 1) break;
                finalChunk[i][j] = arr[index];
                index++;
            }
        }

        return finalChunk;
    }

    public static void main(String[] args) throws Exception {
        //System.out.println(Arrays.asList(chunkArray(new int[]{1,2,3,4,5,6,7,8}, 9)));
        System.out.println(Arrays.asList(chunkArrayQuantity(new int[]{1,2,3,4,5}, 2)));
        System.out.println(Arrays.asList(chunkArrayQuantity(new int[]{1,2,3,4,5,6,7,8},3)));

    }
}
