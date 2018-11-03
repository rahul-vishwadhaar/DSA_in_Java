package producerConsumerWrong;

public class Main {

	public static void main(String[] args) {
		
		Q q = new Q();
		
		new ProducerQ(q);
		new ConsumerQ(q);
		
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
