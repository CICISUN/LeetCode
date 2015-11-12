package Interview;

public class MyHashMap<K,V>{
	
	private K key;
	private V value;

	class Entry<K,V>{
		K key;
		V value;
		Entry<K,V> next;
		public Entry(K key, V value, Entry<K,V> next){
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
	//private members
	private static final int SIZE = 16;
	private Entry<K,V>[] table ;
	//constructor 
	public MyHashMap(){
		table = new Entry[SIZE];
	}
	//set
	public boolean put(K key, V value){
		if(key==null) return false;//don't allow null keys
		int hash=getHash(key);
		Entry<K,V> newEntry = new Entry(key, value, null);
		if(table[hash] == null){
			table[hash]= newEntry;
			return true;
		}
		else{
			Entry<K,V> current = table[hash];
			while(current.next !=null){//not the end of chain
				if(current.key.equals(key)){
					current.value = value;//update value only
					return true;
				}
				current = current.next;
			}
			if(current.key.equals(key)){
				current.value = value;//update value only
				return true;
			}
			else{
				current.next = newEntry;
				return true;//append to end
			}
		}		
	}

	//get
	public Entry<K,V> get(K key){
		int hash = getHash(key);
		if(table[hash] == null) return null;
		else{
			Entry<K,V> tmp = table[hash];
			while(tmp!=null){
				if(tmp.key.equals(key)) return tmp;
				tmp = tmp.next;
			}
		}
		return null;
	}

	//delete
	public boolean remove(K key){
		int hash= getHash(key);
		if(table[hash] == null) return false;
		else{
			Entry<K,V> previous = null;
			Entry<K,V> current = table[hash];
			while(current !=null){//not the end of chain
				if(current.key.equals(key)){
					if(previous==null){//delete head
						table[hash] = current.next;
						return true;
					}
					previous.next = current.next;
					return true;
				}
				previous = current;
				current = current.next;
			}
			return false;//not found
		}
	}

	//load
	public float load(){
		float res;
		int count = 0;
		for(Entry<K,V> item:table){
			if(item!=null) count++;
		}
		res=(float) (count * 1.0 /SIZE);
		return res;
	}
	//get hash
	private int getHash(K key){
		return Math.abs(key.hashCode()) % SIZE;
	}


	@Override
	public int hashCode() {
		return getHash(key);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Entry))
			return false;
		if (obj == this)
			return true;

		Entry rhs = (Entry) obj;
		return rhs.value == rhs.value;
	}

	public static void main(String[] args) {
		MyHashMap map = new MyHashMap();
		map.put("werw", 1);
		map.put("asdf", 1);
		map.put("asdf", 2);
		map.remove("asdf");
		System.out.println(map.get("werw").value);
		System.out.println(map.load());
	}

}
