package management;

import datastructures.interfaces.Map;
import datastructures.maps.CustomHashMap;
import library.Book;
import library.Member;

public class BookManager {
    private Map<String ,Book> bookMap;

    private MemberManager memberManager;

    public BookManager(MemberManager memberManager) {
        bookMap = new CustomHashMap<>();
        this.memberManager = memberManager;
    }

    public void addBook(Book book) {
        bookMap.put(book.getIsbn() ,book);
    }

    public Book getBookByIsbn(String isbn) {
        return bookMap.get(isbn);
    }

    public boolean isBookAvailable(String isbn) {
        Book book = bookMap.get(isbn);
        return book.isAvailable() && book != null;
    }

    public void setBookAvailability(String isbn, boolean available) {
        Book book = bookMap.get(isbn);
        if(book != null)
            book.setAvailable(true);
    }

    public void addToWaitlist(String isbn, String memberId) {
        Book book = bookMap.get(isbn);
        if(book != null)
            book.addToWaitlist(new Member(memberId, ""));
    }

    public Member getNextFromWaitlist(String isbn) {
        Book book = bookMap.get(isbn);
        return book != null ? book.getNextInWaitlist() : null;
    }

    public boolean hasWaitlist(String isbn) {
        Book book = bookMap.get(isbn);
        return book.hasWaitlist() && book != null;
    }
}