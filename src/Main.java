import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputExpression;

        System.out.println("Введите строку с арифметическим выражением:");
        inputExpression = scanner.nextLine();

        try {
            System.out.println(calc(inputExpression));
        } catch (ScannerExceptions sc) {
            System.out.println(sc.getMessage());
        }
    }

    public static String calc(String input) throws ScannerExceptions {
        Calculator calc = new Calculator();
        RomanSolver rs = new RomanSolver();
        String result;
        String convertedExpression;
        String[] expression = input.split(" ");

        if (expression.length != 3)
            throw new ScannerExceptions("Неверно введено арифметическое выражение.");

        convertedExpression = rs.numeralTypeConverter(expression);

        result = calc.calculate(convertedExpression);

        if (rs.checkDigitType(expression))
            return rs.arabianToRoman(Integer.parseInt(result));
        return result;
    }
}