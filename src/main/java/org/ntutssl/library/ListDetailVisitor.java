package org.ntutssl.library;

import java.util.ArrayList;

import java.util.Iterator;

public class ListDetailVisitor implements Visitor 
{
    private ArrayList<Item> items;
    private ArrayList<Integer> index; //所有item層數
    private Integer nowIndex;

    public ListDetailVisitor() 
    {
        items = new ArrayList<Item>();
        index = new ArrayList<Integer>();
        nowIndex = 0;
    }

    @Override
    public void visitBook(Book book) 
    {
        items.add(book);
        storeIndex(nowIndex);
    }

    @Override
    public void visitCollection(Collection collection)
    {
        items.add(collection);
        storeIndex(nowIndex);
        Iterator<Item> it = collection.iterator();
        nowIndex = nowIndex + 1;
        while(it.hasNext())
        {
            it.next().accept(this);
        }
        nowIndex = nowIndex - 1;
    }

    private void storeIndex(Integer index)
    {
        this.index.add(index);
    }

    private String handleOutputResult(String result, int i)
    {
        for(int k = 0; k < this.index.get(i); k++)
        {
            result = result + "\t";
        }
        return result;
    }

    public String getResult() 
    {
        String result = "";
        Integer i = 0;
        for(Item allItem: items)
        {
            if(allItem instanceof Book)
            {
                result = handleOutputResult(result, i);
                result = result + "Book Name: " + allItem.name() + "\n";
                result = handleOutputResult(result, i);
                result = result + "\tAuthor: " + allItem.author() + "\n";
                result = handleOutputResult(result, i);
                result = result + "\tDescription: " + allItem.description() + "\n";
                result = handleOutputResult(result, i);
                result = result + "\tISBN: " + allItem.isbn() + "\n";
                i = i + 1;
            }
            else
            {
                result = handleOutputResult(result, i);
                result = result + "Collection Name: " + allItem.name() + "\n";
                result = handleOutputResult(result, i);
                result = result + "\tDescription: " + allItem.description() + "\n";
                i = i + 1;
            }
        }
        return result;
    }
}
