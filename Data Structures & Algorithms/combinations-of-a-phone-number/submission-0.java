class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return new ArrayList<>();
        }
        
        return helper("" , digits);
    }

    List<String> helper(String p , String up){

        if(up.isEmpty()){
            List<String> result = new ArrayList<>();
            result.add(p);
            return result;
        }

        int digit  = up.charAt(0) - '0';
        if(digit ==1){
            return helper(p , up.substring(1));
        }

        List<String> ans = new ArrayList<>();
        int start = 0;
        int end = 0;

        if(digit >= 2 && digit <= 6){
            start = (digit  -2) * 3;
            end = start + 3;
        }else if(digit ==7){
            start = (digit - 2) * 3;
            end = start +4;
        }else if(digit ==8){
            start = (digit - 2) * 3 +1;
            end = start + 3;
        }else if(digit  == 9){
            start = (digit -2) * 3 +1;
            end = start + 4;
        }

        for(int i = start; i < end ; i++){
            char ch = (char) ('a' + i);
            ans.addAll(helper(p + ch , up.substring(1)));
        }

        return ans;
    }
}
