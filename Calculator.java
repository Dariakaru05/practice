import java.util.Scanner;

public class Calculator {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1, num2;
        String operator;
        
        System.out.println("Добро пожаловать в калькулятор!");
        
        while (true) {
            System.out.println("Введите первое число (или 'exit' для выхода):");
            if (scanner.hasNextDouble()) {
                num1 = scanner.nextDouble();
            } else if (scanner.hasNext("exit")) {
                break;
            } else {
                System.out.println("Неверный ввод. Попробуйте еще раз.");
                scanner.next();
                continue;
            }
            
            System.out.println("Введите оператор (+, -, *, /, sqrt):");
            operator = scanner.next();
            
            if (!operator.equals("sqrt")) {
                System.out.println("Введите второе число:");
                if (scanner.hasNextDouble()) {
                    num2 = scanner.nextDouble();
                } else {
                    System.out.println("Неверный ввод. Попробуйте еще раз.");
                    scanner.next();
                    continue;
                }
            } else {
                num2 = 0; // dummy value for sqrt
            }
            
            switch (operator) {
                case "+":
                    System.out.println("Результат: " + (num1 + num2));
                    break;
                case "-":
                    System.out.println("Результат: " + (num1 - num2));
                    break;
                case "*":
                    System.out.println("Результат: " + (num1 * num2));
                    break;
                case "/":
                    if (num2 != 0) {
                        System.out.println("Результат: " + (num1 / num2));
                    } else {
                        System.out.println("Ошибка: деление на ноль.");
                    }
                    break;
                case "sqrt":
                    if (num1 >= 0) {
                        System.out.println("Результат: " + Math.sqrt(num1));
                    } else {
                        System.out.println("Ошибка: отрицательное число под корнем.");
                    }
                    break;
                default:
                    System.out.println("Неверный оператор. Попробуйте еще раз.");
                    break;
            }
        }
        
        System.out.println("Калькулятор завершил работу.");
        scanner.close();
    }
}
