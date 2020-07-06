package org.ntutssl.library;

import java.util.Iterator;

import java.util.Vector;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Library 
{
    private Vector<Item> itemlist = new Vector<Item>();

    public Library(){}

    public void add(Item item) 
    {
        itemlist.add(item);
    }

    public int size() 
    {
        int size = 0;
        Iterator<Item> it = this.iterator();
        while(it.hasNext()){
            size += it.next().size();
        }
        return size;
    }

    public Iterator<Item> iterator() 
    {
        return itemlist.iterator();
    }

    public String findByName(String name)
    {
        String result = "";
        for(Item allItems: itemlist)
        {
            FindVisitorByName findVisitorByName = new FindVisitorByName(name);
            allItems.accept(findVisitorByName);
            result = result + findVisitorByName.getResult();
        }
        return result;
    }

    public void importItems(String path)
    {
        String jsonInputString = null;
        String jsonString = "";
        ItemParser itemParser = new ItemParser();
        try 
        {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            while((jsonInputString = bufferedReader.readLine()) != null) 
            {
                jsonString = jsonString + jsonInputString + "\n";
            }
            Gson gson = new Gson();
            JsonParser jsonParser = new JsonParser();
            Integer itemSize = jsonParser.parse(jsonString).getAsJsonObject().getAsJsonArray("itemlist").size();
            for(int i = 0; i < itemSize; i++)
            {
                JsonObject jsonitem = jsonParser.parse(jsonString).getAsJsonObject().getAsJsonArray("itemlist").get(i).getAsJsonObject();
                String currentItemString = gson.toJson(jsonitem);
                itemParser.parseItem(currentItemString);
                itemlist.add(itemParser.getResult());
            }
        }
        catch (FileNotFoundException e) 
        {
            throw new RuntimeException("File name is not exist");
        }
        catch (IOException e) 
        {
            throw new RuntimeException("File name is not exist");
        }
    }

    public void exportItems(String path)
    {
        if(path.indexOf(".json") == -1)
        {
            path += ".json";
        }
        try
        {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));
            WriteVisitor writeVisitor = new WriteVisitor();
            for(int i = 0; i < itemlist.size(); i++)
            {
                itemlist.get(i).accept(writeVisitor);
                if((itemlist.size() - 1) != i)
                {
                    writeVisitor.nextItem();
                }
            }
            bufferedWriter.write(writeVisitor.getResult());
            bufferedWriter.flush();
        }
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
            throw new RuntimeException("File name is not exist");
        }
        catch (IOException e) 
        {
            e.printStackTrace();
            throw new RuntimeException("File name is not exist");
        }
    }
}
