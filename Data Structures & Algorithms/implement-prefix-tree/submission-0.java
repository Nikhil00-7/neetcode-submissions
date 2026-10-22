class PrefixTree { 

    PrefixTree [] children;
    boolean eow ;

    public PrefixTree() {
        children = new PrefixTree [26];
        eow = false;
    }
    
    public void insert(String word) {
       PrefixTree curr = this;

       for(int i =0; i < word.length(); i++){
        int idx = word.charAt(i) - 'a';

        if(curr.children[idx] == null){
            curr.children[idx] = new PrefixTree();
        }

       curr = curr.children[idx];
       }     
       curr.eow = true;
    }

    public boolean search(String word) {
    PrefixTree curr = this;

    for(int i=0; i< word.length(); i++){
        int indx = word.charAt(i) - 'a';
       
       if(curr.children[indx] == null){
        return false;
       }
       curr = curr.children[indx];
    }
    return curr.eow;
    }

    public boolean startsWith(String prefix) {
 PrefixTree curr = this;

    for(int i=0; i< prefix.length(); i++){
        int indx = prefix.charAt(i) - 'a';
       
       if(curr.children[indx] == null){
        return false;
       }
       curr = curr.children[indx];
    }
    return true;
    }
}
