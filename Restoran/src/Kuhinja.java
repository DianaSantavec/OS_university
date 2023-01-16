
public class Kuhinja {
	
	private int parcadHleba;
	private int tofuSir;
	private int gramaPovrca;
	private int mililitaraPotaza;
	
	private int pazar;
	
	private final Object objekatParcadHleba = new Object();
	private final Object objekatTofuSir = new Object();
	private final Object objekatGramaPovrca = new Object();
	private final Object objekatMililitaraPotaza = new Object();
	private final Object objekatPazar = new Object();
	
	public Kuhinja () {
		System.out.println("Kuhinja pokrenuta");
	}
	
	private void ispisiStanje(String poruka) {
		System.out.println(Thread.currentThread().getName() + " "+ poruka + " "+ parcadHleba + " " + tofuSir + " " + gramaPovrca + " " + mililitaraPotaza + " " + pazar);
	}
	
	public void dodajHleb(int kolicina) {
		synchronized (objekatParcadHleba) {
			parcadHleba += kolicina;
			objekatParcadHleba.notifyAll();
			ispisiStanje("dodat hleb");
		}
	}
	
	public void dodajSir(int kolicina) {
		synchronized (objekatTofuSir) {
			tofuSir += kolicina;
			objekatTofuSir.notifyAll();
			ispisiStanje("dodat sir");	
		}
		
	}
	
	public void dodajPovrce(int kolicina) {
		synchronized (objekatGramaPovrca) {
			gramaPovrca += kolicina;
			objekatGramaPovrca.notifyAll();
			ispisiStanje("dodato povrce");
		}
		
	}
	
	public void dodajPotaz(int kolicina) {
		synchronized (objekatMililitaraPotaza) {
			mililitaraPotaza += kolicina;
			objekatMililitaraPotaza.notifyAll();
			ispisiStanje("dodat potaz");
		}
	}
	
	public void napraviVegetarijanskiSendvic() throws InterruptedException {
		synchronized (objekatParcadHleba) {
			while(parcadHleba < 2) {
				ispisiStanje("Ceka hleb");
				objekatParcadHleba.wait();
			}
			parcadHleba -= 2;
		}
		
		synchronized (objekatTofuSir) {
			while(tofuSir < 1) {
				ispisiStanje("Ceka sir");
				objekatTofuSir.wait();
			}
			tofuSir -= 1;
		}
		
		synchronized (objekatGramaPovrca) {
			while(gramaPovrca < 100) {
				ispisiStanje("ceka povrce");
				objekatGramaPovrca.wait();
			}
			gramaPovrca -= 100;
		}
		
		synchronized (objekatPazar) {
			pazar += 320;
			
		}
		
	}
	
	public void napraviPotazOdBundeve() throws InterruptedException {
		synchronized (objekatMililitaraPotaza) {
			while (mililitaraPotaza < 500) {
				ispisiStanje("ceka potaz");
				objekatMililitaraPotaza.wait();
			}
			mililitaraPotaza -= 500;
		}
		
		synchronized (objekatParcadHleba){
			while(parcadHleba < 1) {
				ispisiStanje("ceka hleb");
				objekatParcadHleba.wait();
			}
			parcadHleba -= 1;	
		}
		
		synchronized (objekatPazar) {
			pazar += 340;
			
		}
	}
	
	public void napraviTofuSaPovrcem() throws InterruptedException {
		synchronized (objekatTofuSir) {
			while(tofuSir < 1) {
				ispisiStanje("ceka sir");
				objekatTofuSir.wait();
			}
			tofuSir -= 1;
		}
		
		synchronized (objekatGramaPovrca) {
			while (gramaPovrca < 300) {
				ispisiStanje("ceka povrce");
				objekatGramaPovrca.wait();
			}
			gramaPovrca -= 300;
		}
		
		synchronized (objekatPazar) {
			pazar += 520;
		}
	}
	
	public int uzmiPazar() {
		synchronized (objekatPazar) {
			int ukupno = pazar;
			pazar = 0;
			ispisiStanje("Uzet pazar");
			return ukupno;
		}
	}

}
