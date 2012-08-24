import java.util.*;

class QuickSortDriver{
 public static void main(String[] args){
  int[] data = {1,3,5,8,2,4,6}; 

  PivotStrategy pivotStrategy = new LastPivot();
  Sorting sorting = new Sorting(data);
  sorting.setPivotStrategy(pivotStrategy);
 
  System.out.println(Arrays.toString(data));
   
  sorting.quick_sort(0,data.length-1);
 
  System.out.println(Arrays.toString(data)); 

  
  System.out.println("::::COURSE-ERA::::");
  
  String file_path = "QuickSort.txt";
  FileReader fr = new FileReader(file_path); 
  fr.readStore();

  Vector<Integer> v_data = fr.get_data();
  int[] c_data = new int[v_data.size()];

  for(int i = 0;i < c_data.length;i++){
    c_data[i] = v_data.get(i);
  }
  
  //int[] d_data = {1,11,5,15,2,12,9,99,77,0};
  //c_data = d_data;

  int[] rev_data = c_data.clone();
  int[] med_data = c_data.clone();
  


  Sorting course_era1 = new Sorting(c_data);
  course_era1.setPivotStrategy(new FirstPivot());  

  
  Sorting course_era2 = new Sorting(rev_data);
  course_era2.setPivotStrategy(new LastPivot()); 
 
  Sorting course_era3 = new Sorting(med_data);
  course_era3.setPivotStrategy(new MedianPivot()); 

  
  course_era1.quick_sort(0,c_data.length-1); 
  course_era2.quick_sort(0,rev_data.length-1); 
  course_era3.quick_sort(0,med_data.length-1); 
  
 
  System.out.println("COMPARSIONS FIRST CASE::" + course_era1.getQuicksortComparison());
  System.out.println("COMPARSIONS LAST CASE::" + course_era2.getQuicksortComparison());
  System.out.println("COMPARSIONS MEDIAN CASE::" + course_era3.getQuicksortComparison());

 }
}
