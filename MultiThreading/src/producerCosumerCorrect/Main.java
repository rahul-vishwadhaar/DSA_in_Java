package producerCosumerCorrect;

public class Main {

	public static void main(String[] args) {

		Q q = new Q();

		new ProducerC(q);
		new ConsumerC(q);
		

	}

}
