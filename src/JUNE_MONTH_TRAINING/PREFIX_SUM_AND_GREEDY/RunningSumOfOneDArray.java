package JUNE_MONTH_TRAINING.PREFIX_SUM_AND_GREEDY;

public class RunningSumOfOneDArray {
     public int[] runningSum(int[] nums) {
        int[] resultArray = new int[nums.length];
        resultArray[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            resultArray[i]=resultArray[i-1]+nums[i];
        }
        return resultArray;
    }
    public static void main(String[] args) {

    }
}
