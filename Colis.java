package examen_paralel;


public class Colis {
    private int id;
    private String description;
    private String destination;
    private EtatColis etat;

    public enum EtatColis {
        EN_ATTENTE, EN_TRANSIT, LIVRE
    }

    public Colis(int id, String description, String destination) {
        this.id = id;
        this.description = description;
        this.destination = destination;
        this.etat = EtatColis.EN_ATTENTE;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getDestination() {
        return destination;
    }

    public EtatColis getEtat() {
        return etat;
    }

    public void marquerEnTransit() {
        this.etat = EtatColis.EN_TRANSIT;
    }

    public void marquerLivre() {
        this.etat = EtatColis.LIVRE;
    }

    @Override
    public String toString() {
        return "Colis{id=" + id + ", description='" + description + "', destination='" + destination + "', etat=" + etat + '}';
    }
}
