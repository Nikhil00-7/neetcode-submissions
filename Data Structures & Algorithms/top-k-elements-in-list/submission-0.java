class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer , Integer> map = new HashMap<>();

        for(int i =0; i<nums.length; i++){
            map.put(nums[i] , map.getOrDefault(nums[i] , 0)+1);
        }

        List<Integer> [] bucket = new ArrayList[nums.length+1];

        for(int key: map.keySet()){
            int freq = map.get(key);
            if(bucket[freq] == null){
                bucket[freq] =new  ArrayList<>();
            }

            bucket[freq].add(key);
        }

        int []result = new int[k];
        int count= 0;
        for(int i =bucket.length-1; i >=0 && count <k;i--){
          if(bucket[i] != null){
            for(int num : bucket[i]){
                result[count++] = num;
                if(count == k){
                    break;
                }
            }
          }
        }
        return result;
    }
}
