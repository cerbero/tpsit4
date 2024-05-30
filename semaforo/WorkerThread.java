package semaforo;

import java.util.concurrent.Semaphore;
public class WorkerThread extends Thread {

	Semaphore sem;
	RisorsaCondivisa ris;
	
	public WorkerThread(Semaphore sem,RisorsaCondivisa ris,String threadName) {
		super(threadName);
		this.sem = sem;
		this.ris = ris;
		
		
	}
	@Override
	public void run() {
		if (this.getName().equals("P")) {
			System.out.println("Ciao, Sono il Produttore");
			try {
				System.out.println("Ciao, sono sempre io il Produttore, sto aspettendo il permesso di scrivere");
				sem.acquire();
				System.out.println("Permesso Accordato");
				for ( int i=0;i<5;i++) {
					ris.count++;
					System.out.println(getName()+":"+ris.count);
					Thread.sleep(10);
				}
				
			}
			catch (InterruptedException exc) {
				System.out.println(exc);
			}
			System.out.println("Il Prodotture rilascia il permesso");
			sem.release();
		}
		else
		{
			System.out.println("Ciao, Sono il Consumatore");
			try {
				System.out.println("Ciao, sono sempre io il Consummatore, sto aspettendo il permesso di scrivere");
				sem.acquire();
				System.out.println("Permesso Accordato");
				for ( int i=0;i<5;i++) {
					ris.count--;
					System.out.println(getName()+":"+ris.count);
					Thread.sleep(10);
				}
				
			}
			catch (InterruptedException exc) {
				System.out.println(exc);
			}
			System.out.println("Il Consumatore rilascia il permesso");
			sem.release();
		}
		
	}
}
