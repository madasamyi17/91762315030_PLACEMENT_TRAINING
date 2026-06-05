package JUNE_MONTH_TRAINING.PREFIX_SUM_AND_GREEDY;

public class MoveAllZeroestoEnd {
    static void pushZerosToEnd(int[] arr) {
        // code here
        int i=0;
        int j=0;
        while(i<arr.length && j<arr.length){
            if(arr[i]!=0){
                i++;
                j++;
            }
            else{
                while(j<arr.length-1 && arr[j]==0){
                    j++;
                }
                arr[i]=arr[j];
                arr[j]=0;
                i++;
            }
        }

    }
    public static void main(String[] args) {

    }
}
