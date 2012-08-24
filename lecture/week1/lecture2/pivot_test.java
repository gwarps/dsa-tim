import java.util.*;
class PivotTest{
 public static void main(String args[]){
  int[] data = {9,3};

  MedianPivot mp = new MedianPivot();
  System.out.println(Arrays.toString(data));
  mp.pivotize(data,0,data.length-1);
  System.out.println(Arrays.toString(data));

 }
}
