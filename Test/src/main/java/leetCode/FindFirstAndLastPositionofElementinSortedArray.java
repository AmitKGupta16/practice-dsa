package leetCode;

public class FindFirstAndLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int start =0 ,end = nums.length-1, firstIndex=-1,secondIndex=-1;
        int[] output = {-1,-1};

        while(start <= end) {
            int mid = start + (end- start)/2;
            if(nums[mid] >= target) {
                end = mid-1;
                if(nums[mid] == target)
                    firstIndex=mid;
            } else {
                start = mid+1;
            }
        }

        if(firstIndex ==-1) {
            return output;

        }
        start = firstIndex;
        end = nums.length-1;
        while(start <= end) {
            int mid = start + (end- start)/2;
            if(nums[mid] <= target) {
                start = mid+1;
                if(nums[mid] == target)
                    secondIndex = mid;
            } else {
                end = mid-1;
            }
        }
        //int[] output = new int[2];
        output[0] = firstIndex;
        output[1] = secondIndex;
        return output;
    }
}
