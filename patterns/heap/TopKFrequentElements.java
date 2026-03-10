class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int len = nums.length;
        List<Integer>[] bucket = new List[len+1];
        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int n : nums){
            freqMap.put(n, freqMap.getOrDefault(n,0)+1);
        }
        List<Integer> res = new ArrayList<>();
        freqMap.forEach((num, freq) -> {
            if(bucket[freq] == null)
                bucket[freq] = new ArrayList<>();
            bucket[freq].add(num);
        });
        for(int i = bucket.length-1; i > 0 && res.size() < k; i--){
            if(bucket[i] != null){
                res.addAll(bucket[i]);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
