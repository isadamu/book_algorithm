package sorting_algorithms;


/**
 * 创建日期：2018-02-02
 *
 * 计数排序
 *
 * @author long
 */
public class CountingSort {

    public void sort(int[] nums, int k) {
        if (nums == null || nums.length < 2 ) {
            return;
        }
        int[] count = new int[k];
        for ( int i = 0; i < nums.length; i++ ) {
            count[nums[i]]++;
        }
        for ( int j = 1; j < k; j++ ) {
            count[j] += count[j-1];
        }
        int[] copy = new int[nums.length];
        System.arraycopy(nums, 0, copy, 0, copy.length);
        for ( int i = copy.length-1; i >= 0; i-- ) {
            nums[--count[copy[i]]] = copy[i];
        }
    }
}
