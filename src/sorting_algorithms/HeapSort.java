package sorting_algorithms;


/**
 * 创建时间：2018-02-02
 *
 * 堆排序
 *
 * @author long
 */
public class HeapSort implements MySort {

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
        int[] array = new int[end-begin];
        System.arraycopy(nums, begin, array, 0, array.length);
        heapSort(array);
        System.arraycopy(array, 0, nums, begin, array.length);
    }

    private void heapSort(int[] nums) {
        buildMaxHeap(nums);
        for ( int i = nums.length-1; i > 0; i-- ) {
            int tmp = nums[0];
            nums[0] = nums[i];
            nums[i] = tmp;
            maxHeapify(nums, i, 0);
        }
    }


    private void buildMaxHeap(int[] heap) {
        for ( int i = heap.length / 2 - 1; i >= 0; i-- ) {
            maxHeapify(heap, heap.length, i);
        }
    }

    private void maxHeapify(int[] heap, int len, int i) {
        int l = left(i), r = right(i);
        int largest = i;
        if ( l < len && heap[l] > heap[largest] ) {
            largest = l;
        }
        if ( r < len && heap[r] > heap[largest] ) {
            largest = r;
        }
        if ( largest != i ) {
            int tmp = heap[i];
            heap[i] = heap[largest];
            heap[largest] = tmp;
            maxHeapify(heap, len, largest);
        }
    }

    private int parent(int i) {
        return (i + 1) / 2 - 1;
    }

    private int left(int i) {
        return (i + 1) * 2 - 1;
    }

    private int right(int i) {
        return (i + 1) * 2;
    }
}
