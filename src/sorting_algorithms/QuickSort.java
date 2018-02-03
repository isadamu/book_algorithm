package sorting_algorithms;


import java.util.Random;

/**
 * 创建时间:2018-02-02
 *
 * 快速排序
 *
 * @author long
 */
public class QuickSort implements MySort {

    private Random rand = new Random();

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
        quickSort(nums, begin, end-1);
    }

    private void quickSort(int[] nums, int p, int q) {
        if ( p >= q ) {
            return;
        }
        int m = partition(nums, p, q);
        if ( m == -1 ) {
            return;
        }
        quickSort(nums, p, m - 1);
        quickSort(nums, m+1, q);
    }

    private int partition(int[] nums, int p, int q) {
        randomExchange(nums, p, q);
        int axle = nums[q];
        int j = p - 1;
        int equals_count = 1;
        for (int i = p; i < q; i++) {
            if (nums[i] < axle) {
                j++;
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
            } else if ( nums[i] == axle ) {
                j++;
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
                equals_count++;
            }
        }
        if ( equals_count == nums.length ) { // 防止所有元素都相等时还进行递归
            return -1;
        }
        j++;
        int tmp = nums[j];
        nums[j] = nums[q];
        nums[q] = tmp;
        return j;
    }

    private void randomExchange(int[] nums, int p, int q) {
        int exchange = rand.nextInt(q-p+1) + p;
        int tmp = nums[exchange];
        nums[exchange] = nums[q];
        nums[q] = tmp;
    }

}
