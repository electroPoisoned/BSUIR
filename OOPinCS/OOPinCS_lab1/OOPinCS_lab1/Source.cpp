#include <iostream>
#include <vector>

int main() {
    std::cout << "Enter n:";
    int size;
    std::cin >> size;

    std::vector<int> array(size);
    std::vector<int> onlyEven;
    std::vector<int> equalEvenOdd;

    std::cout << "Enter " << size << " numbers:\n";
    for (int i = 0; i < size; i++) {
        std::cin >> array[i];
    }

    int evenDigitNumbers = 0;
    int equalEvenOddDigitNumbers = 0;
    int copyNum;
    for (int num : array) {
        copyNum = num;
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
            equalEvenOdd.push_back(copyNum);
        }
        if (oddDigits == 0) {
            evenDigitNumbers++;
            onlyEven.push_back(copyNum);
        }
    }

    std::cout << "Number of digits which contain only even digits: " << evenDigitNumbers << "\n";
    for (int num:onlyEven){
        std::cout << num << "\t";
    }
    std::cout << "\nNumber of digits which contain equal even and odd digits number: " << equalEvenOddDigitNumbers << "\n";
    for (int num : equalEvenOdd) {
        std::cout << num << "\t";
    }
    return 0;
}
