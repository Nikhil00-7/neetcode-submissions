class Solution {

    class Trie{
        Trie []children = new Trie[26];
        boolean eow = false;
        int countChild = 0;
    }

    public String longestCommonPrefix(String[] strs) {
      Trie root = new Trie();

      for(String word : strs){

        Trie curr = root;

        for(int i =0; i<word.length(); i++){

            int idx = word.charAt(i) -  'a';
            
            if(curr.children[idx] == null){
                curr.children[idx] =  new Trie();
                curr.countChild ++;
            }

            curr = curr.children[idx]; 
        }
        curr.eow = true;
      }    

      StringBuilder prefix = new StringBuilder();
      Trie curr = root;

      while(curr.countChild ==1 && !curr.eow){
        int idx = 0;
        while(curr.children[idx] == null){
            idx++;
        }
        prefix.append((char) ('a' + idx));
        curr =curr.children[idx];
      }
      return prefix.toString();
    }
}