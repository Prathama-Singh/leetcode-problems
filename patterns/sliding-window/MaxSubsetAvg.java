package patterns.sliding-window;

public class MaxSubsetAvg {

    public double findMaxAverage(int[] nums, int k) {
        int len = nums.length;
        nums[0] = nums[0];
        for(int i = 1 ; i < len;i ++){
            nums[i] = nums[i] + nums[i-1];
        }
        if(k == len)
            return nums[len - 1]/(double)k;
        int start = 0;
        double avg = nums[k-1]/(double)k;
        for(int i = k ; i < len && start < len ;i ++){
            int currentSum = nums[i] - nums[start];
            avg = Math.max(avg, currentSum/(double)k);
            start++;
        }
        return avg;
    }

    public static void main(String[] args){
        MaxSubsetAvg maxSubsetAvg =  new MaxSubsetAvg();
        System.out.println(maxSubsetAvg.findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
        System.out.println(maxSubsetAvg.findMaxAverage(new int[] {5}, 1));
        System.out.println(maxSubsetAvg.findMaxAverage(new int[]{9,7,3,5,6,2,0,8,1,9}, 6));
    }
}
