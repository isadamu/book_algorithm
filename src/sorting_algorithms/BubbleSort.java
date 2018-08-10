package sorting_algorithms;


/**
 * 创建时间：2018-02-02
 *
 * 冒泡排序
 *
 * @author long
 */
public class BubbleSort implements MySort {

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
        boolean change;
        for ( int i = begin; i < end; i++ ) {
            change = false;
            for ( int j = end - 1; j > i; j-- ) {
                if ( nums[j] < nums[j-1] ) {
                    int tmp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = tmp;
                    change = true;
                }
            }
            if ( !change ) {
                break;
            }
        }
    }
}
