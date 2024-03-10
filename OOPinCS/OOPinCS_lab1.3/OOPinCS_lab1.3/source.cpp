#include <iostream>
#include <vector>

int main() {
    std::cout << "Enter n:";
    int size;
    std::cin >> size;

    std::vector<int> array(size);

    std::cout << "Enter " << size << " numbers:\n";
    for (int i = 0; i < array.size()-1; i++) {
        int data = 0;
        std::cin >> data;
        array.push_back(data);
    }

    int evenDigitNumbers = 0;
    int equalEvenOddDigitNumbers = 0;

    for (int num : array) {
        int evenDigits = 0;
        int oddDigits = 0;
        while (num > 0) {
            int digit = num % 10;
            if (digit % 2 == 0) {
                evenDigits++;
            }
            else {
                oddDigits++;
            }
            num /= 10;
        }
        if (evenDigits == oddDigits) {
            equalEvenOddDigitNumbers++;
            std::cout << num;
        }
        if (oddDigits == 0) {
            evenDigitNumbers++;
        }
    }

    std::cout << "Number of digits which contain only even digits: " << evenDigitNumbers << "\n";
    std::cout << "Number of digits which contain equal even and odd digits number: " << equalEvenOddDigitNumbers << "\n";
    return 0;
}