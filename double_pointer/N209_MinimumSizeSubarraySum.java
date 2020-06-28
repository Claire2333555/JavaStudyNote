import java.util.Arrays;

class N209_MinimumSizeSubarraySum {
	/**
	 * 时间复杂度为O(n),使用双指针，记录子数组头和尾，用sum存储子数组的和
	 * @param s
	 * @param nums
	 * @return
	 */
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0) return 0;
        int res = Integer.MAX_VALUE;
        int low = 0;
        int high = 0;
        int sum = 0;
        while(high < nums.length){
            sum += nums[high];
            while(sum >= s){
                res = Math.min(res, high - low + 1);
                sum -= nums[low];
                low++;
            }
            high++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
    
    /**
     * 时间复杂度O(nlogn)
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen_nlogn(int s, int[] nums) {
        if(nums.length == 0) return 0;
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        int[] sums = new int[n + 1]; //sums[i] 表示数组前i个数的和，sums有序
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            int target = s + sums[i - 1];  //查找的是目标值与当前和的总值
            int index = Arrays.binarySearch(sums, target);  
            if (index < 0) {   //没有找到，此时index返回的是-(插入点+1)
                index = -index - 1;  //index=插入点
            }
            if (index <= n) {
                res = Math.min(res, index - (i - 1));
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}