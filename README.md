# Student Task & Assignment Management System

A Java application for students to manage items such as academic tasks, assignments, exams, and study activities using a graphical user interface (GUI). This project demonstrates object-oriented (OOP) principles, inheritance hierarchies, exception handling and Swing GUI dvelopment. It is designed as a final course project and compatible with Eclipse IDE and Visual Studio IDE. 

## Table of Contents
- [Overview](#overview)
- [Key Features](#key-features)
- [Supported Item Types](#supported-item-types)
- [Requirements](#requirements)
- [Getting Started in Eclipse](#getting-started-in-eclipse)
- [How to Use](#how-to-use)
- [UML Diagram](#uml-diagram)
- [Exception Handling](#exception-handlling)
- [Testing Checklist](#testing-checklist)
- [Known Limitations](#known-limitations)
- [Future Enhancements](#future-enhacements)
- [Credits](#credits)
- [License](#license)

## Overview

**Student Task & Assignment Management System** allows students to organize their various types of academic workload by tracking deadlines and monitoring completion status. Each item includes common properties (title, description, due date, completion status) with attributes that are specific depending on the item type selected. The program uses clear GUI components of user interaction and demonstrates OOP structure and event-driven design.

Main Java Concepts illustrated:
- **Inheritance** - Item -> Assignment -> (Homework, Quiz, Project, Exam) and Item -> Task -> (Study, Meeting, Reading)
- **Encapsulation** - Private fields with public getters/setters
- **Polymorphism** - Overriden toString() methods for each item type
- **Exception Handling** - Custom exceptions (DusplicateItemException, ItemNotFound Exception)
- **GUI Development** - Swing-based interface with event-driven programming
- **Input validaton** - Validation performed in mutator methods


## Key Features
1. **Add Item** - Create 7 different types of academic tasks with type-specific attributes
2. **Delete Item** - Remove items by its title
3. **Update Status** - Modify the status of items by its title to either complete or pending
4. **Display All** - Display all items automatically sorted by due date from earliest to latest date
5. **Show Overdue** - Filter and display only incomplete tasks past their due date
6. **Search Item** - Find items by its title (case-insentitive)
7. **Status Indicators** - Visual symbols that indicate the status of items (✓ COMPLETE, ! OVERDUE, ○ PENDING)

## Requirements
- Java development kit (JDK 17)
- IDE such as Visual Studio Code, Eclipse or IntelliJ
- Basic understanding of java and object-oriented programming


## Getting Started in Eclipse
1. Open Eclipse IDE
2. Create a new Java project
3. Import or copy all .java files into the src folder
4. Ensure all items are in the same package
5. Locate ItemManagerFE.java
6. Right-click the file  and select Run As -> Java Application


## How to Use
1. Launch the application
2. Enter title, description, and due date.
3. Select item type.
4. Click **Add Item**.
5. Enter extra attributes when prompted.
6. Use buttons to display, search, delete, or update items.
7. Use **Show Overdue** to view overdue items.

## UML Diagram
The UML Diagram illustrates the class hierarchy and relationships between the components in the system 
- Base Class: Item
- Subclasses:
  - Assignment -> Homework, Quiz, Project, Exam
  - Task -> Study, Meeting, Reading
- Manager class: ItemManager handles storage and operations

## Exception Handling
The program uses a custom exception handling to improve reliability and prevent errors caused by invalid user input.

**Handled exceptions include:**
1. DuplicateItemException - Triggered when adding an item with a title that already exists.
2. ItemNotFoundException - Triggered when deleting or searching for a title not found.
3. IllegalArgumentException - Triggered when values violate class validation rules.
4. NumberFormatException - Triggered when numeric input is entered incorrectly.
5. DateTimeParseException - Triggered when dates are not entered in MM/DD/YYYY format.

All exceptions are handled through dialog messages so the user receives feedback.

## Testing Checklist
1. Program compiles and runs successfully.
2. Add item feature works for all item types.
3. Duplicate titles are rejected.
4. Invalid inputs are handled correctly.
5. Delete feature works.
6. Search feature works.
7. Update status works.
8. Overdue filtering works.
9. GUI updates after each action.

## Known Limitations
**Current limitations of the program include:**

1. Data is not permanently saved after closing the program.
3. Editing existing item details is not supported directly.
4. GUI layout uses absolute positioning and may not resize perfectly.
5. Search only matches exact titles (case-insensitive).
6. No notification or reminder system is included.

These limitations can be improved in future versions.

## Future Enhancements
1. Save/load data from file
2. Better GUI layout
3. Edit existing items
4. Assignment grade feature
5. Average total grade feature
6. Notifications/reminders

## Credits
1. Developed by: Group 7 - Helen Yang, Rija Aziz, Gia-Minh Bui, Linda Orozco
2. Instructor: Dr. Jiang (Jin) Wang
3. Course: CSE 1325 - Object-Oriented Programming

## License
For educational use only.
