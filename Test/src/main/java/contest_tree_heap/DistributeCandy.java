package contest_tree_heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.OptionalInt;

public class DistributeCandy {
    public int candy(ArrayList<Integer> A) {
        int size = A.size();
        int[] list = new int[size];
        Arrays.fill(list,1);
        for(int i =1 ;i<size;i++) {
            if(A.get(i) > A.get(i-1)) {
                list[i] = list[i-1] +1;
            }
        }
        for(int i =size-2 ;i>=0; i--) {
            if(A.get(i) > A.get(i+1)) {
                if(list[i] < list[i+1] +1) list[i] = list[i+1] +1;
            }
        }
        int sum = Arrays.stream(list).reduce(0,Integer::sum);

        return sum;
    }
}
