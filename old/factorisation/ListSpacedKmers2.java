
public class ListSpacedKmers2 {

	public static void main(String[] args) {
		int longueur= args[0].length();
		LectureFichier text = new LectureFichier(args[1]);
		String phrase = "";
		String tmp = new String();
		
		try {
		
			while((tmp = text.lireText())!=null){
			
				if (tmp.length()>0){

					if (tmp.charAt(0)=='>') {
						affichekmer(phrase,longueur,args[0]);
						phrase="";
					}
					else {
						phrase=phrase.concat(tmp);					
					}
				}
			}	
			affichekmer(phrase, longueur, args[0]);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

	private static void affichekmer(String phrase,int longueur, String graine) {
		
		for(int i =0;i<=(phrase.length()-longueur);i++) {
			String kmer = phrase.substring(i, i+longueur);
			System.out.println(interpret(graine, kmer));
		}
		
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
