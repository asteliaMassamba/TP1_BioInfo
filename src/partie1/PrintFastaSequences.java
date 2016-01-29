import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PrintFastaSequences {
	
	public static void main(String[] args) {
		File file = new File(args[0]);		
		FileReader fr;
		String phrase = "";
		try {
			
			
			
			
		fr = new FileReader(file);
		
		BufferedReader br = new BufferedReader(fr);
		String tmp = new String();
		
		while((tmp = br.readLine())!=null){
			
			if (tmp.length()>0){

				if (tmp.charAt(0)=='>') {
					System.out.println(phrase);
					phrase="";
				}
				else{
					phrase=phrase.concat(tmp);					
				}
			}
		}	
		System.out.println(phrase);
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
