public class Q9{
    public static void main(String[] args){
      System.out.println(isRotation("waterbottle", "erbottlewat"));
    }

    public static boolean isRotation(String s1, String s2){
      int len = s1.length();
      if(len == s2.length() && len > 0){
        String s1s1 = s1+s1;
        return isSubString(s1s1,s2);
      }
      return false;
    }

    private static boolean isSubString(String big, String small) {
		if (big.toLowerCase().indexOf(small.toLowerCase()) >= 0) { 
			/* We can use big.contains(small) as well here */
			return true;
		}
		return false;
	}
}
