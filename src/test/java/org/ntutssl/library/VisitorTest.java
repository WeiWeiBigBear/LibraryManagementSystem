package org.ntutssl.library;

import static org.junit.Assert.*;

import com.google.gson.*;

import org.junit.Before;

import org.junit.Test;

public class VisitorTest 
{
    FindVisitorByName testFindVisitorByName;
    ListDetailVisitor testListDetailVisitor;
    WriteVisitor testWriteVisitorTest;
    Book book_test1;
    Book book_test2;
    Book book_test3;
    Book book_test4;
    Collection collection_test1;
    Collection collection_test2;
    Collection collection_test3;
    Collection collection_test4;
    Collection collection_test5;
    Gson gson;
    JsonParser jsonParser;
    JsonObject jsonObject;
    String result;

    @Before // executed just before every @Test
    public void setUp() {
        testFindVisitorByName = new FindVisitorByName("CSS Design");
        testListDetailVisitor = new ListDetailVisitor();
        jsonParser = new JsonParser();
        jsonObject = new JsonObject();
        gson = new GsonBuilder().setPrettyPrinting().create();
        result = "";
        testWriteVisitorTest = new WriteVisitor();
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
    public void test_vistor_is_FindVisitorByName_vistBook()
    {
        book_test2.accept(testFindVisitorByName);
        assertEquals("Book Name: CSS Design\n\tAuthor: Kevin\n\tDescription: HTML + CSS\n\tISBN: 0987654321\n"
        , testFindVisitorByName.getResult());
    }
    
    @Test
    public void test_vistor_is_FindVisitorByName_visitCollection()
    {
        collection_test1.accept(testFindVisitorByName);
        assertEquals("Book Name: CSS Design\n\tAuthor: Kevin\n\tDescription: HTML + CSS\n\tISBN: 0987654321\n"
        , testFindVisitorByName.getResult());
    }

    @Test
    public void test_vistor_is_WriteVisitor_vistBook()
    {
        book_test2.accept(testWriteVisitorTest);
        result = "{\"itemlist\":[{\"type\":\"book\",\"name\":\"CSS Design\",\"description\":\"HTML + CSS\",\"author\":\"Kevin\",\"isbn\":\"0987654321\"}]}";
        jsonObject = jsonParser.parse(result).getAsJsonObject();
        result = gson.toJson(jsonObject);
        assertEquals(result, testWriteVisitorTest.getResult());
    }

    @Test
    public void test_vistor_is_WriteVisitor_visitCollection()
    {
        collection_test1.accept(testWriteVisitorTest);
        result = "{\"itemlist\":[{\"type\":\"collection\",\"name\":\"All\",\"description\":\"Usually use\",\"items\":[{\"type\":\"book\",\"name\":\"CSS Design\",\"description\":\"HTML + CSS\",\"author\":\"Kevin\",\"isbn\":\"0987654321\"},{\"type\":\"book\",\"name\":\"Python Nice\",\"description\":\"Python\",\"author\":\"Nancy\",\"isbn\":\"1231231230\"}]}]}";
        jsonObject = jsonParser.parse(result).getAsJsonObject();
        result = gson.toJson(jsonObject);
        assertEquals(result, testWriteVisitorTest.getResult());
    }

    @Test
    public void test_vistor_is_ListDetailVisitor_vistBook()
    {
        book_test2.accept(testListDetailVisitor);
        assertEquals("Book Name: CSS Design\n\tAuthor: Kevin\n\tDescription: HTML + CSS\n\tISBN: 0987654321\n"
        , testListDetailVisitor.getResult());
    }
    
    @Test
    public void test_vistor_is_ListDetailVisitor_visitCollection()
    {
        collection_test1.accept(testListDetailVisitor);
        assertEquals("Collection Name: All\n\tDescription: Usually use\n\tBook Name: CSS Design\n\t\tAuthor: Kevin\n\t\tDescription: HTML + CSS\n\t\tISBN: 0987654321\n\tBook Name: Python Nice\n\t\tAuthor: Nancy\n\t\tDescription: Python\n\t\tISBN: 1231231230\n"
        , testListDetailVisitor.getResult());
    }
}