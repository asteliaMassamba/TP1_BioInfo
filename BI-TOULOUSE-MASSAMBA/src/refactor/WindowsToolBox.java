package refactor;

import java.util.ArrayList;

public class WindowsToolBox {

	public WindowsToolBox() {
		// TODO Auto-generated constructor stub
	}
	
	public WindowedSequence generateWindows(int longueur, int shift, Sequence seq){
		ArrayList<String> listWindows= new ArrayList<>();
		WindowedSequence res = new WindowedSequence();
		res.setId(seq.getId());
		res.setLongueur(longueur);
		res.setShift(shift);
		
//		String buff=seq.getPhrase();
//		String oneWindows="";
//		while(buf.length()>longueur){			
//			oneWindows=buf.substring(0,longueur);
//			buff=buf.substring(shift);
//			listWindows.add(oneWindows);
//		}
//		listWindows.add(buf);
		
		String buff=seq.getPhrase();
		while(buff.length()>longueur){					
			listWindows.add(buff.substring(0,longueur));
			buff=buff.substring(shift);
		}
		listWindows.add(buff);
				
		res.setWindows(listWindows);
		return res;
	}
	
	public ArrayList<String> MapperWindowsKmers(int longueurWindows, int shiftWindows, int longueurKmer, double seuilKmer,Sequence genome,Sequence read ){
		KmerToolBox ktb = new KmerToolBox();
		WindowedSequence windowedGenome = generateWindows(longueurWindows, shiftWindows, genome);
		ArrayList<String> windowsGenome = windowedGenome.getWindows();
		ArrayList<String> explicitGenome = windowedGenome.explicitWindows();
		ArrayList<String> res = new ArrayList<>();
		String readPhrase = read.getPhrase();
		for (int i=0;i<explicitGenome.size();i++) {
			if(ktb.ratioCommonKmer(longueurKmer, readPhrase, windowsGenome.get(i))>=seuilKmer){
				res.add(explicitGenome.get(i));
			}
		}
		return res;
	}
}
