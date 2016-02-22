package refactor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class KmerToolBox {

	public KmerToolBox(){
		
	}
	
	public ArrayList<String> listKmer(int l, Sequence s){
		return listKmer(l, s.getPhrase());
	}
	
	public ArrayList<String> listKmer(int l, String p){
		ArrayList<String> res = new ArrayList<>();
		for(int i =0;i<=(p.length()-l);i++){
			res.add(p.substring(i, i+l));
		}
		return res;
	}
	
	
	public ArrayList<String> listSpacedKmer(String graine,String s){
		int longueur = graine.length();
		ArrayList<String> notSpaced = listKmer(longueur, s);
		ArrayList<String> res = new ArrayList<>();
		for (String notSpacedKmer : notSpaced) {
			char arr[] = notSpacedKmer.toCharArray();
			for(int i = 0; i< graine.length();i++){
				if(graine.charAt(i)=='-'){
					arr[i]=' ';
				}
			}
			String tmp = new String(arr);
			tmp.replaceAll(" ", "");
			res.add(tmp);
		}
		return res;
		
	}
	
	public ArrayList<String> listSpacedKmer(String graine,Sequence s){
		return listSpacedKmer(graine, s.getPhrase());
	}
	
	public ArrayList<String> commonKmer (int l , ArrayList<String> listKmer1, ArrayList<String> listKmer2){
		HashSet<String> listCommonKmer = new HashSet<>();
		for (String kmer : listKmer1) {
			if(listKmer2.contains(kmer)){		
				listCommonKmer.add(kmer);
			}
		}
		return new ArrayList<>(listCommonKmer);
	}
	
	public ArrayList<String> commonKmer (int l , Sequence s1, Sequence s2){
		ArrayList<String> listKmer1 = listKmer(l, s1);
		ArrayList<String> listKmer2 = listKmer(l, s2);
		return commonKmer(l, listKmer1, listKmer2);
	}
	
	public double ratioCommonKmer (int l , Sequence s1, Sequence s2){
		ArrayList<String> listKmer1 = listKmer(l, s1);
		ArrayList<String> listKmer2 = listKmer(l, s2);
		return ratioCommonKmer(l, listKmer1, listKmer2);
	}
	
	public double ratioCommonKmer (int l , String s1, String s2){
		ArrayList<String> listKmer1 = listKmer(l, s1);
		ArrayList<String> listKmer2 = listKmer(l, s2);
		return ratioCommonKmer(l, listKmer1, listKmer2);
	}
	
	public double ratioCommonKmer(int l, ArrayList<String> listKmer1, ArrayList<String> listKmer2){
		ArrayList<String> listCommonKmer = commonKmer(l, listKmer1, listKmer2);
		double nbCommon=0;
		nbCommon=(double)listCommonKmer.size()/listKmer2.size();
		return nbCommon;
	}
	
	public ArrayList<String> commonSpacedKmer (String graine, Sequence s1, Sequence s2){
		ArrayList<String> listKmer1 = listSpacedKmer(graine, s1);
		ArrayList<String> listKmer2 = listSpacedKmer(graine, s2);
		return commonKmer(listKmer1.get(0).length(), listKmer1, listKmer2);
	}
	
	public double ratioCommonSpacedKmer(String graine, Sequence s1, Sequence s2){
		ArrayList<String> listKmer1 = listSpacedKmer(graine, s1);
		ArrayList<String> listKmer2 = listSpacedKmer(graine, s2);
		return ratioCommonKmer(graine.length(), listKmer1, listKmer2);
	}
	
	public TreeMap<Integer, String> bestMatches (String graine, Sequence read, ArrayList<Sequence> germline){
		TreeMap<Integer, String> res = new TreeMap<>(Collections.reverseOrder());
		ArrayList<String> readKmer = listSpacedKmer(graine, read);
		ArrayList<String> germlineKmer = new ArrayList<>();
		ArrayList<String> common = new ArrayList<>();
		int longueur = readKmer.get(0).length();
		for (Sequence sequence : germline) {
			germlineKmer=listSpacedKmer(graine, sequence);
			common = commonKmer(longueur, readKmer, germlineKmer);
			res.put(common.size(), sequence.getId());
		}
		return res;
		
	}
	
	public void afficheBestMatches(int n, String graine, Sequence read, ArrayList<Sequence> germline){
		TreeMap<Integer, String> res = bestMatches(graine, read, germline);
		int cpt = 0;
		for (Entry<Integer, String> entry : res.entrySet()) {
			if(cpt>n){
				 break;
			}
			Integer key = entry.getKey();
			String value = entry.getValue();
			System.out.println(value+"\t"+key);
			cpt++;
		}
	}
	
	public void vjDiscover(String graine, ArrayList<Sequence> read, ArrayList<Sequence> germLineV, ArrayList<Sequence> germLineJ){
		TreeMap<Integer, String> tmV;
		TreeMap<Integer, String> tmJ;
		for (Sequence sequence : read) {
			tmV=bestMatches(graine, sequence, germLineV);
			tmJ=bestMatches(graine, sequence, germLineJ);
			//may be lastKey au lieu de firstKey
			System.out.println(sequence.getId()+"\t"+tmV.get(tmV.firstKey())+"\t"+tmJ.get(tmJ.firstKey()));
			
		}
		
	}
	
}
