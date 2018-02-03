package sorting_algorithms;


/**
 * 创建时间：2018-02-03
 *
 * 桶排序
 *
 * @author long
 */
public class BucketSort {

    private class Bucket {
        int num = -1;
        Bucket front, next;
    }

    public void sort(int[] nums, int bound) {
        if (nums == null || nums.length < 2 ) {
            return;
        }

        int bucket_num = Math.min(nums.length, bound);
        Bucket[] buckets = new Bucket[bucket_num];
        for ( int i = 0; i < bucket_num; i++ ) {
            buckets[i] = new Bucket();
        }

        for ( int num : nums ) {
            insertHelper(buckets[(num*bucket_num) / bound], num);
        }

        int idx = 0;
        for ( Bucket bucket : buckets ) {
            while ( bucket.next != null ) {
                bucket = bucket.next;
                nums[idx++] = bucket.num;
            }
        }
    }

    private void insertHelper(Bucket bucket, int num) {
        Bucket in = new Bucket();
        in.num = num;
        while ( bucket.next != null && bucket.next.num < num ) {
            bucket = bucket.next;
        }
        if ( bucket.next == null ) {
            bucket.next = in;
            in.front = bucket;
        } else {
            in.next = bucket.next;
            in.front = bucket;
            bucket.next.front = in;
            bucket.next = in;
        }
    }

}
