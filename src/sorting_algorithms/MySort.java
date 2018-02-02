package sorting_algorithms;


/**
 * 创建时间：2018-02-02
 * sort类的通用sort接口，这里只针对int类型的排序。
 *
 * @author long
 */
public interface MySort {
    void sort(int[] nums);
    void sort(int[] nums, int begin);
    void sort(int[] nums, int begin, int end);
}
