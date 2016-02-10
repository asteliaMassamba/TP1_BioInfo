import java.util.ArrayList;


public class windowsAffiche {
	public static void main(String[] args) {
		int l = Integer.parseInt(args[0]);
		int s = Integer.parseInt(args[1]);
		ReadFile rf = new ReadFile(args[2]);
		ArrayList<ArrayList<String>> fileParse= rf.getTab();
		System.out.println("windows");
		for(String st : Parti1.afficheWindows(Parti1.windows(l,s,fileParse.get(1).get(0)), s)){
			System.out.println(st);
		}
		
	}
}
