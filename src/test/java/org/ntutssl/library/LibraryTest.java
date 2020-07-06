package org.ntutssl.library;

import static org.junit.Assert.*;

import java.util.Iterator;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.junit.Before;

import org.junit.Test;

public class LibraryTest 
{
    Library library_test1;
    Library library_test2;
    Library library_test3;
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
        library_test1 = new Library();
        library_test2 = new Library();
        library_test3 = new Library();
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
        library_test1.add(collection_test3);
        library_test1.add(book_test5);
        library_test2.add(book_test2);
    }

    @Test
    public void test_library_add_book()
    {
        library_test1.add(book_test1);
        assertEquals(6, library_test1.size());
    }

    @Test
    public void test_library_add_collection_has_book()
    {
        library_test1.add(collection_test3);
        assertEquals(9, library_test1.size());
    }
    @Test
    public void test_library_add_collection_no_book()
    {
        library_test1.add(collection_test5);
        assertEquals(5, library_test1.size());
    }

    @Test
    public void test_library_get_size()
    {
        assertEquals(5, library_test1.size());
    }

    @Test
    public void test_library_get_Iterator()
    {
        Iterator<Item> it = library_test1.iterator();
        assertTrue(it.hasNext());
        assertEquals(4, it.next().size());
        assertEquals(1, it.next().size());
    }

    @Test
    public void test_library_findName()
    {
        assertEquals("Book Name: CSS Design\n\tAuthor: Kevin\n\tDescription: HTML + CSS\n\tISBN: 0987654321\n"
        , library_test1.findByName("CSS Design"));
    }

    @Test
    public void test_library_import()
    {
        try{
            library_test2.importItems("QQ");
            fail("File name is not exist");
        }
        catch(RuntimeException e){
            assertEquals("File name is not exist", e.getMessage());
        }
    }

    @Test
    public void test_library_export()
    {
        String library_test2_result = "";
        String library_test3_result = "";
        library_test2.exportItems("test_data" + (char)Integer.parseInt("92") + "test_data.json");
        library_test3.importItems("test_data" + (char)Integer.parseInt("92") + "test_data.json");
        Iterator<Item> it = library_test2.iterator();
        while(it.hasNext())
        {
            ListDetailVisitor listDetailVisitor = new ListDetailVisitor();
            it.next().accept(listDetailVisitor);
            library_test2_result = library_test2_result + listDetailVisitor.getResult();
        }
        it = library_test3.iterator();
        while(it.hasNext())
        {
            ListDetailVisitor listDetailVisitor = new ListDetailVisitor();
            it.next().accept(listDetailVisitor);
            library_test3_result = library_test3_result + listDetailVisitor.getResult();
        }
        assertEquals(library_test3_result, library_test2_result);
    }
}
