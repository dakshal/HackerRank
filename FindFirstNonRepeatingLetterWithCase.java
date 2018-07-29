class Challenge {
  public static String firstNonRepeatingLetter( String str ) {
    char[] word = str.toCharArray();
    int[] count = new int[128];
    int n = word.length;
    
    for(int i=0; i<n; i++){
      count[word[i]]+=(n+i);
    }
    int min = 2*n;
    for(int i=0; i<128; i++){
      if(min>count[i] && count[i]>0){
        if(i>=65 && i<=90){
          int temp = Math.max(count[i+32], count[i]);
          if(temp < min){
            min = temp;
          }
        } else if(i>=97 && i<=122){
          int temp = Math.max(count[i-32], count[i]);
          if(temp < min){
            min = temp;
          }
        } else {
          min = count[i];
        }
      }
    }
    if(min<2*n){
      min = min - n;
      return ""+word[min];
    } else {
      return "";
    }
    
  }
}