// PUNTO 3: Análisis y correcciones del Triángulo de Pascal

import java.util.Scanner;

class CoefBinomio {
    // Método corregido - calcula factorial parcial
    int calculo(int x, int n) {
        int resul, i;
        if (x > n)
            return 1;
        else {
            resul = x;
            for (i = x + 1; i <= n; i++)
                resul = resul * i;
            return resul;
        }
    }
    
    // Método factorial corregido
    int factorial(int num) {
        int r, i;
        if (num == 0)
            return 1;
        else {
            r = 1;
            for (i = num; i >= 1; i--)
                r = r * i;
            return r;
        }
    }
    
    // Método para calcular coeficiente binomial
    int coef(int n, int r) {
        int r1, r2;
        r1 = calculo(n - r + 1, n);
        r2 = factorial(r);
        return r1 / r2;
    }
    
    // Getters y Setters no aplican ya que no hay atributos de instancia
    
    // Cartel adicional con salida concatenada
    public String mostrarCoeficiente(int n, int r) {
        int resultado = coef(n, r);
        return "C(" + n + "," + r + ") = " + resultado;
    }
}

class TriPascal {
    private Scanner scanner;
    
    public static void main(String[] args) {
        new TriPascal();
    }
    
    // Constructor corregido
    TriPascal() {
        scanner = new Scanner(System.in);
        
        // se instancia un objeto a partir de la clase CoefBinomio
        CoefBinomio objeto = new CoefBinomio();
        int k, n, r, resul, i, j;
        
        System.out.println("=== TRIÁNGULO DE PASCAL ===");
        System.out.print("Ingrese el número de filas a mostrar: ");
        int filas = scanner.nextInt();
        
        // Corregir los bucles
        for (i = 0; i <= filas; i++) { // Error corregido: i+2 -> i++
            // deja los espacios antes del primer numero
            for (k = filas - i; k >= 0; k--) // Error corregido: k-2 -> k--
                System.out.print(" ");
            
            for (j = 0; j <= i; j++) {
                resul = objeto.coef(i, j);
                System.out.print("" + resul);
                
                // para ajustar todos los numeros al mismo espacio
                if (resul < 10)
                    System.out.print(" ");
                System.out.print(" ");
            }
            System.out.println();
        }
        
        // Cartel adicional con salida concatenada
        System.out.println("\n=== INFORMACIÓN ADICIONAL ===");
        System.out.println("Triángulo de Pascal generado con " + (filas + 1) + " filas");
        
        // Mostrar algunos coeficientes específicos
        if (filas >= 4) {
            System.out.println("Coeficientes de la fila 4: ");
            for (int col = 0; col <= 4; col++) {
                System.out.println(objeto.mostrarCoeficiente(4, col));
            }
        }
        
        scanner.close();
    }
    
    // Scanner de las clases
    public void escanearClases() {
        System.out.println("\n=== SCANNER DE LAS CLASES ===");
        System.out.println("Clase CoefBinomio:");
        System.out.println("- Métodos: calculo(), factorial(), coef(), mostrarCoeficiente()");
        System.out.println("- Tipo: Clase utilitaria sin atributos de instancia");
        
        System.out.println("\nClase TriPascal:");
        System.out.println("- Atributo: scanner (Scanner)");
        System.out.println("- Métodos: constructor TriPascal(), escanearClases()");
        System.out.println("- Método main(): punto de entrada del programa");
    }
}

/* 
RESPUESTAS PUNTO 3:

f.) ESTRUCTURA DEL PROGRAMA:
- Clases: CoefBinomio, TriPascal
- Objetos: 
  * objeto (instancia de CoefBinomio)
  * instancia anónima de TriPascal en main()
- Tipos de métodos:
  * Métodos de cálculo en CoefBinomio: calculo(), factorial(), coef()
  * Constructor en TriPascal: TriPascal()
  * Método estático: main()
  * Métodos de utilidad: mostrarCoeficiente(), escanearClases()

g.) ERRORES IDENTIFICADOS Y CORREGIDOS:
1. En el bucle for(i = 0; i <= 6; i+2): faltaba ++ -> debe ser i++
2. En el bucle for(k = 6-i; k >= 0; k-2): faltaba -- -> debe ser k--
3. Falta de manejo de entrada del usuario para hacer el programa interactivo
4. No hay validación de parámetros de entrada

h.) CARTEL ADICIONAL CON SALIDA CONCATENADA:
   mostrarCoeficiente(int n, int r) - muestra formato "C(n,r) = resultado"
   También se agregó información sobre el número de filas generadas

i.) SCANNER DE LAS CLASES:
   Método escanearClases() implementado que muestra la estructura de ambas clases
*/

// Clase para demostrar el uso y testing
class TestTrianguloPascal {
    public static void main(String[] args) {
        System.out.println("=== DEMOSTRACIÓN DEL TRIÁNGULO DE PASCAL CORREGIDO ===");
        
        // Crear instancia de CoefBinomio para pruebas
        CoefBinomio coef = new CoefBinomio();
        
        // Mostrar algunos cálculos
        System.out.println("Factorial de 5: " + coef.factorial(5));
        System.out.println("Calculo(3,5): " + coef.calculo(3, 5));
        System.out.println("Coeficiente C(5,2): " + coef.coef(5, 2));
        
        // Ejecutar el triángulo de Pascal
        System.out.println("\nEjecutando TriPascal:");
        new TriPascal().escanearClases();
    }
}