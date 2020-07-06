package org.ntutssl.library;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;

import org.junit.Test;

public class ItemTest 
{
    FindVisitorByName testFindVisitorByName;
    Item item_test1;
    Item item_test2;
    Book book_test1;
    Book book_test2;
    Book book_test3;
    Book book_test4;
    Book book_test5;
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
        book_test5 = new Book("Chinese Recipe", "Food", "Sammi", "7897897890");
        collection_test1 = new Collection("Lesson", "Lesson using");
        collection_test2 = new Collection("My Favorite", "Lover");
        collection_test3 = new Collection("All", "Usually use");
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
        item_test1 = collection_test3;
        item_test2 = book_test5;
    }
    
    @Test
    public void test_item_is_book_add_book_should_throw_an_exception()
    {
        try{
            item_test2.add(book_test1);
            fail("Illegal Operation");
        }
        catch(RuntimeException e){
            assertEquals("Illegal Operation", e.getMessage());
        }
    }

    @Test
    public void test_item_is_book_add_collection_should_throw_an_exception()
    {
        try{
            item_test2.add(collection_test1);
            fail("Illegal Operation");
        }
        catch(RuntimeException e){
            assertEquals("Illegal Operation", e.getMessage());
        }
    }

    @Test
    public void test_item_is_collection_add_book()
    {
        item_test1.add(book_test1);
        assertEquals(5, item_test1.size());
    }

    @Test
    public void test_item_is_collection_add_collection_has_book()
    {
        item_test1.add(collection_test1);
        assertEquals(6, item_test1.size());
    }

    @Test
    public void test_item_is_collection_add_collection_no_book()
    {
        item_test1.add(collection_test5);
        assertEquals(4, item_test1.size());
    }

    @Test
    public void test_item_is_book_get_name()
    {
        assertEquals("Chinese Recipe", item_test2.name());
    }

    @Test
    public void test_item_is_collection_get_name()
    {
        assertEquals("All", item_test1.name());
    }

    @Test
    public void test_item_is_book_get_description()
    {
        assertEquals("Food", item_test2.description());
    }

    @Test
    public void test_item_is_collection_get_description()
    {
        assertEquals("Usually use", item_test1.description());
    }

    @Test
    public void test_item_is_book_get_isbn()
    {
        assertEquals("7897897890", item_test2.isbn());
    }

    @Test
    public void test_item_is_collection_get_isbn()
    {
        try{
            item_test1.isbn();
            fail("Illegal Operation");
        }
        catch(RuntimeException e){
            assertEquals("Illegal Operation", e.getMessage());
        }
    }

    @Test
    public void test_item_is_book_get_author()
    {
        assertEquals("Sammi", item_test2.author());
    }

    @Test
    public void test_item_is_collection_get_author()
    {
        try{
            item_test1.isbn();
            fail("Illegal Operation");
        }
        catch(RuntimeException e){
            assertEquals("Illegal Operation", e.getMessage());
        }
    }

    @Test
    public void test_item_is_book_get_size()
    {
        assertEquals(1, item_test2.size());
    }

    @Test
    public void test_item_is_collection_get_size()
    {
        assertEquals(4, item_test1.size());
    }

    @Test
    public void test_item_is_book_get_Iterator()
    {
        Iterator<Item> it = item_test2.iterator();
        try{
            it.next();
            fail("Null iterator does not point to any element");
        }
        catch(NoSuchElementException e){
            assertEquals("Null iterator does not point to any element", e.getMessage());
        }
    }

    @Test
    public void test_item_is_collection_get_Iterator()
    {
        Iterator<Item> it = item_test1.iterator();
        assertTrue(it.hasNext());
        assertEquals(3, it.next().size());
        assertEquals(1, it.next().size());
    }

    @Test
    public void test_item_is_book_accept()
    {
        item_test2.accept(testFindVisitorByName);
        assertEquals("", testFindVisitorByName.getResult());
    }

    @Test
    public void test_item_is_collection_accept()
    {
        item_test1.accept(testFindVisitorByName);
        assertEquals("Book Name: CSS Design\n\tAuthor: Kevin\n\tDescription: HTML + CSS\n\tISBN: 0987654321\n"
        , testFindVisitorByName.getResult());
    }
}
