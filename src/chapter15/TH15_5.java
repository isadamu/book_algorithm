package chapter15;

public class TH15_5 {

    public static void main(String[] args) {
//        System.out.println(editDistance("oanvfuvanld", "pavofinvafo"));
//        System.out.println(editDistance("aabc", "abacd"));
//        System.out.println(-editDistance("GATCGGCAT", "CAATGTGAATC"));
        System.out.println(-editDistance("abcdd", "abcc"));
    }

    private static final int copy = -1;
    private static final int replace = 1;
    private static final int delete = 2;
    private static final int insert = 2;
    private static final int twiddle = 10000;
    private static final int kill = 0;

    private static int editDistance( String a, String b ) {
        char[] aa = a.toCharArray(), bb = b.toCharArray();
        int[][] dp = new int[aa.length+1][bb.length+1];
        for ( int i = 1; i <= aa.length; i++ )
            dp[i][0] = kill;
//            dp[i][0] = delete * i;
        for ( int j = 1; j <= bb.length; j++ )
            dp[0][j] = insert * j;
        for ( int i = 1; i <= aa.length; i++ ) {
            for ( int j = 1; j <= bb.length; j++ ) {
                dp[i][j] = Integer.MAX_VALUE;
                if ( aa[i-1] == bb[j-1] ) {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1] + copy);
                }
                if ( i != 1 && j != 1 && aa[i-1] == bb[j-2] && aa[i-2] == bb[j-1] ) {
                    dp[i][j] = Math.min(dp[i][j], dp[i-2][j-2] + twiddle);
                }
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1] + replace);
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + delete);
                dp[i][j] = Math.min(dp[i][j], dp[i][j-1] + insert);
            }
        }
//        int min = Integer.MAX_VALUE;
//        for ( int i = 0; i <= aa.length; i++ ) {
//            min = Math.min(min, dp[i][bb.length] );
//        }
//        return min + kill;
        return dp[aa.length][bb.length];
    }

}
