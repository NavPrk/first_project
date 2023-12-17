import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите арифметическое выражение (например, 1 + 2):");
        String input = scanner.nextLine();

        try {
            String result = calc(input);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static String calc(String input) throws Exception {
        // Разбиваем введенную строку на три части: операнд1, оператор, операнд2
        String[] parts = input.split(" ");

        if (parts.length != 3) {
            throw new Exception("Неверный формат ввода. Ожидается два числа и оператор между ними.");
        }

        int operand1 = Integer.parseInt(parts[0]);
        String operator = parts[1];
        int operand2 = Integer.parseInt(parts[2]);

        // Проверяем диапазон чисел
        if (operand1 < 1 || operand1 > 10 || operand2 < 1 || operand2 > 10) {
            throw new Exception("Числа должны быть от 1 до 10 включительно.");
        }

        // Выполняем арифметическую операцию
        int result;
        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                // При делении остаток отбрасывается
                result = operand1 / operand2;
                break;
            default:
                throw new Exception("Неподдерживаемая арифметическая операция: " + operator);
        }

        return String.valueOf(result);
    }
}
