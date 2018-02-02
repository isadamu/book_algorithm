package sorting_algorithms;

/**
 * 创建时间：2018-02-02
 *
 * 插入排序。
 *
 * @author long
 */
public class InsertionSort implements MySort {

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
        for ( int i = begin + 1; i < end; i++ ) {
            for ( int j = i - 1; j >= 0; j-- ) {
                if ( nums[j] <= nums[j+1] ) {
                    break;
                }
                int tmp = nums[j];
                nums[j] = nums[j+1];
                nums[j+1] = tmp;
            }
        }
    }
}
