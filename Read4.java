/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        int count = 0, tmp = 0;
        while(count < n) {
            tmp = read4(buffer);
            for(int i = 0; i < tmp && count < n; ++i) {
                count++;
                buf[count - 1] = buffer[i]; 
            }
            if(tmp < 4) break;
            
        }
        return count;
    }
}