package final_contest;

import java.util.ArrayList;
import java.util.List;

// Given a sentence represented as an Array A of String that contains all lower case alphabets.
// Check if it panagram or not.
// A Panagram is a uique sentence in which every letter of lower case alphabet is used at least once.
public class PanagramCheck {
    public static void main(String[] args) {
        ArrayList<String> A  = new ArrayList<>(List.of("abcdfghijklmnopqrst","uvwxyz"));
        System.out.println(solve(A));
    }
    public static int solve(ArrayList<String> A) {
        int[] freq = new int[26];
        for (String word : A) {
            for(char ch : word.toCharArray()) {
                int ind = ch -'a';
                freq[ind]++;
            }
        }
        for(int i = 0;i<26;i++) {
            if(freq[i] < 1) return 0;
        }
        return 1;
    }
}
