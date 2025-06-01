package library;

import datastructures.interfaces.List;
import datastructures.lists.CustomArrayList;

public class Member {
    private String memberId;
    private String name;
    private List<Transaction> transactionList;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.transactionList = new CustomArrayList<>();
    }

    public String getMemberId() { return memberId; }
    public String getName() { return name; }

    public void addTransaction(Transaction transaction) {
        transactionList.add(transaction);
    }

    public Transaction getLastTransaction() {
        if(transactionList.isEmpty())
            return null;

        return transactionList.get(transactionList.size() - 1);
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId='" + memberId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
