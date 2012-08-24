import java.util.*;

class DataStore{
	private boolean inc;
	private int count;

	public DataStore(){
		inc = false;
		count=1;
	}

	public void increment_count(){
		count = count + 1;
	}

	public int getCount(){
		return count;
	}

	public void markInc(){
		inc = true;
	}

	public boolean getInc(){
		return inc;
	}
}

class TableStore{
	private Hashtable<Integer,DataStore> data;

	public TableStore(){
		this.data = new Hashtable<Integer,DataStore>();
	}

	public void add(Integer key){
		if(data.containsKey(key)){
			DataStore ds = data.get(key);
			ds.increment_count();
		}else{
			DataStore ds = new DataStore();
			data.put(key,ds);
		}
	}

	public boolean containsKey(int key){
		return data.containsKey(key);
	}

	public void markInc(int key){
		data.get(key).markInc();
	}

	public boolean isMarked(int key){
		return data.get(key).getInc();
	}

	public DataStore getStore(int key){
		return data.get(key);
	}
}