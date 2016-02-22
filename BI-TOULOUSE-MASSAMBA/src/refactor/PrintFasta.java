package refactor;

import java.util.ArrayList;

public class PrintFasta{
	
	public PrintFasta(){		
	}
		
	public void affichePhrase(ArrayList<Sequence> tab) {
		for (Sequence seq : tab) {
			System.out.println(seq.getPhrase());
		}
	}
	
	public void afficheStats(ArrayList<Sequence> tab){
		for (Sequence seq : tab){
			System.out.println(seq.getId()+"\t"+seq.getPhrase());
		}
	}
	
	
}
