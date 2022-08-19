import java.util.Arrays;

public class Q2 {
    public static void main(String args[]){
        System.out.println(checkPermuation("hello", "ol2leh"));
    }

    //O(N) run time (s1.length() + s2.length()) -> As they are the same size -> O(2N) -> O(N)
    public static boolean checkPermuation(String s1, String s2){
        if(s1.length() > 128 || s2.length() > 128) return false;
        return Arrays.equals(arrayMap(s1), arrayMap(s2));
    // Could reduce the space complexity by decrementing every output for the second set
    // Then checking they are all 0s
    }

    public static int[] arrayMap(String s){
        int[] set = new int[128];
        for(int i = 0; i < s.length(); i++){
            int index = s.charAt(i);
            set[index]++;
        }
        return set;
    }
    
}
