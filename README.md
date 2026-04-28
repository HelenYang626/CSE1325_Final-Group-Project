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

## Supported Item Types
| Type | Attributes | Validation Rules |
| **Homework** | Max points, weight, page count, problem count | Points > 0, 0 < weight <= 1.0, pages >= 1, problems >= 1|
| **Quiz** | Max points, weight, time limit, question count | Points > 0, 0 < weight <= 1.0, time >= 1 minute, questions >= 1|
| **Project**| Max points, weight, group size, has presentation | Points > 0, 0 < weight <= 1.0, group size >= 1, present is true or false
| **Exam** | Max points, weight, duration, location | Points > 0, 0 < weight <= 1.0, duration >= 0, location non-empty |
| **Study** | Estimated hours, location | Hours > 0, location non-empty |
| **Meeting** | Estimated hours, location | Hours > 0, location non-empty |
| **Reading** | Estimated hours, pages | Hours > 0, pages >=1 |


## Requirements


## Getting Started in Eclipse


## How to Use


## UML Diagram


## Exception Handling


## Testing Checklist


## Known Limitations


## Future Enhancements


## Credits


## License