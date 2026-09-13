class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {

        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (String str : arr) {

            int[] freq = new int[26];

            for (char ch : str.toCharArray()) {
                freq[ch - 'a']++;
            }

            StringBuilder key = new StringBuilder();

            for (int count : freq) {
                key.append('#').append(count);
            }

            map.putIfAbsent(key.toString(), new ArrayList<>());
            map.get(key.toString()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}