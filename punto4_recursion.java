// PUNTO 4: Análisis y correcciones de las clases de Recursión

import java.util.Scanner;

public class Recursion {
    private Scanner scanner;
    
    public static void main(String[] args) {
        // Verificar que se pasen argumentos
        if (args.length < 2) {
            System.out.println("Por favor, proporcione dos números como argumentos");
            System.out.println("Usando valores por defecto: 5 y 3");
            args = new String[]{"5", "3"};
        }
        
        Recursion r = new Recursion();
        FRecur objeto = new FRecur();
        
        int suma = objeto.G(args[0], args[1]);
        System.out.println("suma = " + suma);
        System.out.println("fact(5) = " + r.fact(5));
        System.out.println("multi(6,4) = " + objeto.multi(6, 4));
        System.out.println("Fibo(0) = " + objeto.fibo(0));
        System.out.println("Fibo(1) = " + objeto.fibo(1));
        System.out.println("Fibo(2) = " + objeto.fibo(2));
        System.out.println("Fibo(3) = " + objeto.fibo(3));
        System.out.println("Fibo(10) = " + objeto.fibo(10));
        System.out.print("F1 = ");
        objeto.F1(5);
        
        // Cartel adicional con salida concatenada
        System.out.println("\n=== INFORMACIÓN ADICIONAL CONCATENADA ===");
        System.out.println("Resultados de operaciones recursivas: " +
                          "Factorial(5)=" + r.fact(5) + 
                          ", Multiplicación(6*4)=" + objeto.multi(6, 4) + 
                          ", Fibonacci(10)=" + objeto.fibo(10));
    }
    
    // Constructor corregido - debe estar público
    public Recursion() {
        scanner = new Scanner(System.in);
    }
    
    // Método factorial recursivo
    int fact(int x) {
        int y;
        if (x == 0)
            return 1;
        else {
            y = x * fact(x - 1);
            return y;
        }
    }
    
    // Scanner de la clase Recursion
    public void escanearClaseRecursion() {
        System.out.println("=== SCANNER CLASE RECURSION ===");
        System.out.println("Atributos: scanner (Scanner)");
        System.out.println("Métodos: main() [estático], Recursion() [constructor], fact() [recursivo]");
        System.out.println("Funcionalidad: Cálculo factorial recursivo y punto de entrada del programa");
    }
}

class FRecur {
    private String ultimaOperacion;
    
    // Constructor
    public FRecur() {
        this.ultimaOperacion = "";
    }
    
    // Getter y Setter para ultimaOperacion
    public String getUltimaOperacion() {
        return ultimaOperacion;
    }
    
    public void setUltimaOperacion(String operacion) {
        this.ultimaOperacion = operacion;
    }
    
    // Método que llama a F
    int G(String a, String b) {
        setUltimaOperacion("Suma de strings: " + a + " + " + b);
        return F(a, b);
    }
    
    // Método factorial recursivo
    int fact(int x) {
        int y;
        if (x == 0)
            return 1;
        else {
            y = x * fact(x - 1);
            return y;
        }
    }
    
    // Método multiplicación recursiva
    int multi(int a, int b) {
        int c;
        if (b == 0)
            return 0;
        else {
            c = a + multi(a, b - 1);
            return c;
        }
    }
    
    // Método Fibonacci recursivo
    int fibo(int n) {
        int antep, penul;
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        else {
            antep = fibo(n - 2);
            penul = fibo(n - 1);
            return antep + penul;
        }
    }
    
    // Método para sumar strings convertidos a enteros
    int F(String a, String b) {
        int c;
        try {
            c = Integer.parseInt(a) + Integer.parseInt(b);
            return c;
        } catch (NumberFormatException e) {
            System.out.println("Error: No se pueden convertir los strings a números");
            return 0;
        }
    }
    
    // Método recursivo de impresión
    void F1(int x) {
        if (x > 0) {
            F1(x - 1);
            System.out.println("" + x);
        }
    }
    
    // Cartel adicional con información concatenada
    public String obtenerResumenOperaciones(int n, int a, int b) {
        return "Resumen FRecur: " +
               "Factorial(" + n + ")=" + fact(n) + 
               ", Fibonacci(" + n + ")=" + fibo(n) + 
               ", Multiplicación(" + a + "*" + b + ")=" + multi(a, b) +
               ", Última operación: " + ultimaOperacion;
    }
    
    // Scanner de la clase FRecur
    public void escanearClaseFRecur() {
        System.out.println("=== SCANNER CLASE FRECUR ===");
        System.out.println("Atributos: ultimaOperacion (String)");
        System.out.println("Métodos recursivos: fact(), multi(), fibo(), F1()");
        System.out.println("Métodos utilitarios: G(), F(), getUltimaOperacion(), setUltimaOperacion()");
        System.out.println("Métodos informativos: obtenerResumenOperaciones(), escanearClaseFRecur()");
        System.out.println("Funcionalidad: Implementa operaciones matemáticas usando recursión");
    }
}

// Clase de testing para demostrar funcionalidad
class TestRecursion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== DEMOSTRACIÓN DE CLASES RECURSIVAS ===");
        
        // Crear instancias
        Recursion recursion = new Recursion();
        FRecur frecur = new FRecur();
        
        // Demostrar funcionalidades
        System.out.println("Ingrese un número para factorial:");
        int num = scanner.nextInt();
        System.out.println("Factorial de " + num + " = " + recursion.fact(num));
        
        System.out.println("Ingrese un número para Fibonacci:");
        int fib = scanner.nextInt();
        System.out.println("Fibonacci de " + fib + " = " + frecur.fibo(fib));
        
        // Mostrar resumen
        System.out.println(frecur.obtenerResumenOperaciones(5, 6, 4));
        
        // Ejecutar scanners
        recursion.escanearClaseRecursion();
        frecur.escanearClaseFRecur();
        
        scanner.close();
    }
}

/*
RESPUESTAS PUNTO 4:

j.) ESTRUCTURA DEL PROGRAMA:
- Clases: Recursion, FRecur
- Objetos:
  * r (instancia de Recursion)
  * objeto (instancia de FRecur)
- Tipos de métodos:
  * Métodos recursivos: fact(), multi(), fibo(), F1()
  * Métodos de utilidad: G(), F()
  * Constructor: Recursion(), FRecur()
  * Método estático: main()
  * Getters/Setters: getUltimaOperacion(), setUltimaOperacion()

k.) ERRORES IDENTIFICADOS Y CORREGIDOS:
1. Falta de verificación de argumentos en main() - agregada validación
2. Constructor Recursion() no tenía modificador de acceso - corregido a public
3. Falta manejo de excepciones en F() para conversión de strings
4. No había getters/setters en FRecur - agregados
5. Las claves } estaban mal posicionadas en algunos métodos

l.) CARTEL ADICIONAL CON SALIDA CONCATENADA:
   obtenerResumenOperaciones() - concatena resultados de múltiples operaciones
   También se agregó información en main() mostrando resultados combinados

m.) SCANNER DE LAS CLASES:
   escanearClaseRecursion() y escanearClaseFRecur() implementados
   Muestran estructura completa de cada clase incluyendo atributos y métodos
*/