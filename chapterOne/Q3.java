public class Q3 {
    public static void main(String args[]){
        System.out.println(URLify("Mr John Smith    ", 13));
    }

    public static String URLify(String s, int length){
        //Run time: O(N)
        char[] chars = s.toCharArray();
        String result = "";
        for(int i = 0; i < length; i++ ){
            if(chars[i] == ' '){
                result+="%20";
            }else{
                result+=chars[i];
            }
        }
        return result;
    }
}
