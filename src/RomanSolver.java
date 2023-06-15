class RomanSolver {
    String[] fullRomanDigits = new String[] {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    String[] fullRomanDecimal = new String[] {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"};
    char[] romanNumbers = new char[] {'I', 'V', 'X', 'L', 'C'};
    int[] arabianNumbers = new int[] {1, 5, 10, 50, 100};

    String RomanToArabian(String romanStr) {
        int result = 0;
        int previousValue = 0;
        int currentValue;
        int i = romanStr.length() - 1;

        while (i > -1) {
            currentValue = getArabianValue(romanStr.toCharArray()[i]);
            if (currentValue >= previousValue) {
                result += currentValue;
            }
            else {
                result -= currentValue;
            }
            previousValue = currentValue;
            i--;
        }

        return String.valueOf(result);
    }

    int getArabianValue(char romanNumber) {
        int arabianNumber = 0;
        int i = 0;

        while (i < romanNumbers.length) {
            if (romanNumber == romanNumbers[i]) {
                arabianNumber = arabianNumbers[i];
                break;
            }
            i++;
        }

        return arabianNumber;
    }

    String romanNumberRule(int number, int posDigit) {
        if (posDigit == 1)
            return fullRomanDigits[number];
        else
            return fullRomanDecimal[number];
    }

    String arabianToRoman(int arabianNumber) {
        return romanNumberRule(arabianNumber / 10, 10) + romanNumberRule(arabianNumber % 10, 1);
    }

    boolean checkDigitType(String[] exp) {
        return checkRomanNumberInExpression(exp[0]) && checkRomanNumberInExpression(exp[2]);
    }

    String numeralTypeConverter(String[] exp) throws ScannerExceptions {
        if (!exp[1].equals("/") && !exp[1].equals("*") && !exp[1].equals("-") && !exp[1].equals("+"))
            throw new ScannerExceptions("Неверный ввод арифметического знака, допустимые знаки: +, -, /, *.");
        else if (checkRomanNumberInExpression(exp[0]) && checkRomanNumberInExpression(exp[2]) &&
                    checkLimitValuesInRomanExpression(RomanToArabian(exp[0]), RomanToArabian(exp[2]), exp[1]))
            return RomanToArabian(exp[0]) + " " + exp[1] + " " + RomanToArabian(exp[2]);
        else if (checkArabianNumberInExpression(exp[0]) && checkArabianNumberInExpression(exp[2]))
            return exp[0] + " " + exp[1] + " " + exp[2];
        else
            throw new ScannerExceptions("Неверный формат чисел - " +
                    "два числа должны быть одновременно либо римскими(от 1 до 10 включительно), " +
                    "либо арабскими(от I до X включительно).");
    }

    boolean checkLimitValuesInRomanExpression(String a, String b, String sign) throws ScannerExceptions {
        if (Integer.parseInt(a) < 1 || Integer.parseInt(b) > 10)
            throw new ScannerExceptions("Числа должны быть от I до X включительно " +
                    "в римской системе счисления.");
        else if ((sign.equals("-") && ((Integer.parseInt(a) - Integer.parseInt(b)) < 1)) ||
                    (sign.equals("/") && ((Integer.parseInt(a) / Integer.parseInt(b)) < 1)))
            throw new ScannerExceptions("Результат арифметического выражения " +
                    "в римских числах должен быть положительным.");
        else
            return true;
    }

    boolean checkArabianNumberInExpression(String number) {
        try {
            return Integer.parseInt(number) >= 1 && Integer.parseInt(number) <= 10;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    boolean checkRomanNumberInExpression(String number) {
        int i = 0;

        while (i < fullRomanDigits.length) {
            if (number.equals(fullRomanDigits[i]) && !number.equals(""))
                return true;
            i++;
        }

        return false;
    }
}
