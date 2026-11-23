package benakka.model;

import benakka.enums.TypeTransaction;

import java.util.Date;

public class Transaction {
    private String id;
    private Date date;
    private double montant;
    private TypeTransaction type;

    public String getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public double getMontant() {
        return montant;
    }

    public TypeTransaction getType() {
        return type;
    }

    public Transaction(String id, Date date, double montant, TypeTransaction type) {
        this.id = id;
        this.date = date;
        this.montant = montant;
        this.type = type;
    }
    public Transaction(){}

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", montant=" + montant +
                ", type=" + type +
                '}';
    }
    
    
    // ---------------- BUILDER ----------------
    public static class TransactionBuilder {

        private Transaction transaction=new Transaction();

        public TransactionBuilder id(String id){
            transaction.id= id;
            return this;
        }

        public TransactionBuilder date(Date date){
            transaction.date=date;
            return this;
        }

        public TransactionBuilder montant(double montant){
            transaction.montant=montant;
            return this;
        }

        public TransactionBuilder type(TypeTransaction type){
            transaction.type=type;
            return this;
        }

        public Transaction build(){
            return this.transaction;
        }
    }

}
