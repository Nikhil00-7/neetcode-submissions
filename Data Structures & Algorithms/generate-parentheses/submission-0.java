class Solution {
    public List<String> generateParenthesis(int n) {

        List<String > list = new ArrayList<>();
        helper(n , list , 0 , 0 , "");

        return list;
    }

    void helper(int n ,List<String> list , int open ,int close ,String current){
        if(open ==n && close == n){
            list.add(current);
            return;
        }

        if(open < n){
            helper(n , list , open+ 1 , close , current + "(");
        }

        if(close < open){
            helper(n ,list , open , close +1  , current + ")");
        }
    }
}
