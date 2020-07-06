package org.ntutssl.library;

import static org.junit.Assert.assertEquals;

import org.junit.Before;

import org.junit.Test;

public class BookTest 
{
    Book book_test;

    @Before // executed just before every @Test
    public void setUp()
    {
        book_test = new Book("Computer Science", "Computer great!", "John", "1234567890");
    }
    @Test
    public void test_book_name()
    {
        assertEquals("Computer Science", book_test.name());
    }

    @Test
    public void test_book_description()
    {
        assertEquals("Computer great!", book_test.description());
    }

    @Test
    public void test_book_author()
    {
        assertEquals("John", book_test.author());
    }

    @Test
    public void test_book_isbn()
    {
        assertEquals("1234567890", book_test.isbn());
    }

    @Test
    public void test_book_size()
    {
        assertEquals(1, book_test.size());
    }

    @Test
    public void test_book_accept()
    {
        FindVisitorByName testFindVisitorByName = new FindVisitorByName("Computer Science");
        book_test.accept(testFindVisitorByName);
        assertEquals("Book Name: Computer Science\n\tAuthor: John\n\tDescription: Computer great!\n\tISBN: 1234567890\n"
        , testFindVisitorByName.getResult());
    }
}
