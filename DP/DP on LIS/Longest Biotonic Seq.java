import java.util.*;
public class Solution {
    public static int longestBitonicSequence(int[] arr, int n) {
        int[] leftToRightDp = new int[n];
        int[] rightToLeftDp = new int[n];
        Arrays.fill(leftToRightDp, 1);
        Arrays.fill(rightToLeftDp, 1);
        for(int i =0; i<n; i++){
            for(int prev = 0; prev<i; prev++){
                if( arr[prev] < arr[i] && leftToRightDp[i] < leftToRightDp[prev] + 1 ){
                    leftToRightDp[i] = leftToRightDp[prev] + 1;
                }
            }
        }


        for(int i = n-1; i>=0; i--){
            for(int front = n-1; front > i; front--){
                if( arr[front] < arr[i] && rightToLeftDp[i] < rightToLeftDp[front]+1 ){
                    rightToLeftDp[i] = rightToLeftDp[front] + 1;
                }
            }
        }

        int[] biotonicLengths = new int[n];

        for(int i=0; i<n; i++){
            biotonicLengths[i] = (leftToRightDp[i] + rightToLeftDp[i]) -1;
        }

        int maxLen = 0;

        for(int i : biotonicLengths) maxLen  = Math.max(maxLen, i);

        return maxLen;
    }
}
