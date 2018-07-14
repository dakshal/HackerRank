class Solution {
    public String nextClosestTime(String time) {
        int highest[] = new int[]{23, 59};
        Set<Integer> digits = new HashSet<>();
        digits.add(Integer.parseInt(time.substring(0, 1)));
        digits.add(Integer.parseInt(time.substring(1, 2)));
        digits.add(Integer.parseInt(time.substring(3, 4)));
        digits.add(Integer.parseInt(time.substring(4, 5)));
        
        if(digits.size() == 1){
            return time;
        }
        int hour = Integer.parseInt(time.substring(0, 2));
        int minute = Integer.parseInt(time.substring(3, 5));
        
        Object sortedTime[] = digits.toArray();
        
        Arrays.sort(sortedTime);
        boolean carry = true;
        String nextTime = "";
        int j=0;

        if(carry){
            for(j=0; j<sortedTime.length; j++){
                int digit = (int) sortedTime[j];
                if(Integer.parseInt(time.substring(4, 5)) < digit){
                    carry = false;
                    nextTime = digit + nextTime;
                    break;
                }
            }
            if(carry){
                nextTime = sortedTime[0] + nextTime;
            } else {
                return time.substring(0, 4) + nextTime;
            }
        }
        if(carry){
            for(j=0; j<sortedTime.length; j++){
                int digit = (int) sortedTime[j];
                if(Integer.parseInt(time.substring(3, 4)) < digit && digit <= 5){
                    carry = false;
                    nextTime = digit + nextTime;
                    break;
                }
            }
            if(carry){
                nextTime = sortedTime[0] + nextTime;
            }else {
                return time.substring(0, 3) + nextTime;
            }
        } 
        
        // int lowest = Integer.parseInt(sortedTime[0] + "" + sortedTime[0]);
        if(carry){
            for(int i=0; i<sortedTime.length; i++){
                for(j=0; j<sortedTime.length; j++) {
                    int tempHour = Integer.parseInt(sortedTime[i] + "" + sortedTime[j]);
                    if(hour < tempHour && tempHour <= 23 ){
                        carry = false;
                        nextTime = sortedTime[i] + "" + sortedTime[j] + ":"+ nextTime;
                        break;
                    } else if(tempHour > 23){
                        break;
                    }
                }
                if(!carry){
                    break;
                } else if(((int) sortedTime[i]) > 2){
                    break;
                }
            }
        }
        if(carry){
            nextTime = sortedTime[0] + "" + sortedTime[0] + ":" + nextTime;
        }
        return nextTime;
    }
}