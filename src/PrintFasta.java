
import java.io.IOException;
import java.util.ArrayList;

public class PrintFasta{
	ArrayList<ArrayList<String>> tab;
	
	public PrintFasta(String[] args) throws IOException {
		 ReadFile f = new ReadFile(args[0]);
		 tab=f.getTab();
	}
	
	public void sequence() {
		ArrayList<String> phrase =tab.get(1);
		for (String string : phrase) {
			System.out.println(string);
		}
	}
	public void stats(){
		ArrayList<String> id = tab.get(0);
		ArrayList<String> phrase =tab.get(1);
		for(int i=0;i<id.size();i++){
			System.out.println(id.get(i)+" "+phrase.get(i).length());
		}
		
	}
	
	
}
