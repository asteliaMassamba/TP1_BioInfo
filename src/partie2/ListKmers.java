import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ListKmers {

	public static void main(String[] args) {
		
		File file = new File(args[1]);		
		FileReader fr;
		String phrase = "";
		int longueur= Integer.parseInt(args[0]);
		try {
			
			
			
			
		fr = new FileReader(file);
		
		BufferedReader br = new BufferedReader(fr);
		String tmp = new String();
		
		while((tmp = br.readLine())!=null){
			
			if (tmp.length()>0){

				if (tmp.charAt(0)=='>') {
					affichekmer(phrase,longueur);
					phrase="";
				}
				else{
					phrase=phrase.concat(tmp);					
				}
			}
		}	
		affichekmer(phrase, longueur);
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void affichekmer(String phrase,int longueur) {
		
		for(int i =0;i<=(phrase.length()-longueur);i++){
			System.out.println(phrase.substring(i, i+longueur));
		}
		
	}

}
