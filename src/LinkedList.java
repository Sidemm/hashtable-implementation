
public class LinkedList {

	private Entry initial;
	
	public LinkedList() {
		this.initial = null;
	}
	

	public Entry getInitial() {
		return initial;
	}


	public void setInitial(Entry initial) {
		this.initial = initial;
	}


	public LinkedListIterator iterator(){
		
		return new LinkedListIterator(this);
	}

	public void putList(String entrykey, String entryvalue){
		LinkedListIterator it= this.iterator();
		Entry entry=new Entry(entrykey,entryvalue);
		Entry last=null;
		if(initial==null){
			initial=entry;
		}
		else {
				while(it.hasNext()){
					last=it.EntryNext();
					String key=last.getKey();
					if(entrykey==key){
						last.setValue(entryvalue);
					return;
					}
				}		
				last.setNext(entry);	
		}
	}
	
	public boolean removeList(String key) {
		LinkedListIterator it= this.iterator();
		Entry previous=this.initial;
		Entry current=null;
		boolean info=false;
		if(previous.getKey()==key){
			current=previous.next;
			current=this.initial;
			previous=null;
			info= true;
		}
		else{	
			current=it.EntryNext();
		while(it.hasNext()&&info!=true){
			current=it.EntryNext();
			if(current.getKey()==key){
				previous.next=current.next;
				current=null;
				info= true;
			}
			previous=previous.next;

		}
		
	}
		return info;
	}
}



	



	
	



	

