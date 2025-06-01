package management;

import datastructures.interfaces.Map;
import datastructures.maps.CustomHashMap;
import library.Member;
import library.Transaction;

public class MemberManager {
    private Map<String ,Member> memberMap;

    public MemberManager() {
        memberMap =  new CustomHashMap<>();
    }

    public void addMember(Member member) {
        memberMap.put(member.getMemberId() ,member);
    }

    public Member getMember(String memberId) {
        return memberMap.get(memberId);
    }

    public void recordTransaction(String memberId, Transaction transaction) {
        Member member = memberMap.get(memberId);
        if(member != null)
            member.addTransaction(transaction);
    }

    public Transaction getLastTransaction(String memberId) {
        Member member = memberMap.get(memberId);
        return member != null ? member.getLastTransaction() : null ;
    }
}
