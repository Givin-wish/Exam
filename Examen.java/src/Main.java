import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class CompteBancaire {
    private Personne titulaire;
    private String numeroCompte;
    private double solde;
    private List<Transaction> transactions;

    public CompteBancaire(String nom, String prenom, int age, String numeroCompte, double soldeInitial) {
        this.numeroCompte = numeroCompte;
        this.solde = soldeInitial;
        this.transactions = new ArrayList<>();
        this.titulaire = new Personne(nom, prenom, age);
    }

    public abstract void deposer(double montant);

    public abstract void retirer(double montant);

    public double getSolde() {
        return solde;
    }

    public void afficherInformations() {
        System.out.println("Titulaire : " + titulaire);
        System.out.println("Numéro de compte : " + numeroCompte);
        System.out.println("Solde : " + solde);
    }

    public void afficherHistoriqueTransactions() {
        System.out.println("Historique des transactions pour le compte " + numeroCompte + ":");
        for (Transaction transaction : transactions) {
            System.out.println(transaction.toString());
        }
    }

    public void effectuerVirement(CompteBancaire compteDestinataire, double montant) {
        if (montant <= solde) {
            solde -= montant;
            compteDestinataire.deposer(montant);
            Transaction transaction = new Transaction(new Date(), montant, TypeTransaction.VIREMENT_SORTANT);
            transactions.add(transaction);
            compteDestinataire.transactions.add(new Transaction(new Date(), montant, TypeTransaction.VIREMENT_ENTRANT));
        } else {
            System.out.println("Solde insuffisant pour effectuer le virement.");
        }
    }
}

enum TypeTransaction {
    DEPOSIT,
    RETRAIT,
    VIREMENT_SORTANT,
    VIREMENT_ENTRANT
}

class Transaction {
    private Date date;
    private double montant;
    private TypeTransaction typeTransaction;

    public Transaction(Date date, double montant, TypeTransaction typeTransaction) {
        this.date = date;
        this.montant = montant;
        this.typeTransaction = typeTransaction;
    }

    @Override
    public String toString() {
        return "Date : " + date + ", Montant : " + montant + ", Type : " + typeTransaction;
    }
}