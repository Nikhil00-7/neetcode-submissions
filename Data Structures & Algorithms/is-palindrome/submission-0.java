class Solution {
    public boolean isPalindrome(String s) {
        String clear = s.replaceAll("[^a-zA-Z0-9]" ,"").toLowerCase();
        String reverse = new StringBuilder(clear).reverse().toString();

        return clear.equals(reverse);
    }
}
