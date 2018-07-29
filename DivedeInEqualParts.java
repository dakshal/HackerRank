import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
class Challenge {
  public static List<Integer> splitInteger( Integer num,Integer parts ) {
    List<Integer> list = new ArrayList<>();
    int part = num/parts;
    int left = num%parts;
    for(int i=parts-1; i>=0; i--){
      if(i<left){
        list.add(part+1);
      } else {
        list.add(part);
      }
    }
    return list;
  }
}