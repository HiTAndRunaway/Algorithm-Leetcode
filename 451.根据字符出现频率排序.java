class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i < s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) + 1);
        }
        PriorityQueue<Character> heap = new PriorityQueue<>((o1,o2) -> map.get(o2) - map.get(o1));
        heap.addAll(map.keySet());
        StringBuilder res = new StringBuilder();
        while(!heap.isEmpty()){
            char key = heap.poll();
            int value = map.get(key);
            for(int i=0;i < value;i++){
                res.append(key);
            }
        }
        
        return res.toString();
    }
}