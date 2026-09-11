class Solution {
    public String reverseWords(String s) {

        String[] words = s.split("\\.+");

        StringBuilder ans = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i].length() == 0) {
                continue;
            }
            if (ans.length() > 0) {
                ans.append(".");
            }

            ans.append(words[i]);
        }

        return ans.toString();
    }
}