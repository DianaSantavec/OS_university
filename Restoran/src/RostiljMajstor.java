
public class RostiljMajstor extends Thread{
	private final Kuhinja kuhinja;
	
	public RostiljMajstor(Kuhinja kuhinja) {
		this.kuhinja = kuhinja;
	}
	
	@Override
	public void run() {
		try {
			while(!interrupted()) {
				sleep(6000);
				kuhinja.dodajSir(1);
			}
			
		}
		catch(InterruptedException ex) {
			System.out.println(ex.getMessage());
		}
	}

}
