class Solution {
    public boolean isSubsequence(String s, String t) {
        if(t.length() < s.length() || s == "" || t =="") return false;

        int i = 0;
        int j = 0;

        while(i < s.length() && j < t.length()){

            char iCh = s.charAt(i);
            char jCh = t.charAt(j);

            if(iCh == jCh){
                i++;
            }
            j++;
             
            if(j == t.length() && i != s.length()){
                return false;
            }
        }
return true;
    }
}