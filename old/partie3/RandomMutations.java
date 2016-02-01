import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.Random;

public class RandomMutations {

	public static void main(String[] args) {
		File file = new File(args[1]);		
		FileReader fr;
		String phrase = "";
		int nbMutations= Integer.parseInt(args[0]);
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
				else {
					phrase=phrase.concat(tmp);					
				}
			}
		}
		
		System.out.println(mutationSequence(phrase,nbMutations));
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/* Fonction transformant une sequence phrase avec le nombre de mutations nbMut demandee. */
	private static String mutationSequence(String phrase, int nbMut) {
		Random rand = new Random();
		char[] arr = phrase.toCharArray();
		
		for (int i=0; i<nbMut; i++) {
			int tmp = rand.nextInt(phrase.length()-1);
			arr[tmp] = mutationCodon(phrase.charAt(tmp));
		}
		
		return String.valueOf(arr);
	}
	
	
	/* Fonction transformant un codant en un autre. */
	private static char mutationCodon(char c) {
		Random rand = new Random();
		int tmp = rand.nextInt(2);
		char rep = ' ';
		
		switch (c) {
			case 'A' : char tab1[] = {'T','G','C'};
					   rep = tab1[tmp];
					   break;
					   
			case 'T' : char tab2[] = {'A','G','C'};
					   rep = tab2[tmp];
					   break;
			
			case 'G' : char tab3[] = {'A','T','C'};
					   rep = tab3[tmp];
					   break;
			
			case 'C' : char tab4[] = {'A','T','G'};
					   rep = tab4[tmp];
		}
		
		return rep;
	}
	
}
