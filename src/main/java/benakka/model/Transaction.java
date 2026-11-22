package benakka.model;

import benakka.enums.TypeTransaction;

import java.util.Date;

public class Transaction {
    private String id;
    private Date date;
    private double montant;
    private TypeTransaction type;

    public Transaction(String id, Date date, double montant, TypeTransaction type) {
        this.id = id;
        this.date = date;
        this.montant = montant;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", montant=" + montant +
                ", type=" + type +
                '}';
    }
}
