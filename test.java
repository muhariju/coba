import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShortestSubstring {

    public static int findShortestSubstring(String s) {
        int n = s.length();
        Map<Character, Integer> charCount = new HashMap<>();
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        
        for (int right = 0; right < n; right++) {
            char rightChar = s.charAt(right);
            charCount.put(rightChar, charCount.getOrDefault(rightChar, 0) + 1);
            
            while (hasDuplicate(charCount)) {
                minLength = Math.min(minLength, right - left + 1);
                char leftChar = s.charAt(left);
                charCount.put(leftChar, charCount.get(leftChar) - 1);
                if (charCount.get(leftChar) == 0) {
                    charCount.remove(leftChar);
                }
                left++;
            }
        }
        
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
    
    private static boolean hasDuplicate(Map<Character, Integer> charCount) {
        for (int count : charCount.values()) {
            if (count > 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(findShortestSubstring(s));
    }
}
