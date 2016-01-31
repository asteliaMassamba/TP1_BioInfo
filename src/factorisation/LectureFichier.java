
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LectureFichier {

	private BufferedReader br;
	
	public LectureFichier (String text) {
		
		try {
			File file = new File(text);
			FileReader fr = new FileReader(file);
			this.br = new BufferedReader(fr);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public String lireText() throws IOException {
		return this.br.readLine();
	}
	
}
