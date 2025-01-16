package putti_giocosedie;

/**
 * Rappresenta un posto che può essere occupato o lasciato libero.
 * La classe include metodi per verificare se il posto è libero e per occuparlo.
 */
public class Posto
{
    /**
     * Indica se il posto è occupato. 
     * {@code true} se il posto è occupato, {@code false} altrimenti.
     */
    private boolean occupato;

    /**
     * Costruttore della classe Posto.
     * Inizializza il posto come non occupato.
     */
    public Posto()
    {
        occupato = false;
    }

    /**
     * Verifica se il posto è libero.
     * 
     * @return {@code true} se il posto è libero, {@code false} se è occupato.
     */
    public synchronized boolean libero() {
        return (!occupato);
    }

    /**
     * Occupa il posto se è libero.
     * 
     * @return {@code true} se il posto è stato occupato con successo, {@code false} se era già occupato.
     */
    public synchronized boolean occupa() {
        if (occupato)
            return false;
        else
            return occupato = true;
    }
}