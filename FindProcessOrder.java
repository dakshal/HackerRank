import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
class Challenge {
  public static List<String> findProcesses( String start_item,String end_item,List<String> tasks ) {
    if(start_item == end_item){
      return new ArrayList<String>();
    }
    HashMap<String, String> processType = new HashMap<>();
    HashMap<String, String> processName = new HashMap<>();
    
    for(int i=0; i<tasks.size(); i++){
      String[] temp = tasks.get(i).split(":");
      if(processType.containsKey(temp[1])){
        processType.put(temp[1], temp[2]+":"+processType.get(temp[1]));
        processName.put(temp[1], temp[0]+":"+processName.get(temp[1]));
      } else {
        processType.put(temp[1], temp[2]);
        processName.put(temp[1], temp[0]);
      }
    }
    List<String> order = new ArrayList<>();
    boolean done = false;
    String start = start_item;
    String process = "";
    boolean status = findOrder(order, processType, processName, start, end_item, false);
    if(status)
      return order;
    else 
      return new ArrayList<String>();
  }
  public static boolean findOrder(List<String> order, HashMap<String, String> type, HashMap<String, String> name, String start, String end, boolean status) {
    String process = name.get(start);
    if(process == null){
      return false;
    }
    
    if(process.indexOf(':')<0){
      order.add(process);
//       order.add(start);
      
      if(type.containsKey(start)){
        start = type.get(start);
      } else {
        return false;
      }
      if(start.equals(end)){
        return true;
      } else {
        return findOrder(order, type, name, start, end, status);
      }
    } else {
      String[] temp = process.split(":");
      String[] startID = type.get(start).split(":");
      int size;
//       order.add(process);
//       order.add(type.get(start));
      for(int i=0; i<temp.length; i++){
        if(order.contains(temp[i])){
          return false;
        }
        order.add(temp[i]);
//         order.add(start);
        start = startID[i];
        if(start.equals(end)){
          status = true;
          return true;
        } else {
          status = findOrder(order, type, name, start, end, status);
        }
        if(!status){
          order.remove(temp[i]);
        } else {
          return status;
        }
      }
    }
    return false;
  }
}