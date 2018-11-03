/**
 * 
 */
package concurrency.utilities;

import java.util.concurrent.Semaphore;

/**
 * @author rahul kumar
 * 
 */
public class SemaphoreExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Semaphore sem = new Semaphore(1);

		SemaphoreExample se = new SemaphoreExample();
		se.new IncThread(sem, "A");
		se.new DecThread(sem, "B");

	}

	class IncThread implements Runnable {

		Semaphore sem = null;
		String name;

		IncThread(Semaphore sem, String name) {
			this.name = name;
			this.sem = sem;

			new Thread(this).start();

		}

		public void run() {
			// TODO Auto-generated method stub
			System.out.println("Starting " + name);

			try {
				sem.acquire();
				System.out.println(name + " gets permit");

				for (int i = 0; i < 5; i++) {
					Shared.count++;
					System.out.println(name + Shared.count);
					Thread.sleep(100);
				}
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}

			System.out.println(name + " Releasing permit");
			sem.release();

		}
	}

	class DecThread implements Runnable {

		Semaphore sem;
		String name;

		DecThread(Semaphore sem, String name) {
			this.sem = sem;
			this.name = name;

			new Thread(this).start();
		}

		public void run() {
			System.out.println("Starting " + name);

			System.out.println(name + " Acquiring lock");
			try {
				sem.acquire();
				System.out.println(name + " Lock acquired");

				for (int i = 0; i < 5; i++) {
					Shared.count--;
					System.out.println(name + Shared.count);
					Thread.sleep(100);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println(name + " Releasing permit");
			sem.release();

		}

	}
}
