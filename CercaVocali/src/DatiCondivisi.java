

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Classe che memorizza il numero di volta che viene ripetuta una vocale
 *
 * @author orsenigo_giacomo
 */
public class DatiCondivisi {

    /**
     * booleane che indicano se i thread sono in thTerminato o no
     */
    private final boolean[] thTerminato;

    private Schermo schermo;
        
    private Vocali vocali;
    
    private Semaphore semA;
    
    private Semaphore semE;
    
    private Semaphore semI;
    
    private Semaphore semO;
    
    private Semaphore semU;
    
    private Semaphore semVisualizza;
    
    
    /**
     * @brief costruttore
     *
     * Inizializza le vocali, lo schermo e il vettore che indica quali thread sono terminati
     */
    public DatiCondivisi() {
        this.thTerminato = new boolean[Vocali.NUM_VOCALI];
        for (int i = 0; i < thTerminato.length; i++) {
            thTerminato[i] = false;
        }
        this.vocali = new Vocali();
        this.schermo = new Schermo();
        
        semA=new Semaphore(0);
        semE=new Semaphore(0);
        semI=new Semaphore(0);
        semO=new Semaphore(0);
        semU=new Semaphore(0);
        semVisualizza=new Semaphore(0);
    }

    public void resetDatiCondivisi() {
        for (int i = 0; i < thTerminato.length; i++) {
            thTerminato[i] = false;
        }
        this.vocali.reset();
        this.schermo.reset();
    }

    public void scriviSuSchermo(String str) {
        schermo.add(str);
    }
    
    /**
     * @brief controlla se i thread sono terminati
     *
     * @return true se tutti i thread sono terminati
     */
    public boolean sonoFinitiTutti() {
        boolean ris = true;
        for (int i = 0; i < 5; i++) {
            if (!thTerminato[i]) {
                ris = false;
            }
        }
        return ris;
    }

    /**
     * @brief set terminato
     *
     * imposta come terminato il thread corrispondente alla vocale data
     * @param vocale di cui impostare il thread come terminato
     */
    public void setFinito(char vocale) {
        thTerminato[vocali.getIndex(vocale)] = true;
    }

    public String getStringSchermo() {
        return schermo.toString();
    }
    
    public char getVocaleMax() {
        return vocali.getMax();
    }

    public void incNum(char vocale) {
        vocali.incNum(vocale);
    }
    
    public char getVocale(int index) {
        return vocali.getVocale(index);
    }
    
    
    
    
    
    public void WaitVisualizza() throws InterruptedException {
        semA.acquire();
    } 
    
    public void WaitA() throws InterruptedException {
        semA.acquire();
    }
    
    public void WaitE() throws InterruptedException {
        semE.acquire();
    }
    
    public void WaitI() throws InterruptedException {
        semI.acquire();
    }
    
    public void WaitO() throws InterruptedException {
        semO.acquire();
    }
    
    public void WaitU() throws InterruptedException {
        semU.acquire();
    }
    
    public void SignalVisualizza() {
        semVisualizza.release();
    }
    
    public void SignalA() {
        semA.release();
    }
    
    public void SignalE() {
        semE.release();
    }
    
    public void SignalI() {
        semI.release();
    }
    
    public void SignalO() {
        semO.release();
    }
    
    public void SignalU() {
        semU.release();
    }
    

}
