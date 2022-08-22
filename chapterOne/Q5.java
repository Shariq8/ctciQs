public class Q5{
    public static void main(String[] args){
        System.out.println(oneAway("pale", "aple"));
        System.out.println(oneEditAway("apple", "aple"));
    }

    public static boolean oneAway(String a, String b){
        //Iterates through both strings, provided that the only difference between them is one character
        //Therefore it is arguably O(N) run time.
        if(Math.abs(b.length() - a.length()) > 1) return false;
        int edits = 0, aI = 0, bI = 0, length = a.length() > b.length() ? a.length() : b.length();
        while(aI < a.length() && bI < b.length()){
            if(a.charAt(aI) == b.charAt(bI)){ //Move to next point
                aI++;
                bI++;
            }
            else{
                if(aI == a.length()-1 || bI == b.length()-1){ //Reached the limit of one of the strings
                    edits++;
                    break;
                } 
                if(a.charAt(aI) == b.charAt(bI+1) && a.charAt(aI+1) != b.charAt(bI+1)){ //Means string b is missing a character
                    edits++;
                    bI++;
                }else if(a.charAt(aI+1) == b.charAt(bI) && a.charAt(aI+1) != b.charAt(bI+1)){ //Means string a is missing a character
                    edits++;
                    aI++;
                }else if(a.charAt(aI) != b.charAt(bI)){ //Means the characters are not the same
                    edits++;
                    aI++;
                    bI++;
                }
            }
        }
        if(edits > 1) return false;
        return true;
    }

    //Book solution - also O(N)
    public static boolean oneEditAway(String first, String second){
        if(first.length() == second.length()){
            return oneEditReplace(first,second);
        }else if(first.length()+1 == second.length()){
            return oneEditInsert(first,second);
        }else if(first.length()-1 == second.length()){
            return oneEditInsert(second,first);
        }
        return false;
    }

    public static boolean oneEditReplace(String s1, String s2){
        boolean foundDifference = false;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                if(foundDifference) return false;
            }
            foundDifference = true;
        }
        return true;
    }

    public static boolean oneEditInsert(String s1, String s2){
        int index1 = 0;
        int index2 = 0;
        while(index2 < s2.length() && index1 < s1.length()){
            if(s1.charAt(index1) != s2.charAt(index2)){
                if(index1 != index2){
                    return false;
                }
                index2++;
            }else{
                index1++;
                index2++;
            }
        }
        return true;
    }
}