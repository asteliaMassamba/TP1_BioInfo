
public class PrintFastaSequences2 {

	public static void main(String[] args) {
		
		LectureFichier text = new LectureFichier(args[0]);
		String phrase = "";
		String tmp = new String();
		
		try {
			
			while((tmp = text.lireText())!=null){
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
