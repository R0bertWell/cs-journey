package dsa.sorting_algorithms.visualization.merge;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class MergeSortVisualizer extends JPanel {
    private int[] array;
    private static final int BAR_WIDTH = 20;
    private static final int DELAY = 500; // ms delay between frames

    public MergeSortVisualizer(int[] array) {
        this.array = Arrays.copyOf(array, array.length);
        setPreferredSize(new Dimension(array.length * BAR_WIDTH + 100, 400));
    }

    public void startSort() {
        new Thread(() -> {
            mergeSort(array, 0, array.length - 1);
        }).start();
    }

    private void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int middle = (left + right) / 2;
        mergeSort(arr, left, middle);
        mergeSort(arr, middle + 1, right);
        merge(arr, left, middle, right);

        repaint();
        sleep();
    }

    private void merge(int[] arr, int left, int middle, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = middle + 1, k = 0;

        while (i <= middle && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= middle) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (int m = 0; m < temp.length; m++) {
            arr[left + m] = temp[m];
            repaint();
            sleep();
        }
    }

    private void sleep() {
        try {
            Thread.sleep(DELAY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int height = getHeight();
        for (int i = 0; i < array.length; i++) {
            int barHeight = array[i] * 3;
            g.setColor(Color.BLUE);
            g.fillRect(i * BAR_WIDTH + 50, height - barHeight - 30, BAR_WIDTH - 2, barHeight);
            g.setColor(Color.BLACK);
            g.drawString(String.valueOf(array[i]), i * BAR_WIDTH + 55, height - 10);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 3, 27, 9, 10, 17, 82, 38, 43};

        JFrame frame = new JFrame("Merge Sort Visualizer");
        MergeSortVisualizer visualizer = new MergeSortVisualizer(arr);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(visualizer);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        visualizer.startSort();
    }
}