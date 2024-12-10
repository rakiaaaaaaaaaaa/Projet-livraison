package examen_paralel;


import java.util.*;
import java.util.concurrent.Semaphore;

public class GestionnaireColis {
    private List<Colis> colisList; // Liste partagée des colis
    private final Semaphore semaphore; // Sémaphore pour contrôler l'accès exclusif à la liste des colis

    public GestionnaireColis() {
        colisList = new ArrayList<>();
        semaphore = new Semaphore(1); // Un seul thread peut accéder à la liste à la fois
    }

    // Ajouter un colis
    public void ajouterColis(Colis colis) {
        Thread thread = new Thread(() -> {
            try {
                semaphore.acquire(); // Acquérir le sémaphore pour l'accès exclusif
                synchronized (this) { // Moniteur pour synchroniser l'accès à la liste
                    colisList.add(colis);
                    System.out.println("Colis ajouté : " + colis);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release(); // Libérer le sémaphore
            }
        });
        thread.start();
    }

    // Mettre un colis en transit
    public void mettreEnTransit(int id) {
        Thread thread = new Thread(() -> {
            try {
                semaphore.acquire(); // Acquérir le sémaphore pour l'accès exclusif
                synchronized (this) { // Moniteur pour synchroniser l'accès à la liste
                    for (Colis colis : colisList) {
                        if (colis.getId() == id) {
                            colis.marquerEnTransit();
                            System.out.println("Colis mis en transit : " + colis);
                            break;
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release(); // Libérer le sémaphore
            }
        });
        thread.start();
    }

    // Livrer un colis
    public void livrerColis(int id) {
        Thread thread = new Thread(() -> {
            try {
                semaphore.acquire(); // Acquérir le sémaphore pour l'accès exclusif
                synchronized (this) { // Moniteur pour synchroniser l'accès à la liste
                    for (Colis colis : colisList) {
                        if (colis.getId() == id) {
                            colis.marquerLivre();
                            System.out.println("Colis livré : " + colis);
                            break;
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release(); // Libérer le sémaphore
            }
        });
        thread.start();
    }

    // Afficher la liste des colis
    public synchronized List<Colis> afficherColis() {
        return colisList;
    }
}
