package refactor;

import java.util.Random;

public class Mutation {

	public Sequence mutationSequence (int nb, Sequence s){
		
		Random rand = new Random();
		char arr[] = s.getPhrase().toCharArray();
		
		for(int i = 0 ; i < nb ; i++){
			int pos = rand.nextInt(arr.length-1);
			arr[pos] = mutationNucl(arr[pos]);
		}
		s.setPhrase(new String(arr));
		return s;
	}

	private char mutationNucl(char c) {
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
