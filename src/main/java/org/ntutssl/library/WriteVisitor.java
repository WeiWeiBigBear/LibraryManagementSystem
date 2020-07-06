package org.ntutssl.library;

import java.util.Iterator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class WriteVisitor implements Visitor 
{
    private String result;
    Gson gson;

    public WriteVisitor()
    {
        result = "{\"itemlist\": [";
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public void visitBook(Book book)
    {
        result += "{";
        result += "\"type\": \"book\",";
        result += "\"name\": \"" + book.name() + "\",";
        result += "\"description\": \"" + book.description() + "\",";
        result += "\"author\": \"" + book.author() + "\",";
        result += "\"isbn\": \"" + book.isbn() + "\"";
        result += "}";
    }

    @Override
    public void visitCollection(Collection collection)
    {
        result += "{";
        result += "\"type\": \"collection\",";
        result += "\"name\": \"" + collection.name() + "\",";
        result += "\"description\": \"" + collection.description() + "\"";
        Iterator<Item> it = collection.iterator();
        result += ",\"items\": [";
        while(it.hasNext())
        {
            it.next().accept(this);
            if(it.hasNext())
            {
                result += ",";
            }
        }
        result += "]";
        result += "}";
    }

    public void nextItem()
    {
        result += ",";
    }

    public String getResult() 
    {

        result += "]}";
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(result).getAsJsonObject();
        return gson.toJson(jsonObject);
    }
}
