#pragma once
#include <string>

class Book {
private:
    int id;
    std::string bookTitle;
    std::string author;
    std::string publishing;
    int publicationYear;
    int numOfPages;
    double price;
    std::string cover;

public:
    Book(
        int id,
        std::string bookTitle,
        std::string author,
        std::string publishing,
        int publicationYear,
        int numOfPages,
        double price,
        std::string cover) {
        this->id = id;
        this->bookTitle = bookTitle;
        this->author = author;
        this->publishing = publishing;
        this->publicationYear = publicationYear;
        this->numOfPages = numOfPages;
        this->price = price;
        this->cover = cover;
    }

    std::string toString() {
        return "Book{\n"
            "\tid: " + std::to_string(this->id) + "\n"
            "\tbookTitle: '" + this->bookTitle + "'\n"
            "\tauthor: '" + this->author + "'\n"
            "\tpublishing: '" + this->publishing + "'\n"
            "\tpublicationYear: " + std::to_string(this->publicationYear) + "\n"
            "\tnumOfPages: " + std::to_string(this->numOfPages) + "\n"
            "\tprice: " + std::to_string(this->price) + "\n"
            "\tcover: '" + this->cover + "'\n"
            "}\n";
    }

    int getId() {
        return this->id;
    }

    void setId(int id) {
        this->id = id;
    }

    std::string getBookTitle() {
        return this->bookTitle;
    }

    void setBookTitle(std::string bookTitle) {
        this->bookTitle = bookTitle;
    }

    std::string getAuthor() {
        return this->author;
    }

    void setAuthor(std::string author) {
        this->author = author;
    }

    std::string getPublishing() {
        return this->publishing;
    }

    void setPublishing(std::string publishing) {
        this->publishing = publishing;
    }

    int getPublicationYear() {
        return this->publicationYear;
    }

    void setPublicationYear(int publicationYear) {
        this->publicationYear = publicationYear;
    }

    int getNumOfPages() {
        return this->numOfPages;
    }

    void setNumOfPages(int numOfPages) {
        this->numOfPages = numOfPages;
    }

    double getPrice() {
        return this->price;
    }

    void setPrice(double price) {
        this->price = price;
    }

    std::string getCover() {
        return this->cover;
    }

    void setCover(std::string cover) {
        this->cover = cover;
    }
};