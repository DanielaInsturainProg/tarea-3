//Código Actividad n6
//Calculadora de área y perímetro con manejo de errores y operaciones multiples
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Code_act6 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcionFigura, opcionOperacion;
        boolean continuar = true;

        // Almacena los resultados en un ArrayList
        ArrayList<String> resultados = new ArrayList<>();

        while (continuar) {
            try {
                // Menú principal para elegir figura
                System.out.println("=== Calculadora de Área y Perímetro ===");
                System.out.println("Elija la figura geométrica:");
                System.out.println("1. Círculo");
                System.out.println("2. Cuadrado");
                System.out.println("3. Triángulo");
                System.out.println("4. Rectángulo");
                System.out.println("5. Pentágono");
                System.out.println("6. Salir");
                System.out.print("Opción: ");
                opcionFigura = entrada.nextInt();

                if (opcionFigura == 6) {
                    continuar = false;
                    System.out.println("Saliendo del programa. ¡Gracias!");
                    break;
                }

                // Menú para elegir la operación
                System.out.println("Elija la operación:");
                System.out.println("1. Área");
                System.out.println("2. Perímetro");
                System.out.print("Opción: ");
                opcionOperacion = entrada.nextInt();

                String resultado = "";
                switch (opcionFigura) {
                    case 1:
                        resultado = calcularCirculo(opcionOperacion, entrada);
                        break;
                    case 2:
                        resultado = calcularCuadrado(opcionOperacion, entrada);
                        break;
                    case 3:
                        resultado = calcularTriangulo(opcionOperacion, entrada);
                        break;
                    case 4:
                        resultado = calcularRectangulo(opcionOperacion, entrada);
                        break;
                    case 5:
                        resultado = calcularPentagono(opcionOperacion, entrada);
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }

                if (!resultado.isEmpty()) {
                    resultados.add(resultado); // Almacena el resultado en el arreglo
                    System.out.println("Resultado: " + resultado);
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Entrada no válida. Por favor, ingrese un número válido.");
                entrada.nextLine(); // Limpiar el buffer de entrada
            }
            System.out.println(); // Salto de línea
        }

        // Mostrar todos los resultados almacenados
        System.out.println("=== Resultados de todas las operaciones ===");
        for (int i = 0; i < resultados.size(); i++) {
            System.out.println((i + 1) + ". " + resultados.get(i));
        }

        entrada.close();
    }

    // Métodos para cálculos
    public static String calcularCirculo(int operacion, Scanner entrada) {
        System.out.print("Digite el radio del círculo: ");
        double radio = entrada.nextDouble();
        if (operacion == 1) {
            double area = Math.PI * Math.pow(radio, 2);
            return String.format("Área del círculo con radio %.2f: %.2f", radio, area);
        } else if (operacion == 2) {
            double perimetro = 2 * Math.PI * radio;
            return String.format("Perímetro del círculo con radio %.2f: %.2f", radio, perimetro);
        } else {
            return "Operación no válida.";
        }
    }

    public static String calcularCuadrado(int operacion, Scanner entrada) {
        System.out.print("Digite el lado del cuadrado: ");
        double lado = entrada.nextDouble();
        if (operacion == 1) {
            double area = Math.pow(lado, 2);
            return String.format("Área del cuadrado con lado %.2f: %.2f", lado, area);
        } else if (operacion == 2) {
            double perimetro = 4 * lado;
            return String.format("Perímetro del cuadrado con lado %.2f: %.2f", lado, perimetro);
        } else {
            return "Operación no válida.";
        }
    }

    public static String calcularTriangulo(int operacion, Scanner entrada) {
        if (operacion == 1) {
            System.out.print("Digite la base del triángulo: ");
            double base = entrada.nextDouble();
            System.out.print("Digite la altura del triángulo: ");
            double altura = entrada.nextDouble();
            double area = (base * altura) / 2;
            return String.format("Área del triángulo con base %.2f y altura %.2f: %.2f", base, altura, area);
        } else if (operacion == 2) {
            System.out.print("Digite los tres lados del triángulo separados por espacios: ");
            double lado1 = entrada.nextDouble();
            double lado2 = entrada.nextDouble();
            double lado3 = entrada.nextDouble();
            double perimetro = lado1 + lado2 + lado3;
            return String.format("Perímetro del triángulo con lados %.2f, %.2f y %.2f: %.2f", lado1, lado2, lado3, perimetro);
        } else {
            return "Operación no válida.";
        }
    }

    public static String calcularRectangulo(int operacion, Scanner entrada) {
        System.out.print("Digite el largo del rectángulo: ");
        double largo = entrada.nextDouble();
        System.out.print("Digite el ancho del rectángulo: ");
        double ancho = entrada.nextDouble();
        if (operacion == 1) {
            double area = largo * ancho;
            return String.format("Área del rectángulo con largo %.2f y ancho %.2f: %.2f", largo, ancho, area);
        } else if (operacion == 2) {
            double perimetro = 2 * (largo + ancho);
            return String.format("Perímetro del rectángulo con largo %.2f y ancho %.2f: %.2f", largo, ancho, perimetro);
        } else {
            return "Operación no válida.";
        }
    }

    public static String calcularPentagono(int operacion, Scanner entrada) {
        if (operacion == 1) {
            System.out.print("Digite el lado del pentágono: ");
            double lado = entrada.nextDouble();
            System.out.print("Digite el apotema del pentágono: ");
            double apotema = entrada.nextDouble();
            double area = (5 * lado * apotema) / 2;
            return String.format("Área del pentágono con lado %.2f y apotema %.2f: %.2f", lado, apotema, area);
        } else if (operacion == 2) {
            System.out.print("Digite el lado del pentágono: ");
            double lado = entrada.nextDouble();
            double perimetro = 5 * lado;
            return String.format("Perímetro del pentágono con lado %.2f: %.2f", lado, perimetro);
        } else {
            return "Operación no válida.";
        }
    }
}