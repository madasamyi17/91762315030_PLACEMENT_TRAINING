package JUNE_MONTH_TRAINING.PREFIX_SUM_AND_GREEDY;

public class KadanesAlgo {
    static int maxSubarraySum(int[] arr) {
        // Code here
        int currSum =0;
        int maxSum = Integer.MIN_VALUE;
        for(int i:arr){
            if(currSum+i < i){
                currSum = i;
            }
            else{
                currSum+=i;
            }
            maxSum = Math.max(maxSum,currSum);
        }
        return maxSum;
    }
    public static void main(String[] args) {

    }
}
