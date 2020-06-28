import java.util.Arrays;

class N209_MinimumSizeSubarraySum {
	/**
	 * ʱ�临�Ӷ�ΪO(n),ʹ��˫ָ�룬��¼������ͷ��β����sum�洢������ĺ�
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
     * ʱ�临�Ӷ�O(nlogn)
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen_nlogn(int s, int[] nums) {
        if(nums.length == 0) return 0;
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        int[] sums = new int[n + 1]; //sums[i] ��ʾ����ǰi�����ĺͣ�sums����
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            int target = s + sums[i - 1];  //���ҵ���Ŀ��ֵ�뵱ǰ�͵���ֵ
            int index = Arrays.binarySearch(sums, target);  
            if (index < 0) {   //û���ҵ�����ʱindex���ص���-(�����+1)
                index = -index - 1;  //index=�����
            }
            if (index <= n) {
                res = Math.min(res, index - (i - 1));
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}