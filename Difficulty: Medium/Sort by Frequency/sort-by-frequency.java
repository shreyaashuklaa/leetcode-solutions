class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> {
            if (!map.get(a).equals(map.get(b))) {
                return map.get(a) - map.get(b);
            }
            return a - b; // lexicographical order
        });
        pq.addAll(map.keySet());
        StringBuilder ans = new StringBuilder();
        while (!pq.isEmpty()) {
            char ch = pq.poll();
            int freq = map.get(ch);
            while (freq-- > 0) {
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}