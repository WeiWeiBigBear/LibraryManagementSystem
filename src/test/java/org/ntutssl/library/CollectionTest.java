package org.ntutssl.library;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;

import org.junit.Test;

public class CollectionTest 
{
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
    public void test_collection_name()
    {
        assertEquals("Hating", collection_test4.name());
    }

    @Test
    public void test_collection_description()
    {
        assertEquals("Inside all hating", collection_test4.description());
    }

    @Test
    public void test_collection_iterator()
    {
        Iterator<Item> it = collection_test2.iterator();
        assertTrue(it.hasNext());
        assertEquals(1, it.next().size());
        assertEquals(2, it.next().size());
    }

    @Test
    public void test_collection_size()
    {
        assertEquals(3, collection_test2.size());
        assertEquals(0, collection_test5.size());
    }

    @Test
    public void test_collection_add()
    {
        collection_test4.add(book_test2);
        collection_test4.add(book_test3);
        assertEquals(3, collection_test4.size());
    }

    @Test
    public void test_collection_accept()
    {
        FindVisitorByName testFindVisitorByName = new FindVisitorByName("Computer Science");
        collection_test1.accept(testFindVisitorByName);
        assertEquals("", testFindVisitorByName.getResult());
    }
}
