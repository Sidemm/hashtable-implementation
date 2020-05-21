
public class HashTable {
private int tableSize;
LinkedList[] entryArray=new LinkedList[53];
	
	public HashTable() {
	this.tableSize = 53;
	for(int i=0; i<53;i++){
		entryArray[i]=new LinkedList();
	}
}  
	public int hash(String key){
		int hash=0;
		int p=23;
		for(int i=0;i<key.length();i++){
			hash=(p*hash+key.charAt(i))%tableSize;
		}
		return hash;
	}
	
	public void put(String key, String value){
		int position = hash(key);
		entryArray[position].putList(key,value);		
	}
	
	public boolean remove(String key){
		int position = hash(key);
		return entryArray[position].removeList(key);
	}
	
	public LinkedListIterator keySet(){
		LinkedList result=new LinkedList();
		for(int i=0;i<this.tableSize;i++){
			LinkedList list=new LinkedList();
			list=this.entryArray[i];
			LinkedListIterator it=list.iterator();
			while(it.hasNext()){
				Entry current=it.EntryNext();
				String key=current.getKey();
				String value=current.getValue();
				result.putList(key, value);	
			}	
		}
		LinkedListIterator it=result.iterator();
		return it;
	}
	
	public int size(){
		int counter=0;
		for(int i=0;i<53;i++){
			LinkedListIterator it=entryArray[i].iterator();
			while(it.hasNext()){
				Entry current=it.EntryNext();
				counter++;
			}
		}
		return counter;
	}
	
	
	public void Empty(){
		for(int i=0;i<this.tableSize;i++)
			this.entryArray[i]=new LinkedList();
		
		
	}
}
