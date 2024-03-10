#include <iostream>
#include <vector>
#include <algorithm>
#include <conio.h>
#include <string>
#include "Book.h"

std::vector<Book> bookList;

int yearCheck() {
    char ch = '\0';
    int result = 0;
    bool yearIsOk = false;
    std::string year = "";
    do {
        while (ch != '\n') {
            ch = getch();
            if (isdigit(ch)) {
                year = +ch;
                std::cout << year << std::endl;
            }
            else {
                continue;
            }
        }

        result = atoi(year.c_str());

        while (yearIsOk == false) {
            int yearLength = 0;
            std::cout << "Enter year: ";
            int tempYear = result;
            while (tempYear) {
                tempYear /= 10;
                ++yearLength;
                if (yearLength > 4 || result > 2024) {
                    yearIsOk = false;
                }
                else {
                    yearIsOk = true;
                }
            }
        }
    } while (yearIsOk == false);

    
    return result;
}

void printBooksByAuthor(std::string author) {
    for (Book& book : bookList) {
        if (book.getAuthor() == author) {
            std::cout << book.toString() << std::endl;
        }
    }
}

void printBookByPublishing(std::string publishing) {
    for (Book& book : bookList) {
        if (book.getPublishing() == publishing) {
            std::cout << book.toString() << std::endl;
        }
    }
}

void printBooksPublishedAfter(int publicationYear) {
    for (Book& book : bookList) {
        if (book.getPublicationYear() > publicationYear) {
            std::cout << book.toString() << std::endl;
        }
    }
}

void printBookList() {
    for (Book& book : bookList) {
        std::cout << book.toString() << std::endl;
    }
}

void addBook() {
    int id;
    std::string bookTitle;
    std::string author;
    std::string publishing;
    int publicationYear;
    int numOfPages;
    double price;
    std::string cover;

    std::cout << "Enter book id: ";
    std::cin >> id;
    std::cout << "Enter book title: ";
    std::cin >> bookTitle;
    std::cout << "Enter author: ";
    std::cin >> author;
    std::cout << "Enter publishing: ";
    std::cin >> publishing;
    std::cout << "Enter publication year: ";
    publicationYear = yearCheck();
    std::cout << "Enter number of pages: ";
    std::cin >> numOfPages;
    std::cout << "Enter price: ";
    std::cin >> price;
    std::cout << "Enter cover type: ";
    std::cin >> cover;

    bookList.push_back(Book(id,bookTitle, author, publishing, publicationYear, numOfPages, price, cover));
}

void menu() {
    int choice;
    do {
        std::cout << "\nMenu:\n";
        std::cout << "0. Print bookList\n";
        std::cout << "1. Print books by author\n";
        std::cout << "2. Print books by publishing\n";
        std::cout << "3. Print books published after a certain year\n";
        std::cout << "4. Add a book\n";
        std::cout << "5. Exit\n";
        std::cout << "Enter your choice: ";
        std::cin >> choice;

        switch (choice) {
        case 0: {
            printBookList();
            break;
        }
        case 1: {
            std::string author;
            std::cout << "Enter author: ";
            std::cin >> author;
            printBooksByAuthor(author);
            break;
        }
        case 2: {
            std::string publishing;
            std::cout << "Enter publishing: ";
            std::cin >> publishing;
            printBookByPublishing(publishing);
            break;
        }
        case 3: {
            int year = 0;
            year = yearCheck();
            printBooksPublishedAfter(year);
            break;
        }
        case 4: {
            addBook();
            break;
        }
        case 5:
            std::cout << "Exiting...\n";
            break;
        default:
            std::cout << "Invalid choice. Please try again.\n";
        }
    } while (choice != 5);
}

int main() {
    menu();
    return 0;
}
