import java.util.ArrayList;


public class Parti1 {

	public static void main(String[] args) {
		int l = Integer.parseInt(args[0]);
		int s = Integer.parseInt(args[1]);
		int lk = Integer.parseInt(args[2]);
		double sk = Double.parseDouble(args[3]);		
		System.out.println("mapper phage read1");
		for (String st : mapperWindowsKmers(l, s, lk, sk, args[4], args[5])){
			System.out.println(st);
		}
		System.out.println("mapper phage read2");
		for (String st : mapperWindowsKmers(l, s, lk, sk, args[4], args[6])){
			System.out.println(st);
		}
		
		

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
	
	public static ArrayList<String> mapperWindowsKmers(int lw,int sw,int lk,double sk,String f1,String f2){
		ReadFile rf1 = new ReadFile(f1);
		ReadFile rf2 = new ReadFile(f2);
		ArrayList<ArrayList<String>> tab2 = rf1.getTab();
		ArrayList<String> Windows = windows(lw, sw, tab2.get(1).get(0));
		ArrayList<String> WindowsCoord = afficheWindows(Windows, sw);
		ArrayList<String> res= new ArrayList<>();
		for (int i=0;i<Windows.size();i++) {			
			KmersOperation km = new KmersOperation(lk,Windows.get(i),rf2);
			if (km.ratio()>=sk){
				res.add(WindowsCoord.get(i));
			}
		}
		return res;
	}

}
