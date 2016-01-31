
public class ListKmers2 {

	public static void main(String[] args) {
		
		int longueur= Integer.parseInt(args[0]);
		LectureFichier text = new LectureFichier(args[1]);		
		String phrase = "";
		String tmp = new String();
		
		try {
			
			while((tmp = text.lireText())!=null){
			
				if (tmp.length()>0){
					
					if (tmp.charAt(0)=='>') {
						affichekmer(phrase,longueur);
						phrase="";
					}
					else {
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
