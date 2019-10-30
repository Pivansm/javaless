package com.ifmo.lesson7;

import com.ifmo.lesson7.Book;

import java.util.Hashtable;
import java.util.Map;

/**
 * Библиотека помогает вести учет книг: какие книги и сколько в ней хранятся.
 * Библиотека ограничена по числу типов книг, это ограничение задается аргументом
 * конструктора maxBookKinds. Например, если библиотека ограничена числом 10,
 * то это означает, что она может хранить 10 разных книг, но любое их количество.
 *
 * Если из библиотеки убираются все книги одного типа, то освобождается место,
 * на которое можно добавить книгу другого типа.
 * Например:
 * <pre>
 *     Library library = new Library(2);
 *     library.put(new Book("Stephen King", "Shining"), 2); // return true
 *     library.put(new Book("Stephen King", "Dark Tower"), 3); // return true
 *
 *     // Эту книгу добавить не можем, т.к. лимит 2
 *     library.put(new Book("Tolstoy", "War and peace"), 6); // return false
 *
 *     // Забираем все книги Тёмной башни, чтобы освободить место.
 *     library.take(new Book("Stephen King", "Dark Tower"), 3) // return 3
 *
 *     // Теперь мы можем успешно добавить "Войну и мир".
 *     library.put(new Book("Tolstoy", "War and peace"), 6); // return true
 * </pre>
 *
 * Если попытаться взять из библиотеки больше книг, чем у нее есть, то она
 * должна вернуть только число книг, которые в ней находились и освободить место.
 * Например:
 *
 * <pre>
 *     Library library = new Library(2);
 *     library.put(new Book("Stephen King", "Shining"), 2); // return true
 *
 *     // Все равно вернет 2, т.к. больше нет.
 *     library.take(new Book("Stephen King", "Shining"), 10) // return 2
 * </pre>
 */
public class Library2 {

    Book book;
    Map<String, Integer> mBook;
    Map<String, Book> oBook;
    private int maxBookKinds;
    int countBook;
    public Library2(int maxBookKinds) {
        // TODO implement
        // Возможно здесь следует сынициализировать массив.
        this.maxBookKinds = maxBookKinds;
        mBook = new Hashtable<>();
        oBook = new Hashtable<>();
    }

    /**
     * Add books to library.
     *
     * @param book Book to add.
     * @param quantity How many books to add.
     * @return {@code True} if book successfully added, {@code false} otherwise.
     */
    public boolean put(Book book, int quantity) {
        // TODO implement
        String hesBook = book.author.replace(" ", "").toUpperCase() + book.title.replace(" ", "").toLowerCase();
        if(!mBook.containsKey(hesBook) && maxBookKinds > mBook.size()) {
            mBook.put(hesBook, quantity);
            oBook.put(hesBook, book);
            return true;
        }

        return false;
    }

    /**
     * Take books from library.
     *
     * @param book Book to take.
     * @param quantity How many books to take.
     * @return Actual number of books taken.
     */
    public int take(Book book, int quantity) {
        // TODO implement
        String hesBook = book.author.replace(" ", "").toUpperCase() + book.title.replace(" ", "").toLowerCase();
        if(mBook.containsKey(hesBook) ) {
            if(mBook.get(hesBook) < quantity) {
                int cntBook = mBook.get(hesBook);
                mBook.put(hesBook, quantity - cntBook);
                return quantity - cntBook;
            }
            else {
                mBook.remove(hesBook);
                oBook.remove(hesBook);
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        Library2 library = new Library2(2);
        library.put(new Book("Stephen King", "Shining"), 2); // return true
        library.put(new Book("Stephen King", "Dark Tower"), 3); // return true

        library.put(new Book("Tolstoy", "War and peace"), 6);
        //System.out.print(library.toString());
        for(Map.Entry<String, Integer> item : library.mBook.entrySet()){

            String bookCur = item.getKey();
            Book bookOb = library.oBook.get(bookCur);
            int cntBook = item.getValue();
            System.out.printf("Book: author %s title: %s : count %s\n", bookOb.author, bookOb.title, cntBook);
        }
        System.out.println("--------------------");
        library.take(new Book("Stephen King", "Dark Tower"), 3);

        for(Map.Entry<String, Integer> item : library.mBook.entrySet()){

            String bookCur = item.getKey();
            Book bookOb = library.oBook.get(bookCur);
            int cntBook = item.getValue();
            System.out.printf("Book: author %s title: %s : count %s\n", bookOb.author, bookOb.title, cntBook);

        }
        System.out.println("--------------------");
        library.put(new Book("Tolstoy", "War and peace"), 6);
        for(Map.Entry<String, Integer> item : library.mBook.entrySet()){

            String bookCur = item.getKey();
            Book bookOb = library.oBook.get(bookCur);
            int cntBook = item.getValue();
            System.out.printf("Book: author %s title: %s : count %s\n", bookOb.author, bookOb.title, cntBook);

        }
    }
}
