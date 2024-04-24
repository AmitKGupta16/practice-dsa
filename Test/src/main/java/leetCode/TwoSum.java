package leetCode;

import javax.management.InstanceNotFoundException;
import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for(int i=0;i<nums.length;i++) {
            for(int j=i+1;j<nums.length;j++) {
                if(nums[i] + nums[j] == target) {
                    res[0] = nums[i];
                    res[1] = nums[j];
                }
            }
        }
        return res;
    }

    public int[] twoSum1(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            if(map.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = map.get(target - nums[i]);
                return res;

            }
            map.put(nums[i],i);
        }
        return res;
    }

    public int[] twoSum2(int[] A, int target) {
        int[] output = new int[2];
        for(int i=0;i<A.length;i++) {
            for(int j= i+1;j<A.length;j++) {
                if(A[i]+A[j] == target) {
                    output[0] = i;
                    output[1] = j;
                }
            }
        }
        return output;
    }

    public int[] twoSum3(int[] nums, int target) {
        int[] output = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            if(map.containsKey(target - nums[i])) {
                output[0] = i;
                output[1] = map.get(target - nums[i]);
            }
            map.put(nums[i],i);
        }
        return output;
    }
}
