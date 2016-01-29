import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class PrintFastaStats {


	public static void main(String[] args) {
		File file = new File(args[0]);		
		FileReader fr;
		String phrase = "";
		int nb = 0;
		try {
			
			
			
			
		fr = new FileReader(file);
		
		BufferedReader br = new BufferedReader(fr);
		String tmp = new String();
		
		while((tmp = br.readLine())!=null){
			
			if (tmp.length()>0){
				if (tmp.charAt(0)=='>') {
					phrase=tmp.substring(1);
					nb=0;
				}
				else{
					nb = nb+tmp.length();			
				}
			}
		}	
		System.out.println(phrase +" "+ nb);
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
