
public class SecePovrce extends Thread {
	private final Kuhinja kuhinja;
	
	public SecePovrce(Kuhinja kuhinja) {
		this.kuhinja = kuhinja;
	}
	
	@Override
	public void run() {
		try {
			while(!interrupted()) {
				sleep(9000);
				kuhinja.dodajPotaz(1000);
			}
		}
		catch (InterruptedException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
