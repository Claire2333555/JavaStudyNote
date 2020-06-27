class N41_FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= 0) nums[i] = nums.length + 1;
        }
        int temp = 0;
        for(int num : nums) {
        	temp = Math.abs(num);
        	if(temp <=  nums.length && nums[temp - 1] > 0) {
        		nums[temp - 1] = -nums[temp - 1];
        	}
        }
        for(int i = 0; i < nums.length ; i++) {
        	if(nums[i] > 0) return i + 1;
        }
        return nums.length + 1;
    }
}