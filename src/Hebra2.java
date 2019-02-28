
public class Hebra2 implements Runnable {

	public static void main (String[] args) {
		int numeroHebras =50;
		for (int i= 0; i < numeroHebras ; i++) {
			Thread hebra = new Thread(new Hebra2());
			hebra.setName ("Hebra " + i);
			hebra.start();
		}
		System.out.println("Creadas las hebras");
	}

	@Override
	public void run() {
		for (int i= 0; i< 1000; i++) {
			System.out.println(Thread.currentThread().getName() + " -> "+ i);
		}
	}
}
