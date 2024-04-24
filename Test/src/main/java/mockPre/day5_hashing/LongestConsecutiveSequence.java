package mockPre.day5_hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.StreamSupport;

/*Problem Description
        Determine the "GOOD"ness of a given string A, where the "GOOD"ness is defined by the length of the longest substring that contains no repeating characters. The greater the length of this unique-character substring, the higher the "GOOD"ness of the string.

        Your task is to return an integer representing the "GOOD"ness of string A.

        Note: The solution should be achieved in O(N) time complexity, where N is the length of the string.



        Problem Constraints
        1 <= size(A) <= 10^6

        String consists of lowerCase,upperCase characters and digits are also present in the string A.



        Input Format
        Single Argument representing string A.



        Output Format
        Return an integer denoting the maximum possible length of substring without repeating characters.



        Example Input
        Input 1:

        A = "abcabcbb"
        Input 2:

        A = "AaaA"


        Example Output
        Output 1:

        3
        Output 2:

        2


        Example Explanation
        Explanation 1:

        Substring "abc" is the longest substring without repeating characters in string A.
        Explanation 2:

        Substring "Aa" or "aA" is the longest substring without repeating characters in string A.*/
//https://www.scaler.com/academy/mentee-dashboard/class/155293/homework/problems/161
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        String A = "abcabcbb";
        System.out.println(lengthOfLongestSubstring1(A));

    }

    public static int lengthOfLongestSubstring(String A) {
        HashSet<Character> set = new HashSet<>();
        int cnt = 0;
        int prev = -1;
        for (int i = 0; i < A.length(); i++) {
            if (!set.contains(A.charAt(i))) {
                set.add(A.charAt(i));
                if ((prev + 1) == i) {
                    cnt++;
                    prev = i;
                } else {
                    cnt = 0;
                }
            }

        }
        return cnt;
    }

    public static int lengthOfLongestSubstring1(String A) {
        int cnt=0;
        HashMap<Character,Integer> map = new HashMap<>();
        int maxLen =0;
        for (int i=0;i<A.length();i++) {
            if(map.containsKey(A.charAt(i))) {
                int val = map.get(A.charAt(i));
                maxLen = cnt;
                cnt = i-val +1;

            } else {
                map.put(A.charAt(i),i+1);
                cnt++;

            }
        }
        return maxLen;
    }
}
