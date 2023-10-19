import java.util.*;

public class PemdasCalculator {
    public static double solveEquation(String equation) {
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < equation.length(); i++) {
            char ch = equation.charAt(i);

            if (ch == ' ') {
                continue;
            } else if (Character.isDigit(ch)) {
                StringBuilder sb = new StringBuilder();
                while (i < equation.length() && (Character.isDigit(equation.charAt(i)) || equation.charAt(i) == '.')) {
                    sb.append(equation.charAt(i));
                    i++;
                }
                i--;
                numbers.push(Double.parseDouble(sb.toString()));
            } else if (ch == '(') {
                operators.push(ch);
            } else if (ch == ')') {
                while (operators.peek() != '(') {
                    numbers.push(applyOperator(operators.pop(), numbers.pop(), numbers.pop()));
                }
                operators.pop();
            } else if (isOperator(ch)) {
                while (!operators.isEmpty() && hasPrecedence(ch, operators.peek())) {
                    numbers.push(applyOperator(operators.pop(), numbers.pop(), numbers.pop()));
                }
                operators.push(ch);
            }
        }

        while (!operators.isEmpty()) {
            numbers.push(applyOperator(operators.pop(), numbers.pop(), numbers.pop()));
        }

        return numbers.pop();
    }

    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            return false;
        }
        return (op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-');
    }

    private static double applyOperator(char operator, double b, double a) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                return a / b;
        }
        return 0;
    }

    public static void main(String[] args) {
        String equation;
        int parenthesisCtr = 0;

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter Equation: ");
        equation = scan.nextLine(); // = "((2 + 3) * 4) - (6 / 2)";

        for (int i = 0; i < equation.length(); i++) {
            if (equation.charAt(i) == '(' || equation.charAt(i) == ')') {
                parenthesisCtr++;
            }
        }

        if (parenthesisCtr % 2 == 0) {
            double result = solveEquation(equation);
            System.out.println("Result: " + result);
        } else {
            System.out.println("Unequal number of parenthesis!");
        }

        scan.close();
    }
}
