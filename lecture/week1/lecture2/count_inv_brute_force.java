class InversionBrute{
 public static void main(String args[]){
  int data[] = {1,3,5,2,4,6};
  int count = 0;
  System.out.println("Inversion using brute force");
 
  for(int i=0;i<data.length-1;i++){
   for(int j=i+1;j<data.length;j++){
    if(data[i] > data[j]){
     count++;
    }
   }
  }
   
  System.out.println("Total Inversions::" + count);
 }
}
