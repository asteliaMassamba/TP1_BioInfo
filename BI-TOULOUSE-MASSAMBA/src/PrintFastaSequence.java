import java.io.IOException;

public class PrintFastaSequence {

	public static void main(String[] args) throws IOException {
		PrintFasta n = new PrintFasta(args);
		n.sequence();
	}

}
