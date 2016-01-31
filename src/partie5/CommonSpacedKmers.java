
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class CommonSpacedKmers {
	
	public static void main(String[] args) {
		
		int longueur= args[0].length();
		File file = new File(args[1]);	
		File file2 = new File(args[2]);
		FileReader fr;
		String phrase = "";
		ArrayList<String> arr = new ArrayList<String>();
		
		try {
			
			fr = new FileReader(file);
		
			BufferedReader br = new BufferedReader(fr);
			String tmp = new String();
		
			while((tmp = br.readLine())!=null){
			
				if (tmp.length()>0){

					if (tmp.charAt(0)=='>') {					
						phrase="";
					}
					else {
						phrase=phrase.concat(tmp);					
					}
				}
			}	
			arr=listkmer(phrase, longueur);
			phrase="";
			fr = new FileReader(file2);
		
			br = new BufferedReader(fr);
			tmp = new String();
		
			while((tmp = br.readLine())!=null){
			
				if (tmp.length()>0){

					if (tmp.charAt(0)=='>') {	
						phrase="";
					}
					else {
						phrase=phrase.concat(tmp);					
					}
				}
			}		
			compareKmer(arr,affichekmer(phrase, longueur, args[0]));	
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	private static void compareKmer(ArrayList<String> arr, ArrayList<String> listkmer) {
			for (String kmer : arr) {
				if(listkmer.contains(kmer)){
					System.out.println(kmer);
					System.out.println("compare kmers");
				}
			}
	}

	
	private static ArrayList<String> listkmer(String phrase,int longueur) {
		ArrayList<String> kmer= new ArrayList<>();
		
		for(int i =0;i<=(phrase.length()-longueur);i++){
			String tmp = phrase.substring(i, i+longueur);
			if(!kmer.contains(tmp))
				kmer.add(tmp);
		}
		
		
		return kmer;
		
	}
	
	
	private static ArrayList<String> affichekmer(String phrase,int longueur, String graine) {
		ArrayList<String> kmer= new ArrayList<>();
		
		for(int i =0;i<=(phrase.length()-longueur);i++){
			String tmp = phrase.substring(i, i+longueur);
			String trans = interpret(graine, tmp);
			if(!kmer.contains(trans)) {
				kmer.add(trans);
			}
		}
		
		
		return kmer;
		
	}
	
	
	private static String interpret(String graine, String kmer) {
		char[] inter = graine.toCharArray();
		char[] tmp = kmer.toCharArray();
		
		for (int i=0; i<graine.length()-1; i++) {
			switch (inter[i]) {
				case '#' : break;
				case '-' : tmp[i] = ' ';
			}
		}
		
		String tmp2 = "";
		for (int i=0; i<tmp.length; i++) {
			if (tmp[i]!=' ')
				tmp2 = tmp2.concat(String.valueOf(tmp[i]));
		}
		
		return tmp2;
	}
	
}
