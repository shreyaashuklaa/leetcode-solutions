class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

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