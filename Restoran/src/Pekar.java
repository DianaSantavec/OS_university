
public class Pekar extends Thread {
	private final Kuhinja kuhinja;
	
	public Pekar(Kuhinja kuhinja) {
		this.kuhinja = kuhinja;
	}
	
	@Override
	public void run() {
		try {
			while(!interrupted()) {
				sleep(6000);
				kuhinja.dodajHleb(6);
			}
		}
		catch(InterruptedException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
