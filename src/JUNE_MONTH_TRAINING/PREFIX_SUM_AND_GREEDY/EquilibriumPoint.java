package JUNE_MONTH_TRAINING.PREFIX_SUM_AND_GREEDY;

public class EquilibriumPoint {
    public static int findEquilibrium(int arr[]) {
        // code here
        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
        int suffixSum = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            suffixSum += arr[i];
            if (prefixSum[i] == suffixSum) return i;
        }
        return -1;
    }
    public static void main(String[] args) {

    }
}
