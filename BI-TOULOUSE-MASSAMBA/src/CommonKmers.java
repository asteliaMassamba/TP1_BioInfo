import java.util.ArrayList;

public class CommonKmers {

	public static void main(String[] args) {
		KmersOperation k = new KmersOperation(args);
		ArrayList<String> s = k.getCommon();
		for (String string : s) {
			System.out.println(string);
		}

	}

}
