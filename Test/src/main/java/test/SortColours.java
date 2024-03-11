package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortColours {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(2,0,2,1,1,0));
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        Arrays.stream(nums).forEach(value -> System.out.print(value));
        //System.out.println(sortColour(A));
    }
    public static ArrayList<Integer> sortColour(ArrayList<Integer> A) {
        int[] arr = new int[3];
        int N = A.size();
        for(int i=0;i<N;i++) {
            if(A.get(i)==0) arr[0]++;
            if(A.get(i)==1) arr[1]++;
            if(A.get(i)==2) arr[2]++;
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<3;i++) {
            while(arr[i] > 0) {
                res.add(i);
                arr[i]--;
            }
        }
        return res;
    }
    public static void sortColors(int[] nums) {
        int[] arr = new int[3];

        for(int val :nums) {
            if(val==0) arr[0]++;
            if(val==1) arr[1]++;
            if(val==2) arr[2]++;
        }
        int i=0;
        for(int j=0;j<3;j++) {
            while(arr[j] > 0) {
                nums[i] = j;
                arr[j]--;
                i++;
            }
        }

    }
}
