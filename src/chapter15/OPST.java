package chapter15;

// 229页代码，自底向上
public class OPST {
    public static void main(String[] args) {
        //p的第一位要空出来，这里用0来代替
//        double[] p = {0.00, 0.15, 0.10, 0.05, 0.10, 0.20};
//        double[] q = {0.05, 0.10, 0.05, 0.05, 0.05, 0.10};
        double[] p = {0.00, 0.04, 0.06, 0.08, 0.02, 0.10, 0.12, 0.14};
        double[] q = {0.06, 0.06, 0.06, 0.06, 0.05, 0.05, 0.05, 0.05};
        System.out.println(findOPST(p,q));
    }

    private static double findOPST ( double[] p, double[] q ) {
        int n = p.length - 1;
        double[][] e = new double[n+2][n+1], w = new double[n+2][n+1];
        int[][] root = new int[n+1][n+1];
        for ( int i = 1; i <= n + 1; i++ ) {
            e[i][i-1] = q[i-1];
            w[i][i-1] = q[i-1];
        }
        for ( int l = 1; l <= n; l++ ) {
            for ( int i = 1, bound = n - l + 1; i <= bound; i++ ) {
                int j = i + l - 1;
                e[i][j] = Double.MAX_VALUE;
                w[i][j] = w[i][j-1] + p[j] + q[j];
                for ( int r = i; r <= j; r++ ) {
                    double t = e[i][r-1] + e[r+1][j] + w[i][j];
                    if ( t < e[i][j] ) {
                        e[i][j] = t;
                        root[i][j] = r;
                    }
                }
            }
        }
        printOPST( root, 1, n, 0);
        return e[1][n];
    }

    /**
     * 按15.5-1打印树
     * 注意一个节点k(i)，它的左孩纸一定是d(i-1)，右孩纸一定是d(i)
     */
    private static void printOPST(int[][] root, int i, int j, int last_num) {
        int this_id = root[i][j];
        if ( last_num == 0 ) {
            System.out.println("k" + this_id + "为根");
        } else if ( last_num > this_id ) {
            System.out.println("k" + this_id + "为k" + last_num + "的左孩子");
        } else {
            System.out.println("k" + this_id + "为k" + last_num + "的右孩子");
        }
        if ( this_id == i ) {
            System.out.println("d" + (this_id - 1) + "为k" + this_id + "的左孩子");
        } else {
            printOPST( root, i, this_id - 1, this_id);
        }
        if ( this_id == j ) {
            System.out.println("d" + this_id + "为k" + this_id + "的右孩子");
        } else {
            printOPST( root, this_id + 1, j, this_id);
        }
    }
}
