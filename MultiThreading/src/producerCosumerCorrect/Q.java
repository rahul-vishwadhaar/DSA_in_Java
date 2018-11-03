package producerCosumerCorrect;

public class Q {

	int n;
	boolean valueSet = false;

	public synchronized void setN(int n) {
		while (valueSet) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			this.n = n;
			valueSet = true;
			notify();

		
	}

	public synchronized int getN() {
		while (!valueSet) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Got ..." + n);
		valueSet = false;
		notify();

		return this.n;
	}

}
