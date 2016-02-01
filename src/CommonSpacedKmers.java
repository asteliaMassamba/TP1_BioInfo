import java.util.ArrayList;

public class CommonSpacedKmers {

	public static void main(String[] args) {
		KmersSpacedOperation k = new KmersSpacedOperation(args);
		ArrayList<String> s = k.getCommon();
		for (String string : s) {
			System.out.println(string);
		}

	}

}
