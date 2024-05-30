package semaforo;

import java.util.concurrent.Semaphore;

public class Main {
 public static void main(String[] args) throws InterruptedException {
	Semaphore sem = new Semaphore(1);
	RisorsaCondivisa risorsa = new RisorsaCondivisa();
	
	WorkerThread t1 = new WorkerThread(sem,risorsa,"P");
	WorkerThread t2 = new WorkerThread(sem,risorsa,"C");
	
	t1.start();
	t2.start();
	
	t1.join();
	t2.join();
	
	System.out.println("Valore finale del contore : "+risorsa.count);
	
}
}
