package putti_giocosedie;

class Partecipante extends Thread

{
	Posto sedie[];

	public Partecipante(Posto sedie[]) {

		this.sedie = sedie;

	}

	public void run() {
                
		try {
                    
                     Scrittore s = new Scrittore("risultato.txt");
			sleep((int) (Math.random() * 1000));

			for (int i = 0; i < sedie.length; i++) {
				if (sedie[i].occupa()) {
					System.out.println("Sono il Thread " + this.getName()
							+ ". Sono riuscito a sedermi sul posto " + i);
                                        s.scrivi(this.getId(), i);
					return;
				}
			}
			System.out.println("Sono il Thread " + this.getName()
					+ ". Ho perso :((((");

		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
