package sorting_algorithms;

/**
 * 创建时间：2018-02-03
 *
 * 希尔排序
 *
 * @author long
 */
public class ShellSort implements MySort {

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

        // 使用序列 A102549 地址：https://oeis.org/A102549
        int[] gaps = {1, 4, 10, 23, 57, 132, 301, 701, 1750};
        int idx = gaps.length - 1;
        while ( idx >= 0 ) {
            int start = gaps[idx] + begin;
            for ( int i = start; i < end; i++ ) {
                for ( int j = i; j >= start; j -= gaps[idx] ) {
                    int front = j - gaps[idx];
                    if ( nums[j] >= nums[front] ) {
                        break;
                    }
                    int tmp = nums[j];
                    nums[j] = nums[front];
                    nums[front] = tmp;
                }
            }
            idx--;
        }
    }
}
