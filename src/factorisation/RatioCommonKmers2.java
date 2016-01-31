
import java.util.ArrayList;

public class RatioCommonKmers2 {

	public static void main(String[] args) {
		
		int longueur= Integer.parseInt(args[0]);
		LectureFichier text1 = new LectureFichier(args[1]);	
		LectureFichier text2 = new LectureFichier(args[2]);
		String phrase = "";
		String tmp = new String();
		ArrayList<String> arr = new ArrayList<String>();
		
		try {
		
			while((tmp = text1.lireText())!=null){
			
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
			tmp = new String();
		
			while((tmp = text2.lireText())!=null){
			
				if (tmp.length()>0){

					if (tmp.charAt(0)=='>') {	
						phrase="";
					}
					else {
						phrase=phrase.concat(tmp);					
					}
				}
			}		
			System.out.println(ratioCompareKmer(arr,listkmer(phrase, longueur)));	
			
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	
	
	private static double ratioCompareKmer(ArrayList<String> arr, ArrayList<String> listkmer) {
			double nbCommon=0;
			for (String kmer : arr) {
				if(listkmer.contains(kmer)){
					nbCommon++;
				}
			}
			return nbCommon/arr.size();
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
