
public class Restoran {

	public static void main(String[] args) throws InterruptedException {
		Thread.currentThread().setName("Laza");
		
		Kuhinja kuhinja = new Kuhinja();
		
		Konobarica rada = new Konobarica(kuhinja);
		rada.setName("Rada");
		Konobarica dara = new Konobarica(kuhinja);
		dara.setName("Dara");
		
		SecePovrce miki = new SecePovrce(kuhinja);
		miki.setName("Miki");
		
		Kuvar mica = new Kuvar(kuhinja);
		mica.setName("Mica");
		
		Pekar joki = new Pekar(kuhinja);
		joki.setName("Joki");
		
		RostiljMajstor vule = new RostiljMajstor(kuhinja);
		vule.setName("Vule");
		RostiljMajstor gule = new RostiljMajstor(kuhinja);
		gule.setName("Gule");
		
		rada.start();
		dara.start();
		miki.start();
		mica.start();
		joki.start();
		vule.start();
		gule.start();
		
		Thread.sleep(30000);
		
		rada.interrupt();
		dara.interrupt();
		miki.interrupt();
		mica.interrupt();
		joki.interrupt();
		vule.interrupt();
		gule.interrupt();
		
		rada.join();
		dara.join();
		miki.join();
		mica.join();
		joki.join();
		vule.join();
		gule.join();
		
		System.out.println("Ukupan pazar " + kuhinja.uzmiPazar());
		
	}

}
