import java.io.*;
import java.util.*;


public class Graph implements Cloneable{
 private final int V;
 private int E;
 private Bag<Integer>[] adj;


 public Graph(int V){
  if(V<0) throw new RuntimeException("Number of vertices must be non negative");
  this.V = V;
  this.E = 0;
  adj = (Bag<Integer>[])new Bag[V];
  for(int v =0;v<V;v++){
   adj[v] = new Bag<Integer>();
  }
 }

 /**
 * Clone method
 */
 public Object clone(){
  try{
   return super.clone();
  }catch(Exception e){
   return null;
  }
 }

 /**
 * Return the number of vertices
 */
 public int V(){
  return V;
 }

 /**
 * Return the number of edges
 */ 
 public int E(){
  return E;
 }

 /**
 * Add undirected edge u-v to graph in symettric way
 */

 public void addEdge(int v,int w){
  E++;
  adj[v].add(w);
  adj[w].add(v);
 }

 /**
 * Delete undirected edge u-v from graph in symmetric way
 */
 
 public void deleteEdge(int v,int w){
  adj[v].deleteItem(w);
  adj[w].deleteItem(v);
   E--;
 }
 
 /**
 * Delete All undirected edge between two given node
 */
 public void deleteEdgeAll(int v,int w){
   Iterator itr = adj[v].iterator();
   while(itr.hasNext()){
    if(itr.next()==(Integer)w){
     deleteEdge(v,w);
    }
   }
 }

 /**
 * Delete all edges of graph making it a isolated node
 */
 public void deleteIsolate(int v){
  if(adj[v].size()==0){
   return;
  }

  Iterator<Integer> itr = adj[v].iterator();
   while(itr.hasNext()){
     int del = itr.next().intValue();
     //System.out.println("DELETE ::" + v + "-" + del);
     deleteEdge(v,del);
   }
 }

 /**
 * Copy all the edges of one node from another from v to w(assuming self loops are deleted)
 * otherwise will copy self loops also
 */
 public void copyEdge(int v,int w){
  Iterator<Integer> itr = adj[v].iterator();
  while(itr.hasNext()){
   addEdge(w,itr.next().intValue());
  } 
 }
 /**
 * Delete self loops for a node
 */
 public void deleteLoops(int v){
  Iterator<Integer> itr = adj[v].iterator();
  int count=0;
  while(itr.hasNext()){
   if(itr.next().intValue()==v){
    count++;
   }
  }
 
  for(int i=0;i<count/2;i++){
   deleteEdge(v,v);
  }

 }
 
 /**
 * Return list of neighbors of vertex v as in Iterable
 */
 public Iterable<Integer> adj(int v){
  return adj[v];
 }
 
 /**
 * Return string representation of graph
 */
 public String toString(){ 
  StringBuilder s = new StringBuilder();
  String NEWLINE = System.getProperty("line.separator");
  s.append(V + " vertices, " + E + " edges " + NEWLINE);
  for(int v=0;v<V;v++){
    s.append(v + "(" + adj[v].size() +")" +": ");
    for(int w : adj[v]){
     s.append(w + " ");
    }
    s.append(NEWLINE);
  }
  return s.toString();
 }
 /**
 * Function for returning list of non zero degree nodes
 */
 public ArrayList<Integer> degreeNode(){
  ArrayList<Integer> bnodes = new ArrayList<Integer>();
  for(int v=0;v<V;v++){
   if(adj[v].size()>0){
    bnodes.add(v);
   }
  }

  return bnodes;
 }

 /**
 * Function random return from non zero degree nodes
 */
 public int randomNode(){
  ArrayList<Integer> bnode = degreeNode();
  Random gen  = new Random();
  int i = gen.nextInt(bnode.size());

  return bnode.get(i);
 }
 /**
 * Function for returning random of adjacent of a node
 */
 public int adjNode(int v){
  Iterator<Integer> itr = adj[v].iterator();
  Random gen = new Random();
  ArrayList<Integer> anodes = new ArrayList<Integer>();
  while(itr.hasNext()){
   Integer num = itr.next();
    anodes.add(num);
  }
  int i = gen.nextInt(anodes.size());
  return anodes.get(i);
 }
 
 /**
 * Function for calculating min cut
 */
 public int kargerCut(){
  int n = degreeNode().size();
  while(n>2){
   int j = randomNode();
   int k = adjNode(j);
   
   //System.out.println("DELETE ALL BETWEEN "+ j + " and " + k);
   //deleteEdgeAll(j,k);
   //System.out.println(this);
   //System.out.println("Copy All from " + k + " to " + j);
   copyEdge(k,j);
   deleteLoops(j);
   //System.out.println(this);
   //System.out.println("Isolate Edge " + k);
   deleteIsolate(k);
   //System.out.println(this);
   n = degreeNode().size();
   //System.out.println(n);
  }

  return E; 
 }


}
