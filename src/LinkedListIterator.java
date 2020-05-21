
public class LinkedListIterator  {
	private Entry current;
	public LinkedListIterator(LinkedList l) {
	
	   current = l.getInitial();
	   
	}


	public boolean hasNext() {
		return (current != null);		
	}
	

	public String Next() {	//for the keySet
		 if (hasNext()==true) {
		      String key=current.getKey();
		      current=current.next;   
		      return key;
		    }
			  return null;	  }

	public Entry EntryNext() { //for the usage put and remove only
		 if (hasNext()==true) {
		      Entry result = current;
		      current=current.next;   
		      return result;
		    }
			  return null;	  }
		}

	
