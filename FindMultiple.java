public class Solution {

  public int solution(int number) {
    int multipleCount3 = ((number-1)/3);
    int sum3 = (multipleCount3*(3+multipleCount3*3))/2;
    int multipleCount5 = ((number-1)/5);
    int sum5 = (multipleCount5*(5+multipleCount5*5))/2;
    int multipleCount15 = ((number-1)/15);
    int sum15 = (multipleCount15*(15+multipleCount15*15))/2;
    return sum3+sum5-sum15;
  }
}