package sorting_algorithms;

import java.util.Arrays;
import java.util.Random;

/**
 * 创建日期：2018-02-02
 *
 * 检查排序算法的正确性
 *
 * @author long
 */
public class CorrectnessCheck {

    public static void main(String[] args) {
        Random rand = new Random();

//        InsertionSort algorithm = new InsertionSort();
//        BubbleSort algorithm = new BubbleSort();
//        MergeSort algorithm = new MergeSort();
//        HeapSort algorithm = new HeapSort();
//        QuickSort algorithm = new QuickSort();
//        CountingSort algorithm = new CountingSort();
        RadixSort algorithm = new RadixSort();

        for ( int i = 0; i < 1000; i++ ) {
            int[] array = MyUtils.generateRandomArray(rand.nextInt(10240), 10000);
            int[] copy = new int[array.length];
            System.arraycopy(array, 0, copy, 0, array.length);
            algorithm.sort(array);
            Arrays.sort(copy);
            if ( !Arrays.equals(array, copy) ) {
                System.out.println("这里仿佛出现了错误。");
            }
        }
    }

}
