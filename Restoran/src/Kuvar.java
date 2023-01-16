
public class Kuvar extends Thread{
	private final Kuhinja kuhinja;
	
	public Kuvar(Kuhinja kuhinja) {
		this.kuhinja = kuhinja;
	}
	
	@Override
	public void run() {
		try {
			while(!interrupted()) {
				sleep(24000);
				kuhinja.dodajPotaz(10000);
			}
		}
		catch(InterruptedException ex) {
			System.out.println(ex.getMessage());
		}
	}

}
