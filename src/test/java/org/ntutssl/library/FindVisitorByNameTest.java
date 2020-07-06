package org.ntutssl.library;

import static org.junit.Assert.*;

import org.junit.Before;

import org.junit.Test;

public class FindVisitorByNameTest 
{
    FindVisitorByName testFindVisitorByName;
    Book book_test1;
    Book book_test2;
    Book book_test3;
    Book book_test4;
    Collection collection_test1;
    Collection collection_test2;
    Collection collection_test3;
    Collection collection_test4;
    Collection collection_test5;

    @Before // executed just before every @Test
    public void setUp() {
        testFindVisitorByName = new FindVisitorByName("CSS Design");
        book_test1 = new Book("Computer Science", "Computer great!", "John", "1234567890");
        book_test2 = new Book("CSS Design", "HTML + CSS", "Kevin", "0987654321");
        book_test3 = new Book("Python Nice", "Python", "Nancy", "1231231230");
        book_test4 = new Book("Java Hard", "Java", "Chiu", "4564564560");
        collection_test1 = new Collection("All", "Usually use");
        collection_test2 = new Collection("My Favorite", "Lover");
        collection_test3 = new Collection("Lesson", "Lesson using");
        collection_test4 = new Collection("Hating", "Inside all hating");
        collection_test5 = new Collection("Fruit", "Tomato");
        collection_test1.add(book_test2);
        collection_test1.add(book_test3);
        collection_test2.add(book_test1);
        collection_test2.add(collection_test1);
        collection_test4.add(book_test4);
        collection_test4.add(collection_test5);
        collection_test3.add(collection_test2);
        collection_test3.add(collection_test4);
    }
    
    @Test
    public void test_vistBook()
    {
        book_test2.accept(testFindVisitorByName);
        assertEquals("Book Name: CSS Design\n\tAuthor: Kevin\n\tDescription: HTML + CSS\n\tISBN: 0987654321\n"
        , testFindVisitorByName.getResult());
    }
    
    @Test
    public void test_visitCollection()
    {
        collection_test1.accept(testFindVisitorByName);
        assertEquals("Book Name: CSS Design\n\tAuthor: Kevin\n\tDescription: HTML + CSS\n\tISBN: 0987654321\n"
        , testFindVisitorByName.getResult());
    }

    @Test
    public void test_getResult()
    {
        collection_test1.accept(testFindVisitorByName);
        assertEquals("Book Name: CSS Design\n\tAuthor: Kevin\n\tDescription: HTML + CSS\n\tISBN: 0987654321\n"
        , testFindVisitorByName.getResult());
    }
}


