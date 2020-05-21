import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
public class Test {
	
	public static void main(String[] args) {
			
		try {
			BufferedReader rd = new BufferedReader(new FileReader("C:\\Users\\lenova\\Desktop\\comp202\\Project2\\input.txt"));
			HashTable temp=new HashTable();
			temp=createHashTable(rd);
			
			PrintWriter wr = new PrintWriter(new FileWriter("outputfinal.txt"));
			
			printHashTable(temp,wr);
			
		
			/*LinkedListIterator s=temp.keySet(); // keySet example
				while(s.hasNext()){
					System.out.println(s.Next());
			}
			*/
////////////////////////////////COMMAND PART////////////////////////////////////////
			int size=0;
			boolean info=false;
			while (true){
				String key="";
				String value="";
				String command="";
				String line=rd.readLine();
				if(line==null) 
					break;
				StringTokenizer st = new StringTokenizer(line);
				value=" ";
				if(st.hasMoreTokens() )
					command= st.nextToken();
				String str=command.toLowerCase();
				switch(command){
				
						case("put"):
				
					if(st.hasMoreTokens() )
						 key = st.nextToken();
				while(st.hasMoreTokens()){
				 value+=st.nextToken()+" ";		
				}
				temp.put(key, value);
						break;
						case("size"):

				 		size=temp.size();	  
						break;
						case("containskey"):
					for(int i=0;i<53;i++){
						LinkedListIterator it=temp.entryArray[i].iterator();
						if(st.hasMoreTokens() )
							 key = st.nextToken();
						System.out.println(key);
						while(it.hasNext()){
							Entry current=it.EntryNext();
							String currentkey=current.getKey();
							if(currentkey==key) 
								info=true;			 		
							}
						}	break;
						 default: break;
		}
	} 
///////////////////////////////////////////////////////////////////////////////////
			wr.println();
			printHashTable(temp,wr); 
			wr.println();
			wr.println("Size of the table is: "+size);
			wr.println();
			wr.println(info);
			rd.close();
			wr.close();
			temp.Empty();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static HashTable createHashTable(BufferedReader rd) throws IOException {
		HashTable ht=new HashTable();
		String key=" ";
		String value=" ";
		while(true){
			String line=rd.readLine();
			if(line.isEmpty()) 
				break;
			StringTokenizer st = new StringTokenizer(line);
			value=" ";
			if(st.hasMoreTokens() ){
			 key = st.nextToken();
			}
			while(st.hasMoreTokens()){
			 value+=st.nextToken()+" ";		
			}
			ht.put(key,value);
			}	
		
		return ht;
	}
	
	private static void printHashTable(HashTable ht,PrintWriter wr) throws IOException{
		LinkedList[] array=ht.entryArray;

		for(int i=0;i<53;i++){
			LinkedListIterator it=array[i].iterator();
			while(it.hasNext()){
				Entry current=it.EntryNext();
				String key=current.getKey();
				String value=current.getValue();
				int hashkey=current.getHashKey(key, 53);
			wr.println(hashkey+":"+key+" "+value);

			
		}
			
		}

	}
}
