class Solution {
    public String shortestPalindrome(String s) {
        if(s.length() <=1){
            return s;
        }
        char[] word = s.toCharArray();
        int center, max = 0, n = word.length, count = 0;
        center = (n%2==0)?((int) Math.ceil(n/2)-1):((int) Math.ceil(n/2));
        StringBuilder sb = new StringBuilder();
        boolean odd, even, found = false;
        
        while(center>=0){
            count = 1;
            odd = true;
            even = true; 
            System.out.println("c:- "+center+"\tco:- "+count);
            if(center - count<0){
                count++;
            }
            while((center-count)>=0 && (center+count)<n){
                System.out.println(center+"\t"+count+"\t"+word[center-count]+"\t"+word[center+count]+"\t"+word[center-count+1]+"\t"+odd+"\t"+even);
                if(word[center-count] == word[center+count] && odd){
                    
                    
                } else {
                    odd = false;
                }
                if(word[center-count+1] == word[center+count] && even){
                    
                } else {
                    even = false;
                }
                count++;
                if(!odd && !even){
                    System.out.println("breaking loop!!!");
                    break;
                }
            }
            if((center-count)<=0 && (odd || even)) {
                count--;
                count = (count<=0)?(1):count;
                System.out.println(center+"\t"+count+"\t"+(center-count)+"\t"+odd+"\t"+even);
                if((center-count)>=0 && center+count<n && odd) {
                    if(word[center-count] == word[center+count]) {
                        center = center+count;
                        break;
                    }
                }
                if((center-count+1)>=0 && center+count<n && even){
                    if(word[center-count+1] == word[center+count]) {
                        center = center+count;
                        break;
                    }
                }
                if(center+count<n){
                    center = center+count-1;
                    System.out.println("breaking\t"+count+"\t\t"+center);
                    break;
                }
            }
            center--;
        }
        int j = n-1;
        System.out.println(j+"\t"+center+"\t");
        while(j>center){
            sb.append(word[j]);
            j--;
        }
        for(int i=0; i<n; i++) {
            sb.append(word[i]);
        }
        return sb.toString();
    }
}