package management;

import datastructures.lists.CustomArrayList;
import library.Transaction;

import java.util.Date;
import java.util.List;

public class TransactionManager {
    private List<Transaction> transactionList;
    private int counter = 1;

    public TransactionManager() {
        transactionList = new CustomArrayList<>();
    }

    public Transaction addTransaction(String bookTitle, String memberName, String type) {

        Transaction transaction = new Transaction(
                "TXN-" + new Date().getTime(),
                bookTitle,
                memberName,
                type
        );

        transactionList.add(transaction);
        return transaction;
    }

    public Transaction getTransactionByIndex(int index) {
        if(index < 0 || index >= transactionList.size())
            return null;

        return transactionList.get(index);
    }
}
