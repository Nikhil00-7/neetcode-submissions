class Solution {
    public int characterReplacement(String s, int k) {
        int []freq = new int [26];
         
        int left =0;
        int right = 0;
        int maxLength =0;
        int maxFreq = 0;
        while(right < s.length()){

            char rightCh = s.charAt(right);
            freq[rightCh -'A']++;

            maxFreq = Math.max(maxFreq , freq[rightCh -'A']);

            while(right -left + 1 - maxFreq > k){
                char leftCh = s.charAt(left);
                freq[leftCh - 'A']--;
                left++;
        
            }

            maxLength = Math.max(maxLength , right -left +1);
            right++;
        }
   return maxLength;

    }
}
