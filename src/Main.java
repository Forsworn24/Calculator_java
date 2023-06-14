import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Алгоритм:
//        1. Получаем строку на вход
//        2. Проверяем валидность строки
//        правильный арифметический знак + (либо только арабские (от 1 до 10), либо только римские(от 1 до 10)
//        3. Если Арабские -> в лоб вычисляем выражение и выводим ответ
//        4. Если Римские
//                  a) переводим в арабские + считаем ответ
//                  б) переводим ответ в римские
        Scanner scanner = new Scanner(System.in);
        String inputExpression;

        System.out.println("Введите строку с арифметическим выражением:");
        inputExpression = scanner.nextLine();

        System.out.println(calc(inputExpression));
    }

    public static String calc(String input) {
        Calculator calc = new Calculator();
        RomanSolver rs = new RomanSolver();
        String result;
        String convertedExpression;
        String[] expression = input.split(" ");

        convertedExpression = rs.numeralTypeConverter(expression);

        result = calc.calculate(convertedExpression);

        if (rs.checkDigitType(expression))
            return rs.arabianToRoman(Integer.parseInt(result));
        return result;
    }
}