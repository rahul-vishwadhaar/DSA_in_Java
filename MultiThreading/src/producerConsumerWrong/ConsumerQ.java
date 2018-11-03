package producerConsumerWrong;

public class ConsumerQ implements Runnable{
	Q q;
	
	ConsumerQ(Q q){
		this.q= q;
		Thread t = new Thread(this, "Consumer");
		t.start();
	}
	public void run(){
		
		while(true){
			System.out.println(q.getN());
		}
	}

}
