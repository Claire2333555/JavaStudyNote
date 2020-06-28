/**
 * 因为不允许使用额外的存储空间，所以很容易相到需要用标记为
 * 1. 将数组中所有数字都变成大于0的整数，可知res最大为数组长度N+1，故此将所有小于0的数都置为N+1
 * 2. 遍历数组，将所有０＜ｘ＜＝Ｎ的数字对应的数组位置打上标记
 * 3. 再次遍历数组，如果所有位置都小于0，则返回N+1；否则，返回第一个整数位索引+1
 * @author claire
 *
 */
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