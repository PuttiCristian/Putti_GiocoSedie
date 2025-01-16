package putti_giocosedie;

/**
 * La classe Display estende Thread e si occupa di monitorare lo stato dei posti.
 * Mostra un output che rappresenta graficamente i posti occupati e liberi.
 */
class Display extends Thread
{
    /**
     * Array di oggetti Posto rappresentanti le sedie da monitorare.
     */
    private Posto sedie[];

    /**
     * Variabile per indicare la fine del gioco.
     */
    private boolean endgame;

    /**
     * Costruttore della classe Display.
     * 
     * @param sedie Array di oggetti Posto che rappresentano le sedie.
     */
    public Display(Posto sedie[]) {
        this.sedie = new Posto[sedie.length];

        for (int s = 0; s < sedie.length; s++)
            this.sedie[s] = sedie[s];
    }

    /**
     * Metodo eseguito quando il thread viene avviato.
     * Il metodo monitora lo stato dei posti e aggiorna l'output fino alla fine del gioco.
     */
    public void run() {
        try {
            while (!endgame) {
                int count = 0;

                sleep((int) (Math.random() * 250));

                for (int i = 0; i < sedie.length; i++) {
                    if (sedie[i].libero())
                        System.out.print("0");
                    else {
                        count++;
                        System.out.print("*");
                    }
                }
                System.out.println();
                endgame = (count == sedie.length);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
