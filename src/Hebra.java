


public class Hebra extends Thread {
	
	public void run () {
		for (int i= 0; i< 1000; i++) {
			try {
				Thread.sleep (10);				//tiempo adjudicado a cada proceso
			} catch (InterruptedException e) {

			}
			System.out.println(this.getName() + " -> "+ i);
		}
	}
	
	public static void main (String[] args) {
		int numeroHebras =50;
		for (int i= 0; i< numeroHebras ; i++) {
			Hebra hebra = new Hebra ();
			hebra.setName("Hebra " + i);
			hebra.start();
		}
		System.out.println("Creadas las hebras");
	}
}
