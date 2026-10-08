class Solution {
    public int lengthOfLongestSubstring(String s) {
         Map<Character , Integer> map = new HashMap<>();

        int left = 0;
        int uniq = 0;

        for(int right = 0; right < s.length(); right ++){

            char rightCh = s.charAt(right);
            map.put(rightCh, map.getOrDefault(rightCh, 0)+1);

            while(map.get(rightCh) > 1){
                 
                 char leftChar = s.charAt(left);
                 
                map.put(leftChar, map.get(leftChar)-1);

                if (map.get(leftChar) ==0){
                    map.remove(leftChar);
                }

                left++;
            }

            uniq = Math.max(uniq, right - left +1);

        }

        return uniq;
    }
}
