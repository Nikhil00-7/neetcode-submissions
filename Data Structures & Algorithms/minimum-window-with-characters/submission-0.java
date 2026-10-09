class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character , Integer> need = new HashMap<>();
        HashMap<Character , Integer> have = new HashMap<>();
        
        int minLength = Integer.MAX_VALUE;
        int start = 0;

        for(int i =0; i< t.length(); i++){
            char ch = t.charAt(i);
            need.put(ch ,need.getOrDefault(ch , 0)+1);
        }
        
        int left = 0;
        for(int right = 0; right < s.length(); right++){

            char ch = s.charAt(right);
            have.put(ch , have.getOrDefault(ch, 0)+1);

            boolean valid = true;

            for(char c : need.keySet()){
                if(have.getOrDefault(c , 0)< need.get(c)){
                    valid = false;
                    break;
                }
            }

            while(valid){

                int length = right -left+1;
                if(length < minLength){
                    minLength = length;
                    start = left;
                }

                char leftCh = s.charAt(left);
                have.put(leftCh , have.get(leftCh) -1);

                if(have.get(leftCh) == 0){
                    have.remove(leftCh);
                }
                left++;
                
                valid = true;
                for(char c : need.keySet()){
                if(have.getOrDefault(c , 0)< need.get(c)){
                    valid = false;
                    break;
                }
            }

            }
        }

        if(minLength == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(start , start + minLength);
    }
}
