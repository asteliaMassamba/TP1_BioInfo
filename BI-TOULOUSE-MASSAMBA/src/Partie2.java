import java.util.ArrayList;

public class Partie2 {

	public static void main(String[] args) {
		ListSpacedKmers ls =new ListSpacedKmers(args);
		String tmp = "";
		ArrayList<String> buff= ls.getKmer1();
		for (String string : buff) {
			tmp.concat(string);
		}
		System.out.println(args[4]);
		for (String st : mapperSpacedWindowsKmers(Integer.parseInt(args[2]), Integer.parseInt(args[3]), args[4], Double.parseDouble(args[5]), args[6], args[7])){
			System.out.println(st);
		}
		
		
	}
	
	public static ArrayList<String> windows (int longueur, int shift, String sequence) {
		ArrayList<String> mapper= new ArrayList<>();
		int nbF=1;
		String tmp=sequence;
		String buff="";
		while(tmp.length()>longueur){
			nbF++;
			buff=tmp.substring(0,longueur);
			tmp=tmp.substring(shift);
			mapper.add(buff);
		}
		mapper.add(tmp);
		
		return mapper;
	}
	
	public static ArrayList<String> mapperSpacedWindowsKmers(int lw,int sw,String args,double d,String f1,String f2){
		ReadFile rf1 = new ReadFile(f1);
		ReadFile rf2 = new ReadFile(f2);
		ArrayList<ArrayList<String>> tab2 = rf2.getTab();
		ArrayList<String> Windows = windows(lw, sw, tab2.get(1).get(0));
		ArrayList<String> WindowsCoord = afficheWindows(Windows, sw);
		ArrayList<String> res= new ArrayList<>();
		for (int i=0;i<Windows.size();i++) {			
			KmersSpacedOperation km = new KmersSpacedOperation(args,Windows.get(i),rf1);
			if (km.ratio()>=d){
				res.add(WindowsCoord.get(i));
			}
		}
		return res;
	}
	
	public static ArrayList<String> afficheWindows(ArrayList<String> windows,int shift){
		int idx = 1;
		ArrayList<String> listA=new ArrayList<>();
		for (String string : windows) {
			listA.add(idx+"\t"+string+"\t"+(idx+string.length()-1));
			idx+=shift;
			
		}
		return listA;
	}
	
}
