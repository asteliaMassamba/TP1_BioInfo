package refactor;

import java.util.ArrayList;

public class MainClass {

	public static void main(String[] args) {
		ReadFile rf = new ReadFile("/Users/damien-lenovo/workspace/Refactor/data/TRGV.fasta");
		ArrayList<Sequence> l = rf.getTab();
		PrintFasta pf = new PrintFasta();
		KmerToolBox tb = new KmerToolBox();
		
		pf.affichePhrase(l);
		pf.afficheStats(l);
		
		for (Sequence sequence : l) {
			System.out.println(tb.listKmer(4, sequence));
		}
		
		
	}
	
}
