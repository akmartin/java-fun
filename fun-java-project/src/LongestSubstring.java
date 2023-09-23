import java.time.Duration;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    
    public static void main(String[] args) {
        LocalTime starTime = LocalTime.now();
        System.out.println("WITH LOOPS +++++ " + lengthOfLongestSubstringWithLoops("abcdabcab"));
        LocalTime endTime = LocalTime.now();
        Duration duration = Duration.between(starTime, endTime);

        System.out.println("Total Time: " + duration.toMillis() + "\n");

        starTime = LocalTime.now();
        System.out.println("WITH MAP +++++ " + lengthOfLongestSubstringWithMap("abcdabcab"));       
        endTime = LocalTime.now();
        duration = Duration.between(starTime, endTime);

        System.out.println("Total Time: " + duration.toMillis() + "\n");

        starTime = LocalTime.now();
        System.out.println("WITH INDEX +++++ " + lengthOfLongestSubstring("abcdabcab"));
        endTime = LocalTime.now();
        duration = Duration.between(starTime, endTime);

        System.out.println("Total Time: " + duration.toMillis() + "\n");
    }

    public static int lengthOfLongestSubstringWithLoops(String s) {

        int maxLength = 0;
        
        for (int i = 0; i < s.length(); i++) {
            StringBuilder currentSubString = new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                if(currentSubString.indexOf(String.valueOf(s.charAt(j))) != -1) {
                    break;
                }
                currentSubString.append(s.charAt(j));
                maxLength = Math.max(maxLength, currentSubString.length());
            }
        }
        return maxLength;
    }

    public static int lengthOfLongestSubstringWithMap(String s) {

        int maxLength = 0;

        Map<Character, Integer> existingCharacters = new HashMap<Character, Integer>();
        
        for (int rightPointer = 0, leftPointer = 0; rightPointer < s.length(); rightPointer++) {
            char currentCharacter = s.charAt(rightPointer);
            if(existingCharacters.containsKey(currentCharacter) && 
            existingCharacters.get(currentCharacter) >= leftPointer) {
                leftPointer = existingCharacters.get(currentCharacter) +1;
            }


            maxLength = Math.max(maxLength, rightPointer - leftPointer +1);
            existingCharacters.put(currentCharacter, rightPointer);
        }
        return maxLength;
    }

    public static int lengthOfLongestSubstring(String s) {

        int maxLength = 0;

        for (int rightPointer = 0, leftPointer = 0; rightPointer < s.length(); rightPointer++) {
            int indexOfFirstInstanceInSubString = s.indexOf(s.charAt(rightPointer), leftPointer);
            if(indexOfFirstInstanceInSubString != rightPointer) {
                leftPointer = indexOfFirstInstanceInSubString + 1;
            }

            maxLength = Math.max(maxLength, rightPointer - leftPointer +1);
        }
        return maxLength;
    }
}
