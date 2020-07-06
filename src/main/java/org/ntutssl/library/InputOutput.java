package org.ntutssl.library;

import java.util.ArrayList;

import java.util.Iterator;

import java.util.Scanner;

public class InputOutput {
    public InputOutput() {
    }

    public void printLibraryInstructions() {
        System.out.println("Please enter the instruction as following to manage the library:");
        System.out.println("\t1. 'Add book': to add book to the library");
        System.out.println("\t2. 'Add collection': to add a collection to the library");
        System.out.println("\t3. 'import': import the json file to library.");
        System.out.println("\t4. 'export': export the library to json file.");
        System.out.println("\t5. 'list all': to list the detail of all the items in the library");
        System.out.println("\t6. 'find': to find the item(s) in the library.");
        System.out.println("\t7. 'exit': to exit the program.");
    }

    public void handleLibraryInstructions(String instruction, Library library) {
        if (instruction.equals("Add book")) {
            library.add(addBookInstructions());
        } else if (instruction.equals("Add collection")) {
            library.add(addCollectionInstructions());
        } else if (instruction.equals("import")) {
            importInstructions(library);
        } else if (instruction.equals("export")) {
            exportInstructions(library);
        } else if (instruction.equals("list all")) {
            listBooksInfoDetail(library);
        } else if (instruction.equals("find")) {
            findItems(library);
        } else {
        }
    }

    private Item addBookInstructions() {
        Scanner input = new Scanner(System.in);
        ArrayList<String> inputDetail = new ArrayList<String>();
        System.out.println("Please enter the informations of books:");
        System.out.printf("Name of book: ");
        inputDetail.add(input.nextLine());
        System.out.printf("Description of book: ");
        inputDetail.add(input.nextLine());
        System.out.printf("Author of book: ");
        inputDetail.add(input.nextLine());
        System.out.printf("ISBN of book: ");
        inputDetail.add(input.nextLine());
        Item newItem = new Book(inputDetail.get(0), inputDetail.get(1), inputDetail.get(2), inputDetail.get(3));
        System.out.println("Book" + newItem.name() + " added");
        return newItem;
    }

    private Item addCollectionInstructions() {
        Scanner input = new Scanner(System.in);
        ArrayList<String> inputDetail = new ArrayList<String>();
        System.out.println("Please enter the infomations of collection:");
        System.out.printf("Name of collection: ");
        inputDetail.add(input.nextLine());
        System.out.printf("Description of collection: ");
        inputDetail.add(input.nextLine());
        Collection newCollection = new Collection(inputDetail.get(0), inputDetail.get(1));

        String instruction = new String();
        while (!instruction.equals("exit")) {
            printCollectionInstructions();
            instruction = input.nextLine();
            handleCollectionInstructions(instruction, newCollection);
        }
        Item newItem = newCollection;
        System.out.println("Collection " + newItem.name() + " added");
        return newItem;
    }

    private void printCollectionInstructions() {
        System.out.println("Please enter the instruction as following to manage the collection:");
        System.out.println("\t1. 'Add book': to add book to the collection");
        System.out.println("\t2. 'Add collection': to add a collection to the collection");
        System.out.println("\t3. 'exit': to exit the process.");
    }

    private void handleCollectionInstructions(String instruction, Collection collection) {
        if (instruction.equals("Add book")) {
            collection.add(addBookInstructions());
        } else if (instruction.equals("Add collection")) {
            collection.add(addCollectionInstructions());
        } else {
        }
    }

    private void importInstructions(Library library)
    {
        Scanner input = new Scanner(System.in);
        System.out.printf("Please enter the json file path you want to import: ");
        library.importItems(input.nextLine());
    }

    private void exportInstructions(Library library)
    {
        Scanner input = new Scanner(System.in);
        System.out.printf("Please enter the json file path you want to export: ");
        library.exportItems(input.nextLine());
    }
    
    private void listBooksInfoDetail(Library library)
    {
        String result = "";
        Iterator<Item> it = library.iterator();
        while(it.hasNext())
        {
            ListDetailVisitor listDetailVisitor = new ListDetailVisitor();
            it.next().accept(listDetailVisitor);
            result = result + listDetailVisitor.getResult();
        }
        System.out.printf(result);
    }

    private void findItems(Library library)
    {
        Scanner input = new Scanner(System.in);
        String result;
        System.out.printf("Enter the name of the item to find: ");
        result = library.findByName(input.nextLine());
        System.out.printf(result);
    }
}
