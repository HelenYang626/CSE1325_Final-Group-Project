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
- **GUI Development** - Swing-based interfacfe with event-driven programming
- **Input validaton** - Validation performed in mutator methods


## Key Features
- **Add Items**: Create different types of academic tasks with type-specific attributes
- **Delete Items**: Remove tasks by title
- **Update Status**: Mark tasks as complete or pending
- **Display All**: View all tasks sorted by due date
- **Show Overdue**: Display only incomplete tasks past their due date
- **Search**: Find items by title (case-insentitive)
