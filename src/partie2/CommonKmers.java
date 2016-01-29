import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class CommonKmers {

	public static void main(String[] args) {
		
		File file = new File(args[1]);	
		File file2 = new File(args[2]);
		FileReader fr;
		String phrase = "";
		int longueur= Integer.parseInt(args[0]);
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
				else{
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
				else{
					phrase=phrase.concat(tmp);					
				}
			}
		}		
		compareKmer(arr,listkmer(phrase, longueur));	
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private static void compareKmer(ArrayList<String> arr, ArrayList<String> listkmer) {
			for (String kmer : arr) {
				if(listkmer.contains(kmer)){
					System.out.println(kmer);
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

}
