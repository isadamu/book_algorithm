package sorting_algorithms;


/**
 * 创建时间：2018-02-02
 *
 * 归并排序
 *
 * @author long
 */
public class MergeSort implements MySort {

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
        mergeSort(nums, begin, end);
    }

    private void mergeSort(int[] nums, int begin, int end) {
        if ( begin >= (end - 1) ) {
            return;
        }
        int mid = (end + begin) / 2;
        mergeSort(nums, begin, mid);
        mergeSort(nums, mid, end);
        int[] a = new int[mid-begin], b = new int[end-mid];
        System.arraycopy(nums, begin, a, 0, a.length);
        System.arraycopy(nums, mid, b, 0, b.length);
        int idx1 = 0, idx2 = 0;
        for ( int i = begin; i < end; i++ ) {
            if ( idx1 >= a.length ) {
                nums[i] = b[idx2++];
            } else if ( idx2 >= b.length || a[idx1] <= b[idx2] ) {
                nums[i] = a[idx1++];
            } else {
                nums[i] = b[idx2++];
            }
        }
    }
}
