package producerConsumerWrong;

public class ProducerQ implements Runnable {
	Q q  = null;
	
	ProducerQ(Q q){
		this.q = q;
		Thread t = new Thread(this, "Producer");
		t.start();
	}
	
	public void run(){
		
	int i =0;
	while(i < 10)
	   q.setN(i++);
	}

}
