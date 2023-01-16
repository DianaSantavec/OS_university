
public class Konobarica extends Thread {
	private final Kuhinja kuhinja;
	
	public Konobarica(Kuhinja kuhinja) {
		this.kuhinja = kuhinja;
	}
	
	@Override
	public void run() {
		try {
			while(!interrupted()) {
				sleep(1000);
				double porudzbina = Math.random();
				if (porudzbina < 0.4) {
					kuhinja.napraviVegetarijanskiSendvic();
				}
				else if (porudzbina < 0.7) {
					kuhinja.napraviPotazOdBundeve();
				}
				else {
					kuhinja.napraviTofuSaPovrcem();
				}
			}
		}
		catch (InterruptedException ex){
			System.out.println(ex.getMessage());
		}
	}
}
