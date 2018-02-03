package sorting_algorithms;

import java.util.Arrays;

/**
 * 创建日期：2018-02-02
 *
 * 基数排序（只能用于非负数）
 *
 * @author long
 */
public class RadixSort implements MySort {

    @Override
    public void sort(int[] nums) {
        if ( nums == null ) {
            return;
        }
        sort(nums, 0, nums.length);
    }

    @Override
    public void sort(int[] nums, int begin) {
        if ( nums == null ) {
            return;
        }
        sort(nums, begin, nums.length);
    }

    @Override
    public void sort(int[] nums, int begin, int end) {
        if ( nums == null ) {
            return;
        }
        if ( nums.length < 2 || begin >= (end - 1)) {
            return;
        }
        begin = begin < 0 ? 0 : begin;
        end = end > nums.length ? nums.length : end;

        radixSort(nums, begin, end);
    }

    private void radixSort(int[] nums, int begin, int end) {
        int max = -1;
        for ( int i = begin; i < end; i++ ) {
            if ( nums[i] > max ) {
                max = nums[i];
            }
        }
        int max_exp = 1;
        while ( (max / max_exp) >= 10 ) {
            max_exp *= 10;
        }

        int[] count = new int[10];
        int[] a = new int[end-begin], b = new int[a.length], radixs = new int[a.length], exchange;
        System.arraycopy(nums, begin, a, 0, a.length);

        int exp = 1;
        while ( exp <= max_exp ) {
            Arrays.fill(count,0);
            for ( int i = 0; i < a.length; i++) {
                radixs[i] = (a[i] / exp) % 10;
                count[radixs[i]]++;
            }
            for ( int i = 1; i < 10; i++ ) {
                count[i] += count[i-1];
            }
            for ( int i = a.length-1; i >= 0; i-- ) {
                b[--count[radixs[i]]] = a[i];
            }
            exchange = b;
            b = a;
            a = exchange;
            exp *= 10;
        }
        System.arraycopy(a, 0, nums, begin, a.length);
    }

}
