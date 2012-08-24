import java.util.*;

class SumDriver{
 public static void main(String args[]){
  FileReader fr = new FileReader("HashInt.txt");
  //FileReader fr = new FileReader("Week6/2sum.txt");
  fr.readStore();

  Vector<Integer> v_data = fr.get_data();

  int[] c_data = new int[v_data.size()];
  ArrayList<Integer> al = new ArrayList<Integer>();
  HashSet<Integer> result = new HashSet<Integer>();
  
  TableStore ts = new TableStore();

  for(int i = 0;i < c_data.length;i++){
    c_data[i] = v_data.get(i);
    if(c_data[i] <= 4000){
    	al.add(c_data[i]);
    	ts.add(c_data[i]);
    }
  }

  int high = 4000;
  int low = 2500;

// Looping for each number
  for(int i=0;i<al.size();i++){
  	int x = al.get(i);

    int start = low - x;
    if(start <= 0){
    	start = 1;
    }

    int end = high - x;

//lookup
      for(int y=start;y<=end;y++){
      	// if same element then skip
      	if(x==y){
      		continue;
      	}

      	if(ts.containsKey(y)){
      		ts.markInc(x);
      		int val = x + y;
      		result.add(val);
      	}
      }

  }

  System.out.println(result.size());



 }
}
