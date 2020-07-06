package org.ntutssl.library;

import java.util.ArrayList;

import java.util.Iterator;

public class FindVisitorByName implements Visitor 
{
    private ArrayList<Item> items;
    private String name;

    public FindVisitorByName(String name)
    {
        items = new ArrayList<Item>();
        this.name = name;
    }

    @Override
    public void visitBook(Book book) 
    {
        if(book.name().equals(name))
        {
            items.add(book);
        }
    }

    @Override
    public void visitCollection(Collection collection) 
    { 
        if(collection.name().equals(name))
        {
            items.add(collection);
        }
        Iterator<Item> it = collection.iterator();
        while(it.hasNext())
        {
            it.next().accept(this);
        }
    }

    public String getResult() 
    {
        String result = "";
        for(Item allItem: items)
        {
            if(allItem instanceof Book)
            {
                result = result + "Book Name: " + allItem.name() + "\n";
                result = result + "\tAuthor: " + allItem.author() + "\n";
                result = result + "\tDescription: " + allItem.description() + "\n";
                result = result + "\tISBN: " + allItem.isbn() + "\n";
            }
            else
            {
                result = result + "Collection Name: " + allItem.name() + "\n";
                result = result + "\tDescription: " + allItem.description() + "\n";
            }
        }
        return result;
    }
}
