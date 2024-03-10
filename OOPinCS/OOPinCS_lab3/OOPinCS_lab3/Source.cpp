#include <iostream>
#include <fstream>
#include <sstream>
#include <string>
#include <vector>
#include <algorithm>

std::string readFile(const std::string& filename) {
    std::ifstream file(filename);
    std::stringstream buffer;
    buffer << file.rdbuf();
    return buffer.str();
}

std::string encrypt(const std::string& content) {
    std::string result;
    for (char c : content) {
        result += static_cast<char>(c + 5);
    }
    return result;
}

std::string insertWordAfterSubstring(const std::string& textFromFile, const std::string& substring, const std::string& wordToInsert) {
    std::string result = textFromFile;
    size_t pos = result.find(substring);
    while (pos != std::string::npos) {
        result.insert(pos + substring.size(), " " + wordToInsert);
        pos = result.find(substring, pos + substring.size() + wordToInsert.size() + 1);
    }
    return result;
}

int main() {
    try {
        std::string content = readFile("lab3.txt");
        std::string replaceString;
        std::string substring;
        std::cout << "Enter substring to replace: ";
        std::cin >> substring;
        std::cout << "Enter string to replace substring: ";
        std::cin >> replaceString;
        std::string resultContent = insertWordAfterSubstring(content, substring, replaceString);
        std::cout << content;
        std::cout << "\n============================================================================\n";
        std::cout << resultContent;
        std::ofstream fos("resultLab3.txt");
        resultContent = encrypt(resultContent);
        fos << resultContent;
        fos.close();
        //std::cout << "\n============================================================================\n";
        //std::string str = readFile("resultLab3.txt");
        //std::cout << str << std::endl;
    }
    catch (const std::exception& e) {
        std::cerr << e.what() << std::endl;
    }
    return 0;
}
