import java.util.Scanner;

abstract class CompteBancaire {
    private String titulaire;
    private double solde;


    public CompteBancaire(String titulaire, double soldeInitial) {
        this.titulaire = titulaire;
        this.solde = soldeInitial;
    }
    public abstract void retirer(double montant);
    public double getSolde() {
        return solde;
    }
    public void afficherDetails() {
        System.out.println("Titulaire du compte : " + titulaire);
        System.out.println("Solde du compte : " + solde);
    }


class CompteEpargne extends CompteBancaire {
    private double tauxInteret;

    public CompteEpargne(String titulaire, double soldeInitial, double tauxInteret) {
        super(titulaire, soldeInitial);
        this.tauxInteret = tauxInteret;

    }
    public double getTauxInteret() {
        return tauxInteret;
    }
    public double calculerInterets() {
        return getSolde() * tauxInteret / 100.0;
    }

    public class Main {

