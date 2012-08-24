import java.util.*;
interface PivotStrategy{
 public void pivotize(int[] a,int low,int high);
}

class FirstPivot implements PivotStrategy{
 public void pivotize(int[] a,int low,int high){
  //do nothing for first element
  return;
 }
}

class LastPivot implements PivotStrategy{
 public void pivotize(int[] a,int low,int high){
  int temp = a[high];
  a[high] = a[low];
  a[low] = temp;
 }
}

class MedianPivot implements PivotStrategy{
 public void pivotize(int[] a,int low,int high){
  int middle = (high-low)/2 + low;

  if(middle!=0){
   ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(a[low]);
    list.add(a[middle]);
    list.add(a[high]);
    Collections.sort(list);
   
    int temp = list.get(1);

    if(temp!=a[low]){
     int index=low;
     if(temp==a[high]){
      index = high;
     }else{
      index = middle;
     }
     
     temp = a[index];
     a[index] = a[low];
     a[low] = temp;
    }
    
  }

 } 
}
