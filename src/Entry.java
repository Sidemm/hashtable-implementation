
public class Entry {
	private String key;
	private String value;
	public Entry next;
	public int hashkey;
	
	public Entry(String key, String value) {
		this.key = key;
		this.value = value;
	}


	public void setValue(String value) {
		this.value = value;
	}


	public Entry getNext() {
		return next;
	}


	public String getKey() {
		return key;
	}


	public String getValue() {
		return value;
	}
	
	
	public void setNext(Entry next) {
		this.next = next;
	}

	
	public int getHashKey(String key,int tableSize){
		int hash=0;
		int p=23;
		for(int i=0;i<key.length();i++){
			hash=(p*hash+key.charAt(i))%tableSize;
		}
		return hash;
	}
}
