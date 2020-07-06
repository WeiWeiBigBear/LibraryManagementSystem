package org.ntutssl.library;

import static org.junit.Assert.*;

import com.google.gson.*;

import org.junit.Before;

import org.junit.Test;

public class ItemParserTest
{
    ItemParser testItemParser;
    Book book_test1;
    Book book_test2;
    Book book_test3;
    Book book_test4;
    Collection collection_test1;
    Collection collection_test2;
    Collection collection_test3;
    Collection collection_test4;
    Collection collection_test5;
    String jsonString;
    Gson gson;
    JsonParser jsonParser;
    JsonObject jsonObject;

    @Before // executed just before every @Test
    public void setUp() {
        jsonString = "";
        testItemParser = new ItemParser();
        jsonParser = new JsonParser();
        jsonObject = new JsonObject();
        gson = new GsonBuilder().setPrettyPrinting().create();
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
    public void test_itemParser_paresItem_is_book()
    {
        jsonString = "{\"type\":\"book\",\"name\":\"CSS Design\",\"description\":\"HTML + CSS\",\"author\":\"Kevin\",\"isbn\":\"0987654321\"}";
        testItemParser.parseItem(jsonString);
        assertEquals(gson.toJson(book_test2), gson.toJson(testItemParser.getResult()));
    }

    @Test
    public void test_itemParser_paresItem_is_collection()
    {
        jsonString = "{\"type\":\"collection\",\"name\":\"All\",\"description\":\"Usually use\",\"items\":[{\"type\":\"book\",\"name\":\"CSS Design\",\"description\":\"HTML + CSS\",\"author\":\"Kevin\",\"isbn\":\"0987654321\"},{\"type\":\"book\",\"name\":\"Python Nice\",\"description\":\"Python\",\"author\":\"Nancy\",\"isbn\":\"1231231230\"}]}";
        testItemParser.parseItem(jsonString);
        assertEquals(gson.toJson(collection_test1), gson.toJson(testItemParser.getResult()));
    }

    @Test
    public void test_itemParser_getResult_is_book()
    {
        jsonString = "{\"type\":\"book\",\"name\":\"CSS Design\",\"description\":\"HTML + CSS\",\"author\":\"Kevin\",\"isbn\":\"0987654321\"}";
        testItemParser.parseItem(jsonString);
        assertEquals(gson.toJson(book_test2), gson.toJson(testItemParser.getResult()));
    }

    @Test
    public void test_itemParser_getResult_is_collection()
    {
        jsonString = "{\"type\":\"collection\",\"name\":\"All\",\"description\":\"Usually use\",\"items\":[{\"type\":\"book\",\"name\":\"CSS Design\",\"description\":\"HTML + CSS\",\"author\":\"Kevin\",\"isbn\":\"0987654321\"},{\"type\":\"book\",\"name\":\"Python Nice\",\"description\":\"Python\",\"author\":\"Nancy\",\"isbn\":\"1231231230\"}]}";
        testItemParser.parseItem(jsonString);
        assertEquals(gson.toJson(collection_test1), gson.toJson(testItemParser.getResult()));
    }
}