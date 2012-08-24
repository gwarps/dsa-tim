import java.util.*;

public class Bag<Item> implements Iterable<Item>{
 private int N;		//no. of elements in bag
 private Node first; 	//begining of bag

 //helper linked list class
 private class Node{
  private Item item;
  private Node next;
 }
 //create empty stack
 public Bag(){
   first = null;
   N = 0;
   assert check();
 }

 /**
 * Is the bag empty
 */
 public boolean isEmpty(){
  return first == null;
 }
 /**
 * Return no of items in Bag
 */
 public int size(){
  return N;
 }

 /**
 * Add item to the bag
 */

 public void add(Item item){
  Node oldfirst = first;
  first = new Node();
  first.item = item;
  first.next = oldfirst;
  N++;
  assert check(); 
 }

 /**
 * Delete Item from the bag
 */
 public void deleteItem(Item item){
   //System.out.println("first " + first.item + " Item: " + item);
   //System.out.println("EQUALITY:: " + first.item.equals(item));
   if(first.item.equals(item)){
    first = first.next;
    N--;
   }else{
    Node current = first;
    while(current.next!=null){
      if(current.next.item.equals(item)){
       current.next = current.next.next;
       N--;
       break;
      }
      current = current.next;
    } 
   }
 }
 //check internal invariants
 private boolean check(){
  if(N==0){
    if(first!=null) return false;
  }else if(N==1){
    if(first==null) return false;
    if(first.next!=null) return false;
  }else{
    if(first.next==null) return false;
  }

  //check internal consistency of instance variable N
  int numberOfNodes = 0;
  for(Node x = first;x!=null;x = x.next){
   numberOfNodes++;
  }
  
  if(numberOfNodes!=N) return false;

  return true;
 }

 public Iterator<Item> iterator(){
  return new ListIterator();
 }

 // an iterator doesn't implement remove() since it's optional
 private class ListIterator implements Iterator<Item>{
  private Node current = first;
  private Node previous = null; 
  public boolean hasNext(){
   return current != null;
  }
 
  public void remove(){
   throw new UnsupportedOperationException();
  }

  public Item next(){
   if(!hasNext()) throw new NoSuchElementException();
   //extra processing for remove   
   previous = current;  

   Item item = current.item;
   current = current.next;
   
   return item; 
  } 
 }

}
