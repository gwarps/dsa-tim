import java.io.*;
import java.util.*;
/**
 * Class for FileReading and storing the data in vector
 * Data Type:: Integer
 * return as array for utilization in
 * MERGE SORT and COUNTING INVERSIONS
 *
 * @author Puneet Singh
 * @version 1.0 25th June 2012
 *
 */
class FileReader{
 private String file_path;
 private Vector<Integer> file_data;

 public FileReader(String file_path){
  this.file_path = file_path;
  file_data = new Vector<Integer>();
 }

 //Reads all the data from the file 
 public void readStore(){

  try{
   FileInputStream fin = new FileInputStream(this.file_path);
   BufferedReader br = new BufferedReader(new InputStreamReader(fin));
   String l;
   while((l = br.readLine())!=null){
    file_data.add(Integer.parseInt(l)); 
   }
  }catch(Exception e){
   System.out.println("File Not Found");
   return;
  }  
 }

 //Returns Capacity of the file
 public int store_cap(){
  return this.file_data.size();
 }
 
 public Vector<Integer> get_data(){
  return this.file_data;
 }
}
