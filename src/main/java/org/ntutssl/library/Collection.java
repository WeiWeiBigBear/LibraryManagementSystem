package org.ntutssl.library;

import java.util.Iterator;

import java.util.Vector;

public class Collection extends Readable
{
    private String name;
    private String description;
    private Vector<Item> items;

    public Collection (String name, String description)
    {
        this.name = name;
        this.description = description;
        items = new Vector<Item>();
    }

    public String name()
    {
        return name;
    }

    public String description()
    {
        return description;
    }

    @Override
    public void add(Item item)
    {
        items.add(item);
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

    @Override
    public Iterator<Item> iterator()
    {
        return items.iterator();
    }

    @Override
    public void accept(Visitor visitor)
    {
        visitor.visitCollection(this);
    }
}
