import java.util.*;
class SortingDriver{
 public static void main(String args[]){
  int[] data = {1,3,5,8,2,4,6};
  Sorting sr = new Sorting(data);

  System.out.println("Before Sort:: \n" + Arrays.toString(data));
  sr.merge_sort(0,data.length-1);
  System.out.println("After Sort:: \n" + Arrays.toString(data));
  System.out.println("Inversion count:: " + sr.get_inv_count());
   
  System.out.println("-----------------------------------------");
  System.out.println("-----------------------------------------");
  System.out.println("-----------------------------------------");

  String file_path = "IntegerArray.txt";
  FileReader fr = new FileReader(file_path);
  fr.readStore();
  Vector<Integer> v_data = fr.get_data();
 
  int[] c_data = new int[v_data.size()];
 
  for(int i = 0;i < c_data.length;i++){
    c_data[i] = v_data.get(i); 
  }

  Sorting course_era = new Sorting(c_data);
  course_era.merge_sort(0,c_data.length-1);
  System.out.println("Inversion count:: " + course_era.get_inv_count());
  
 /* 
  for(int i=0;i<c_data.length;i++){
   System.out.println(c_data[i]);
  } 
  */
 }
}
