class Challenge {
  public static String mergeStrings( String a,String b ) {
    int max = Math.max(a.length(), b.length());
    StringBuilder sb = new StringBuilder();
    char[] word1 = a.toCharArray();
    char[] word2 = b.toCharArray();
    
    for(int i=0; i<max; i++){
      if(i<word1.length){
        sb.append(word1[i]);
      }
      if(i<word2.length) {
        sb.append(word2[i]);
      }
    }
    return sb.toString();
  }
}