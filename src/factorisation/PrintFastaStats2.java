
public class PrintFastaStats2 {

	public static void main(String[] args) {
		LectureFichier text = new LectureFichier(args[0]);
		String phrase = "";
		String tmp = new String();
		int nb = 0;
		
		try {
		
			while((tmp = text.lireText())!=null)	{
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
