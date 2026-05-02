class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Count consecutive duplicates
        List<int[]> freqList = new ArrayList<>(); // each element = {num, count}
        int count = 1;
        for (int i = 1; i <= nums.length; i++) {
            if (i < nums.length && nums[i] == nums[i - 1]) {
                count++;
            } else {
                freqList.add(new int[]{nums[i - 1], count});
                count = 1;
            }
        }

        // Step 3: Sort by frequency (descending)
        freqList.sort((a, b) -> b[1] - a[1]);

        // Step 4: Collect top k elements
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = freqList.get(i)[0];
        }

        return result;
    }

}
    
        
    



    

