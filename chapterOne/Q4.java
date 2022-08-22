import java.util.HashMap;
import java.util.Map;

public class Q4{
    public static void main(String[] args){
        System.out.println(palindromePermutation("tactc oapapa"));
    }

    public static boolean palindromePermutation(String str){
        str = str.replaceAll("\\s","");
        str = str.toLowerCase();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            if(map.containsKey(str.charAt(i))){
                int v = map.get(str.charAt(i));
                map.replace(str.charAt(i), v+=1);
            }else{
                map.put(str.charAt(i), 1);
            }
        }

        //If the length is even, iterate to see if any of them are odd
        if(str.length() % 2 == 0){
            for(Map.Entry<Character, Integer> entry: map.entrySet()){
                if(entry.getValue() % 2 == 1) return false; //If odd number of letters but even length, cannot be a permutation
            } 
            return true;
        }else{ //For odd lengths
            char s = '\0';
            for(Map.Entry<Character, Integer> entry: map.entrySet()){
                if(s == '\0' && entry.getValue() % 2 == 1) s = entry.getKey(); //If there's an odd value and it hasn't been filled yet
                else if(s != '\0' && entry.getValue() % 2 == 1) return false;
            } 
        }
        return true;
    }
}