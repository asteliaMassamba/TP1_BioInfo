import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ListKmer {
	private ArrayList<ArrayList<String>> tab1;
	private static ArrayList<String> kmer1;
	
	public ListKmer() {
		
	}
	
	public ListKmer(String[] args){
		int longueur= Integer.parseInt(args[0]);
		ReadFile f1 = new ReadFile(args[1]);
		tab1=f1.getTab();
		kmer1=list(longueur,tab1.get(1).get(0));
	}
	
	
	public ArrayList<String> listNoDoub(int longueur,String phrase){
		
			ArrayList<String> kmer = list(longueur, phrase);
			Set<String> s = new HashSet<>();
			s.addAll(kmer);
			kmer=new ArrayList<>(s);
			return kmer;			
	}
	
	public ArrayList<String> list(int longueur,String phrase){
		
		ArrayList<String> kmer = new ArrayList<>();
		for(int i =0;i<=(phrase.length()-longueur);i++){
			String tmp = phrase.substring(i, i+longueur);
				kmer.add(tmp);
		}
		return kmer;			
}
	
	public void afficherKmer(ArrayList<String> kmer){
		for (String string : kmer) {
			System.out.println(string);
		}
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ListKmer k = new ListKmer(args);
		for (String string : kmer1) {
			System.out.println(string);
		}
	}
}

