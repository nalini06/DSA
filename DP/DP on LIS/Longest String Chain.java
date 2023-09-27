class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a,b) -> a.length() - b.length());
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i =0 ;i<n; i++){
            for(int prev = 0; prev < i; prev++){
                 if( compare(words[i], words[prev])  && dp[i] < dp[prev] +1 ){
                     dp[i] = dp[prev]  + 1;
                 }
            }
        }

        int maxLen = 0;
        for(int i : dp) maxLen = Math.max(i, maxLen);

        return maxLen;
    }

    public boolean compare(String biggerWord, String smallerWord){
        if( biggerWord.length() != smallerWord.length() +1 ) return false;
        int first = 0;
        int second = 0;

        while( first < biggerWord.length() ){
            if( second < smallerWord.length() && biggerWord.charAt(first) == smallerWord.charAt(second) ){
                first++;
                second++;
            }else{
                first++;
            }
        }

        if( first == biggerWord.length() && second == smallerWord.length() ) return true;

        return false;
    }
}