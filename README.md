# Library Management System

## Design Patterns
- Composite Pattern
- Iterator Pattern
- Visitor Pattern
- Bulider and Parser Pattern

## How To Run The Program?
#### 1. Run program(Main.java):
```
$ mvn exec:java -Dexec.mainClass="org.ntutssl.library.Main"
Please enter the instruction as following to manage the library:
        1. 'Add book': to add book to the library
        2. 'Add collection': to add a collection to the library  
        3. 'import': import the json file to library.
        4. 'export': export the library to json file.
        5. 'list all': to list the detail of all the items in the library
        6. 'find': to find the item(s) in the library.
        7. 'exit': to exit the program.
```

#### 2. Enter instruction: `import` (Library)
```
Please enter the json file path you want to import: ./test_data/sample_data.json
Please enter the instruction as following to manage the library:
        1. 'Add book': to add book to the library
        2. 'Add collection': to add a collection to the library
        3. 'import': import the json file to library.
        4. 'export': export the library to json file.
        5. 'list all': to list the detail of all the items in the library
        6. 'find': to find the item(s) in the library.
        7. 'exit': to exit the program.
```

#### 3. Enter instruction: `list all`
```
Book Name: Design Patterns
        Author: Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides
        Description: This is a book discuss about 23 patterns of software designs.
        ISBN: 0201633612
Collection Name: Agile
        Description: This collection contains all books about agile.
        Book Name: Learning Agile: Understanding Scrum, XP, Lean, and Kanban
                Author: Andrew Stellman, Jennifer Greene
                Description: Learning Agile is a comprehensive guide to the most popular agile methods, written in a light and engaging style that makes it easy for you to learn.
                ISBN: 1449331920
        Collection Name: Design Patterns
                Description: This collection contains all books about patterns.
                Book Name: A Pattern Language: Towns, Buildings, Construction (Hardcover)
                        Author: Christopher Alexander
                        Description: This article is about the structured design approach by architect Christopher Alexander.
                        ISBN: 0195019199
                Book Name: Design Patterns
                        Author: Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides
                        Description: This is a book discuss about 23 patterns of software designs(2nd edition).
                        ISBN: 0201633613
Please enter the instruction as following to manage the library:
        1. 'Add book': to add book to the library
        2. 'Add collection': to add a collection to the library
        3. 'import': import the json file to library.
        4. 'export': export the library to json file.
        5. 'list all': to list the detail of all the items in the library
        6. 'find': to find the item(s) in the library.
        7. 'exit': to exit the program.
```

#### 4. Enter instruction: `Add book`
```
Please enter the infomations of books:
Name of book: new book
Description of book: new
Author of book: new
ISBN of book: 9999
Book new book added
Please enter the instruction as following to manage the library:
        1. 'Add book': to add book to the library
        2. 'Add collection': to add a collection to the library  
        3. 'import': import the json file to library.
        4. 'export': export the library to json file.
        5. 'list all': to list the detail of all the items in the library
        6. 'find': to find the item(s) in the library.
        7. 'exit': to exit the program.
```

#### 5. Enter instruction: `list all`
```
Book Name: Design Patterns
        Author: Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides
        Description: This is a book discuss about 23 patterns of software designs.
        ISBN: 0201633612
Collection Name: Agile
        Description: This collection contains all books about agile.
        Book Name: Learning Agile: Understanding Scrum, XP, Lean, and Kanban
                Author: Andrew Stellman, Jennifer Greene
                Description: Learning Agile is a comprehensive guide to the most popular agile methods, written in a light and engaging style that makes it easy for you to learn.
                ISBN: 1449331920
        Collection Name: Design Patterns
                Description: This collection contains all books about patterns.
                Book Name: A Pattern Language: Towns, Buildings, Construction (Hardcover)
                        Author: Christopher Alexander
                        Description: This article is about the structured design approach by architect Christopher Alexander.
                        ISBN: 0195019199
                Book Name: Design Patterns
                        Author: Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides
                        Description: This is a book discuss about 23 patterns of software designs(2nd edition).
                        ISBN: 0201633613
Book Name: new book
        Author: new
        Description: new
        ISBN: 9999
Please enter the instruction as following to manage the library:
        1. 'Add book': to add book to the library
        2. 'Add collection': to add a collection to the library
        3. 'import': import the json file to library.
        4. 'export': export the library to json file.
        5. 'list all': to list the detail of all the items in the library
        6. 'find': to find the item(s) in the library.
        7. 'exit': to exit the program.
```

## 6. Enter instruction: `Add collection` (Library)
```
Please enter the infomations of collection:
Name of collection: Agile
Description of collection: This collection contains all books about agile.
Please enter the instruction as following to manage the collection:
        1. 'Add book': to add book to the collection
        2. 'Add collection': to add a collection to the collection
        3. 'exit': to exit the process.
```

### 6-1. Enter instruction: `Add book` (Collection1)
```
Please enter the infomations of books:
Name of book: Learning Agile: Understanding Scrum, XP, Lean, and Kanban
Description of book: Learning Agile is a comprehensive guide to the most popular agile methods, written in a light and engaging style that makes it easy for you to learn.
Author of book: Andrew Stellman, Jennifer Greene
ISBN of book: 1449331920
Book Learning Agile: Understanding Scrum, XP, Lean, and Kanban added
Please enter the instruction as following to manage the collection:
        1. 'Add book': to add book to the collection
        2. 'Add collection': to add a collection to the collection
        3. 'exit': to exit the process.
```

### 6-2. Enter instruction: `Add collection` (Collection1)
```
Please enter the infomations of collection:
Name of collection: Design Patterns
Description of collection: This collection contains all books about patterns.
Please enter the instruction as following to manage the collection:
        1. 'Add book': to add book to the collection
        2. 'Add collection': to add a collection to the collection
        3. 'exit': to exit the process.
```

### 6-2-1. Enter instruction: `Add book` (Collection2)
```
Please enter the infomations of books:
Name of book: A Pattern Language: Towns, Buildings, Construction (Hardcover)
Description of book: This article is about the structured design approach by architect Christopher Alexander.
Author of book: Christopher Alexander
ISBN of book: 0195019199
Book A Pattern Language: Towns, Buildings, Construction (Hardcover) added
Please enter the instruction as following to manage the collection:
        1. 'Add book': to add book to the collection
        2. 'Add collection': to add a collection to the collection
        3. 'exit': to exit the process.
```

### 6-2-2. Enter instruction: `Add book` (Collection2)
```
Please enter the infomations of books:
Name of book: Design Patterns
Description of book: This is a book discuss about 23 patterns of software designs(2nd edition).
Author of book: Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides
ISBN of book: 0201633613
Book Design Patterns added
Please enter the instruction as following to manage the collection:
        1. 'Add book': to add book to the collection
        2. 'Add collection': to add a collection to the collection
        3. 'exit': to exit the process.
```

### 6-2-3. Enter instruction: `exit` (Collection2)
```
Collection Scrum added
Please enter the instruction as following to manage the collection:
        1. 'Add book': to add book to the collection
        2. 'Add collection': to add a collection to the collection
        3. 'exit': to exit the process.
```

### 6-3. Enter instruction: `exit` (Collection1)
```
Collection Agile added
Please enter the instruction as following to manage the library:
        1. 'Add book': to add book to the library
        2. 'Add collection': to add a collection to the library
        3. 'import': import the json file to library.
        4. 'export': export the library to json file.
        5. 'list all': to list the detail of all the items in the library
        6. 'find': to find the item(s) in the library.
        7. 'exit': to exit the program.
```

## 7. Enter instruction: `list all`
```
Book Name: Design Patterns
        Author: Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides
        Description: This is a book discuss about 23 patterns of software designs.
        ISBN: 0201633612
Collection Name: Agile
        Description: This collection contains all books about agile.
        Book Name: Learning Agile: Understanding Scrum, XP, Lean, and Kanban
                Author: Andrew Stellman, Jennifer Greene
                Description: Learning Agile is a comprehensive guide to the most popular agile methods, written in a light and engaging style that makes it easy for you to learn.
                ISBN: 1449331920
        Collection Name: Design Patterns
                Description: This collection contains all books about patterns.
                Book Name: A Pattern Language: Towns, Buildings, Construction (Hardcover)
                        Author: Christopher Alexander
                        Description: This article is about the structured design approach by architect Christopher Alexander.
                        ISBN: 0195019199
                Book Name: Design Patterns
                        Author: Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides
                        Description: This is a book discuss about 23 patterns of software designs(2nd edition).
                        ISBN: 0201633613
Book Name: new book
        Author: new
        Description: new
        ISBN: 9999
Collection Name: Agile
        Description: This collection contains all books about agile.
        Book Name: Learning Agile: Understanding Scrum, XP, Lean, and Kanban
                Author: Andrew Stellman, Jennifer Greene
                Description: Learning Agile is a comprehensive guide to the most popular agile methods, written in a light and engaging style that makes it easy for you to learn.
                ISBN: 1449331920
        Collection Name: Design Patterns
                Description: This collection contains all books about patterns.
                Book Name:  A Pattern Language: Towns, Buildings, Construction (Hardcover)
                        Author: Christopher Alexander
                        Description: This article is about the structured design approach by architect Christopher Alexander.
                        ISBN: 0195019199
                Book Name:  Design Patterns
                        Author: Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides
                        Description: This is a book discuss about 23 patterns of software designs(2nd edition).
                        ISBN: 0201633613
Please enter the instruction as following to manage the library:
        1. 'Add book': to add book to the library
        2. 'Add collection': to add a collection to the library
        3. 'import': import the json file to library.
        4. 'export': export the library to json file.
        5. 'list all': to list the detail of all the items in the library
        6. 'find': to find the item(s) in the library.
        7. 'exit': to exit the program.
```
#### 8. Enter instruction: `find`
```
Enter the name of the item to find: new book
Book Name: new book
        Author: new
        Description: new
        ISBN: 9999
Please enter the instruction as following to manage the library:
        1. 'Add book': to add book to the library
        2. 'Add collection': to add a collection to the library
        3. 'import': import the json file to library.
        4. 'export': export the library to json file.
        5. 'list all': to list the detail of all the items in the library
        6. 'find': to find the item(s) in the library.
        7. 'exit': to exit the program.
```

#### 9. Enter instruction: `export`
```
Please enter the json file path you want to export: ./test_data/sample_output.json
Please enter the instruction as following to manage the library:
        1. 'Add book': to add book to the library
        2. 'Add collection': to add a collection to the library
        3. 'import': import the json file to library.
        4. 'export': export the library to json file.
        5. 'list all': to list the detail of all the items in the library
        6. 'find': to find the item(s) in the library.
        7. 'exit': to exit the program.
```

#### In `./test_data/sample_output.json`
```
{
  "itemlist": [
    {
      "type": "book",
      "name": "Design Patterns",
      "description": "This is a book discuss about 23 patterns of software designs.",
      "author": "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides",
      "isbn": "0201633612"
    },
    {
      "type": "collection",
      "name": "Agile",
      "description": "This collection contains all books about agile.",
      "items": [
        {
          "type": "book",
          "name": "Learning Agile: Understanding Scrum, XP, Lean, and Kanban",
          "description": "Learning Agile is a comprehensive guide to the most popular agile methods, written in a light and engaging style that makes it easy for you to learn.",
          "author": "Andrew Stellman, Jennifer Greene",
          "isbn": "1449331920"
        },
        {
          "type": "collection",
          "name": "Design Patterns",
          "description": "This collection contains all books about patterns.",
          "items": [
            {
              "type": "book",
              "name": "A Pattern Language: Towns, Buildings, Construction (Hardcover)",
              "description": "This article is about the structured design approach by architect Christopher Alexander.",
              "author": "Christopher Alexander",
              "isbn": "0195019199"
            },
            {
              "type": "book",
              "name": "Design Patterns",
              "description": "This is a book discuss about 23 patterns of software designs(2nd edition).",
              "author": "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides",
              "isbn": "0201633613"
            }
          ]
        }
      ]
    },
    {
      "type": "book",
      "name": "new book",
      "description": "new",
      "author": "new",
      "isbn": "9999"
    },
    {
      "type": "collection",
      "name": "Agile",
      "description": "This collection contains all books about agile.",
      "items": [
        {
          "type": "book",
          "name": "Learning Agile: Understanding Scrum, XP, Lean, and Kanban",
          "description": "Learning Agile is a comprehensive guide to the most popular agile methods, written in a light and engaging style that makes it easy for you to learn.",
          "author": "Andrew Stellman, Jennifer Greene",
          "isbn": "1449331920"
        },
        {
          "type": "collection",
          "name": "Design Patterns",
          "description": "This collection contains all books about patterns.",
          "items": [
            {
              "type": "book",
              "name": "A Pattern Language: Towns, Buildings, Construction (Hardcover)",
              "description": "This article is about the structured design approach by architect Christopher Alexander.",
              "author": "Christopher Alexander",
              "isbn": "0195019199"
            },
            {
              "type": "book",
              "name": "Design Patterns",
              "description": "This is a book discuss about 23 patterns of software designs(2nd edition).",
              "author": "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides",
              "isbn": "0201633613"
            }
          ]
        }
      ]
    }
  ]
}
```

#### 10. Enter instruction: `exit` to terminate the program

## File Structure

```
├── pom.xml
├── src
│   ├── main
│   │   └── java
│   │       └── org
│   │           └── ntutssl
│   │               └── library
│   │                   ├── Book.java
│   │                   ├── Collection.java
│   │                   ├── FindVisitorByName.java
│   │                   ├── InputOutput.java
│   │                   ├── ItemBuilder.java
│   │                   ├── Item.java
│   │                   ├── ItemParser.java
│   │                   ├── Library.java
│   │                   ├── ListDetailVisitor.java
│   │                   ├── Main.java
│   │                   ├── NullIterator.java
│   │                   ├── Readable.java
│   │                   ├── Visitor.java
│   │                   └── WriteVisitor.java
│   └── test
│       └── java
│           └── org
│               └── ntutssl
│                   └── library
│                       ├── BookTest.java
│                       ├── CollectionTest.java
│                       ├── FindVisitorByNameTest.java
│                       ├── ItemParserTest.java
│                       ├── ItemTest.java
│                       ├── LibraryTest.java
│                       ├── ListDetailVisitorTest.java
│                       ├── NullIteratorTest.java
│                       └── WriteVisitorTest.java
└── test_data
    └── sample_data.json
```