package sorting_algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 创建时间：2018-02-03
 *
 * 算法时间效率对比
 *
 * @author long
 */
public class AlgorithmCompare {

    public static void main(String[] args) {

        Random rand = new Random();

        int param1 = 20;
        int param2 = 100;

        List<int[]> samples = new ArrayList<>();
        for ( int i = 0; i < 100000; i++ ) {
            int[] array = MyUtils.generateRandomArray(rand.nextInt(param1), param2);
            samples.add(array);
        }
        List<int[]> sorted_samples = arraysCopy(samples);
        for ( int[] array : sorted_samples ) {
            Arrays.sort(array);
        }

        long begin, end;
        {
            /************* 冒泡排序 ***********/
            begin = System.currentTimeMillis();
            BubbleSort sort = new BubbleSort();
            List<int[]> copys = arraysCopy(samples);
            for (int[] array : copys) {
                sort.sort(array);
            }
            end = System.currentTimeMillis();
            System.out.println("冒泡排序用时： " + (end - begin) + "ms");
            correctCheck(sorted_samples, copys);
        }
        {
            /************* 插入排序 ***********/
            begin = System.currentTimeMillis();
            InsertionSort sort = new InsertionSort();
            List<int[]> copys = arraysCopy(samples);
            for (int[] array : copys) {
                sort.sort(array);
            }
            end = System.currentTimeMillis();
            System.out.println("插入排序用时： " + (end - begin) + "ms");
            correctCheck(sorted_samples, copys);
        }
        {
            /************* 希尔排序 ***********/
            begin = System.currentTimeMillis();
            ShellSort sort = new ShellSort();
            List<int[]> copys = arraysCopy(samples);
            for (int[] array : copys) {
                sort.sort(array);
            }
            end = System.currentTimeMillis();
            System.out.println("希尔排序用时： " + (end - begin) + "ms");
            correctCheck(sorted_samples, copys);
        }
        {
            /************* 归并排序 ***********/
            begin = System.currentTimeMillis();
            MergeSort sort = new MergeSort();
            List<int[]> copys = arraysCopy(samples);
            for (int[] array : copys) {
                sort.sort(array);
            }
            end = System.currentTimeMillis();
            System.out.println("归并排序用时： " + (end - begin) + "ms");
            correctCheck(sorted_samples, copys);
        }
        {
            /************* 堆排序 ***********/
            begin = System.currentTimeMillis();
            HeapSort sort = new HeapSort();
            List<int[]> copys = arraysCopy(samples);
            for (int[] array : copys) {
                sort.sort(array);
            }
            end = System.currentTimeMillis();
            System.out.println("堆排序用时： " + (end - begin) + "ms");
            correctCheck(sorted_samples, copys);
        }
        {
            /************* 快速排序 ***********/
            begin = System.currentTimeMillis();
            QuickSort sort = new QuickSort();
            List<int[]> copys = arraysCopy(samples);
            for (int[] array : copys) {
                sort.sort(array);
            }
            end = System.currentTimeMillis();
            System.out.println("快速排序用时： " + (end - begin) + "ms");
            correctCheck(sorted_samples, copys);
        }
        {
            /************* 计数排序 ***********/
            begin = System.currentTimeMillis();
            CountingSort sort = new CountingSort();
            List<int[]> copys = arraysCopy(samples);
            for (int[] array : copys) {
                sort.sort(array, param2);
            }
            end = System.currentTimeMillis();
            System.out.println("计数排序用时： " + (end - begin) + "ms");
            correctCheck(sorted_samples, copys);
        }
        {
            /************* 基数排序 ***********/
            begin = System.currentTimeMillis();
            RadixSort sort = new RadixSort();
            List<int[]> copys = arraysCopy(samples);
            for (int[] array : copys) {
                sort.sort(array);
            }
            end = System.currentTimeMillis();
            System.out.println("基数排序用时： " + (end - begin) + "ms");
            correctCheck(sorted_samples, copys);
        }
        {
            /************* 桶排序 ***********/
            begin = System.currentTimeMillis();
            BucketSort sort = new BucketSort();
            List<int[]> copys = arraysCopy(samples);
            for (int[] array : copys) {
                sort.sort(array, param2);
            }
            end = System.currentTimeMillis();
            System.out.println("桶排序用时： " + (end - begin) + "ms");
            correctCheck(sorted_samples, copys);
        }
    }

    private static List<int[]> arraysCopy(List<int[]> arrays) {
        List<int[]> copys = new ArrayList<>();
        for ( int[] array : arrays ) {
            int[] copy = new int[array.length];
            System.arraycopy(array, 0, copy, 0, array.length);
            copys.add(copy);
        }
        return copys;
    }

    private static void correctCheck(List<int[]> a, List<int[]> b) {
        if ( a.size() != b.size() ) {
            System.out.println("出错！！！");
        }
        for ( int i = 0, size = a.size(); i < size; i++ ) {
            if ( !Arrays.equals(a.get(i), b.get(i)) ) {
                System.out.println("出错！！！");
                return;
            }
        }
        System.out.println("正确。");
    }
}
