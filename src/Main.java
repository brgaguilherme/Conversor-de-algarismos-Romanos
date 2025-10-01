import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Conversor de Números Romanos ===");
        System.out.print("Digite um número romano: ");
        String romano = scanner.nextLine().toUpperCase(); // garante letras maiúsculas

        try {
            int resultado = romanToInt(romano);
            System.out.println("O número romano " + romano + " equivale a " + resultado);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        scanner.close();
    }

    // Função que converte algarismos romanos em inteiros
    public static int romanToInt(String roman) {
        int total = 0;
        int prevValue = 0;

        for (int i = roman.length() - 1; i >= 0; i--) {
            int value = romanCharToInt(roman.charAt(i));

            if (value < prevValue) {
                total -= value; // caso de subtração (ex: IV = 5-1)
            } else {
                total += value;
            }

            prevValue = value;
        }

        return total;
    }

    // Converte caractere romano em número
    private static int romanCharToInt(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: throw new IllegalArgumentException("Caractere inválido: " + c);
        }
    }
}
