package org.ntutssl.library;

public class Book extends Readable
{
    private String name;
    private String description;
    private String author;
    private String isbn;

    public Book (String name, String description, String author, String isbn)
    {
        this.name = name;
        this.description = description;
        this.author = author;
        this.isbn = isbn;
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
    public String author()
    {
        return author;
    }

    @Override
    public String isbn()
    {
        return isbn;
    }

    public int size()
    {
        return 1;
    }

    @Override
    public void accept(Visitor visitor)
    {
        visitor.visitBook(this);
    }
}
