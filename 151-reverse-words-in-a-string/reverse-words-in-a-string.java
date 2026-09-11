class Solution {
    public String reverseWords(String s) {

        StringBuilder res = new StringBuilder();

        // Start from the last character
        int startIndex = s.length() - 1;

        while (startIndex >= 0) {

            // Skip trailing spaces
            while (startIndex >= 0 && s.charAt(startIndex) == ' ') {
                startIndex--;
            }

            // No word left
            if (startIndex < 0) {
                break;
            }

            // End position of current word
            int endIndex = startIndex;

            // Move left until space is found
            while (startIndex >= 0 && s.charAt(startIndex) != ' ') {
                startIndex--;
            }

            // Current word:
            // s.substring(startIndex+1, endIndex+1)

            if (res.length() == 0) {
                res.append(s.substring(startIndex + 1, endIndex + 1));
            } else {
                res.append(" ");
                res.append(s.substring(startIndex + 1, endIndex + 1));
            }
        }

        return res.toString();
    }
}