import java.util.Arrays;
public class Q1{
    public static void main(String args[]){
        System.out.println(isUnique("dog"));
        System.out.println(isUnique("rac2eAA"));
    }

    public static boolean isUnique(String str){
        //O(N^2)
        // for(int i = 0; i < str.length()-1; i++){
        //     for(int j = i+1; j < str.length(); j++){
        //         if(str.charAt(i) == str.charAt(j)) return false;
        //     }
        // }

        //O(NlogN):
        // char[] chars = str.toCharArray();
        // Arrays.sort(chars);
        // String sorted = new String(chars);
        // for(int i = 0; i < sorted.length()-1; i++){
        //     if(sorted.charAt(i) == sorted.charAt(i+1)) return false;
        // }
        // return true;

        //O(N) solution
        if(str.length() > 128) return false;
        int[] char_set = new int[128];
        for(int i = 0; i < str.length(); i++){
            int index = str.charAt(i);
            if(++char_set[index] == 2) return false;
        }
        return true;
    }
}