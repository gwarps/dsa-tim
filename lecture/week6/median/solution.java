import java.util.*;

class MedDriver{
 public static void main(String args[]){
   FileReader fr = new FileReader("Median.txt");
   //FileReader fr = new FileReader("Week6/med3.txt");
   fr.readStore();

   Vector<Integer> v_data = fr.get_data();
 
   int[] c_data = new int[v_data.size()];
 
   for(int i = 0;i < c_data.length;i++){
    c_data[i] = v_data.get(i); 
   }
   MaxPQ<Integer> first = new MaxPQ<Integer>(5000);
   MinPQ<Integer> second = new MinPQ<Integer>(5000);

   //int[] temp = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
   //c_data = temp;   

   int sum  = 0;
   for(int i=0;i<c_data.length;i++){
    if(first.size()==0){
     first.insert(c_data[i]);
    }else{
     //System.out.println("REST");
     //System.out.println(c_data[i] > second.min());
     if(c_data[i] <= first.max()){
       first.insert(c_data[i]);
     }else{
       second.insert(c_data[i]);
       //System.out.println(first.size());
     }
    }
    MedDriver.balance(first,second,i+1);
    //System.out.println(first.max());
    sum+= first.max();
   }

   System.out.println(sum%10000);
 }

 public static void balance(MaxPQ<Integer> first,MinPQ<Integer> second,int i){
  int size_max = first.size();
  int def_size=0;

  if(i%2==0){
   def_size=i/2;
  }else{
   def_size = i/2+1;
  }
 
  if(size_max > def_size){
   while((first.size()-second.size())>1){
    second.insert(first.delMax());
   }
  }else if(size_max < def_size){
   while((first.size()-second.size())<0){
    first.insert(second.delMin());
   }
  }  
 
 }  
}
