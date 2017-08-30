package chapter15;

// 书中213页的代码
public class MatrixChain {
    public static void main(String[] args) {
//        int[] dims = {30, 35, 15, 5, 10, 20, 25};
        int[] dims = {5, 10, 3, 12, 5, 50, 6};
        System.out.println(multipMin(dims));
    }

    private static String multipMin(int[] dims) {
        int n = dims.length - 1;
        int[][] m = new int[n+1][n+1], s = new int[n+1][n+1];
        for ( int i = 1; i <= n; i++ ) {
            m[i][i] = 0;
        }

        for ( int l = 2; l <= n; l++ ) {
            for ( int i = 1; i <= n - l + 1; i++) {
                int end = i + l - 1;
                m[i][end] = Integer.MAX_VALUE;
                for ( int j = i; j < end; j++ ) {
                    int q = m[i][j] + m[j+1][end] + dims[i-1]*dims[j]*dims[end];
                    if ( q < m[i][end] ) {
                        m[i][end] = q;
                        s[i][end] = j;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        PrintParens( s, 1, n, sb);
        return sb.toString();
    }

    private static void PrintParens(int[][] s, int i, int j, StringBuilder sb) {
        if ( i == j )
            sb.append("A").append(i);
        else {
            sb.append("(");
            PrintParens( s, i, s[i][j], sb);
            PrintParens( s, s[i][j] + 1, j, sb);
            sb.append(")");
        }
    }
}
