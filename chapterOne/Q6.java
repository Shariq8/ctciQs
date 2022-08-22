public class Q6{
    public static void main(String[] args){
        System.out.println(compress("aabcccccaaa"));
    }

    public static String compress(String str){
        //This would be run time O(p + k^2) where p is the original length of string and k is the number of character sequences
        //With string builder is potentially reduces to just O(p)
        if(str.length() < 2) return str; //No point as string is only 1 or 0 characters long
        char v = str.charAt(0); //Take the inital character
        // String result = "";
        StringBuilder result = new StringBuilder();
        result.setLength(countCompression(str));
        int count = 1; //The count of the character
        for(int i = 1; i < str.length(); i++){
            if(str.charAt(i) == v) count++; //Same character so implement count
            else{ //Different character
                result.append(v);
                result.append(count);
                v = str.charAt(i);
                count = 1;
            }
        }
        result.append(v);
        result.append(count);
        return result.toString();
    }


    //Helps string builder as it does not need to double its length for each capacity limit exceeded
    static int countCompression(String str){
        int compressedLength = 0;
        int countConsecutive = 0;
        for(int i = 0; i < str.length(); i++){
            countConsecutive++;
            if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)){
                compressedLength += 1 + String.valueOf(countConsecutive).length();
                countConsecutive = 0;
            }
        }
        return compressedLength;
    }
}