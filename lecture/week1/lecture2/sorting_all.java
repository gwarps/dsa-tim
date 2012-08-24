import java.util.*;

/**
 * Sorting class with sorting method as member function
 * Counting Inversion also integrated with merge sort
 *
 * @author Puneet Singh
 * @version 1.0 23 June 2012
 */
class Sorting{
 
 private int data[];
 private long inv_count;
 private long quicksort_comparison;
 private PivotStrategy pivotStrategy;
 
 public Sorting(int input[]){
  this.data = input;
 }

 // Merge Sort Functions

 public long get_inv_count(){
  return this.inv_count;
 }

 public long getQuicksortComparison(){
  return this.quicksort_comparison;
 }

 public void merge_sort(int low,int high){
  if(low < high){
  
  int middle = (low+high)/2;
  
  this.merge_sort(low,middle);
  this.merge_sort(middle+1,high);
  this.merge(low,middle,high);
  }
 }

 public void merge(int low,int middle,int high){
  int[] res = new int[high-low+1];
  int i = low;
  int j = middle+1;
  int k=0;

  while(i<=middle && j <=high){
   if(this.data[i]<this.data[j]){
    res[k] = this.data[i];
    k++;
    i++;
   }else{
    res[k] = this.data[j];
    k++;
    j++;
   
    //For inversion count
    this.inv_count += middle-i+1;
    System.out.println("COUNT:" + this.inv_count); 
   }
  }
  
  if(i>middle){
   for(int l=j;l<=high;l++){
    res[k++] = data[l];
   }
  }else{
   for(int l=i;l<=middle;l++){
    res[k++] = data[l];
   }
  }
  
  for(int l=low;l<=high;l++){
   this.data[l] = res[l-low];
  }
 }

 // Quick Sort functions
 // Setting the pivot strategy for quicksort
 public void setPivotStrategy(PivotStrategy ps){
  this.pivotStrategy = ps;
 } 
 
 //QuickSort Procedure
 public void quick_sort(int low,int high){
  
  if(low < high){
   this.quicksort_comparison += high-low;
   pivotStrategy.pivotize(this.data,low,high);
   int index = quick_sort_partition(low,high);
   
   quick_sort(low,index-1);
   quick_sort(index+1,high);
    
  }
 }
 
 //QuickSort Partition
 public int quick_sort_partition(int low,int high){
  int pivot = this.data[low];
  int i = low+1;
  
  for(int j=low+1;j<=high;j++){
   if(this.data[j] < pivot){
    
    int temp = this.data[i];
    this.data[i] = this.data[j];
    this.data[j] = temp;

    i++;
   }
  }
  this.data[low] = this.data[i-1];
  this.data[i-1] = pivot;
  
  return (i-1); 
 }




}
