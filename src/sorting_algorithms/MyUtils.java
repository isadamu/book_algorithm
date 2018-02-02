package sorting_algorithms;

import java.util.Random;

/**
 * 创建日期：2018-02-02
 *
 * 工具类
 *
 * @author long
 */
public class MyUtils {

    public static int[] generateRandomArray(int length, int bound) {
        int[] array = new int[length];
        Random rand = new Random();
        for ( int i = 0; i < length; i++ ) {
            int tmp = rand.nextInt(bound);
            array[i] = tmp;
        }
        return array;
    }
}
