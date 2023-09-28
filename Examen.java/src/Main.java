import java.util.Scanner;
abstract class CompteBancaire {
    private String titulaire;
    private double solde;


    public CompteBancaire(String titulaire, double soldeInitial) {
        this.titulaire = titulaire;
        this.solde = soldeInitial;
    }
    public abstract void retirer(double montant);

    public abstract void deposer(double montant);

    public double getSolde() {

        return solde;
    }


}
