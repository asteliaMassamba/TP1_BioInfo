package refactor;

import java.util.ArrayList;

public class WindowedSequence {
	private String id;
	private ArrayList<String> windows;
	private int shift;
	private int longueur;
	
	public WindowedSequence() {
		this.id="";
		this.windows=new ArrayList<>();
		this.shift=0;
		this.longueur=0;
	}
	
	public WindowedSequence(String id, ArrayList<String> windows, int longueur,int shift){
		this.id=id;
		this.windows=windows;
		this.longueur=longueur;
		this.shift=shift;
	}
	
	public String getId() {
		return id;
	}
	
	public ArrayList<String> getWindows() {
		return windows;
	}
	
	public int getLongueur() {
		return longueur;
	}
	
	public int getShift() {
		return shift;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setWindows(ArrayList<String> windows) {
		this.windows = windows;
	}
	
	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}
	
	public void setShift(int shift) {
		this.shift = shift;
	}
	
	public ArrayList<String> explicitWindows(){
		ArrayList<String> res = new ArrayList<>();
		int idx = 1;
		for (String string : windows) {
			res.add(idx+"\t"+string+"\t"+(idx+string.length()-1));
			idx+=shift;
		}
		return res;
	}
	
	public void afficheWindows(){
		ArrayList<String> tmp = explicitWindows();
		for (String string : tmp) {
			System.out.println(string);
		}
	}
}
