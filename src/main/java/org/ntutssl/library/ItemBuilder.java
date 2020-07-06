package org.ntutssl.library;

import java.util.Stack;

public class ItemBuilder 
{
    /* Add function you need & do implementation by yourself */
    private Item result;
    private Stack<Collection> collection = new Stack<Collection>();

    public void buildBook(String name, String description, String author, String isbn)
    {
        if (collection.empty())
        {
            result = new Book(name, description, author, isbn);
        }
        else
        {
            collection.peek().add(new Book(name, description, author, isbn));
        }
    }

    public void beginBuildCollection(String name, String description)
    {
        collection.push(new Collection(name, description));
    }

    public void endBuildCollection()
    {
        Collection currentCollection = collection.pop();
        if (collection.empty())
        {
            result = currentCollection;
        }
        else
        {
            collection.peek().add(currentCollection);
        }
    }

    public Item getResult()
    {
		return result;
    }
}