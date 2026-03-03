package patterns.slidingwindow;

public class MaxSubsetAvg {

    public double findMaxAverage(int[] nums, int k) {
        int len = nums.length;
        int sum = 0;
        for(int i = 0 ; i < k; i ++){
            sum = sum + nums[i];
        }
        int maxSum = sum;
        for(int i = k ; i < len; i ++){
            sum += nums[i];
            sum -= nums[i-k] ;
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum/(double)k;
    }

    public static void main(String[] args){
        MaxSubsetAvg maxSubsetAvg =  new MaxSubsetAvg();
        System.out.println(maxSubsetAvg.findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
        System.out.println(maxSubsetAvg.findMaxAverage(new int[] {5}, 1));
        System.out.println(maxSubsetAvg.findMaxAverage(new int[]{9,7,3,5,6,2,0,8,1,9}, 6));
    }
}
