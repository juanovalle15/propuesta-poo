// PUNTO 2: Análisis y mejoras de la clase Triangulo

import java.util.Scanner;

class Triangulo {
    // ATRIBUTOS (variables globales)
    private double area;
    private double altura;
    private int a, b, c;
    
    // CONSTRUCTOR por defecto
    public Triangulo() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.area = 0.0;
        this.altura = 0.0;
    }
    
    // CONSTRUCTOR con parámetros (con variables locales)
    public Triangulo(int lado1, int lado2, int lado3) {
        this.a = lado1;
        this.b = lado2;
        this.c = lado3;
        this.area = 0.0;
        this.altura = 0.0;
    }
    
    // GETTERS
    public double getArea() {
        return area;
    }
    
    public double getAltura() {
        return altura;
    }
    
    public int getLadoA() {
        return a;
    }
    
    public int getLadoB() {
        return b;
    }
    
    public int getLadoC() {
        return c;
    }
    
    // SETTERS
    public void setArea(double area) {
        this.area = area;
    }
    
    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    public void setLadoA(int a) {
        this.a = a;
    }
    
    public void setLadoB(int b) {
        this.b = b;
    }
    
    public void setLadoC(int c) {
        this.c = c;
    }
    
    public void setLados(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    // MÉTODO que invoca variables globales
    public void mostrarInformacionTriangulo() {
        System.out.println("Información del triángulo:");
        System.out.println("Lado a: " + this.a);
        System.out.println("Lado b: " + this.b);
        System.out.println("Lado c: " + this.c);
        System.out.println("Área: " + this.area);
        System.out.println("Altura: " + this.altura);
    }
    
    // Método original corregido
    void f(int la, int lb, int lc) {
        a = la;
        b = lb;
        c = lc;
    }
    
    double raiz(double m) {
        double g1, g2;
        g2 = m / 2.0;
        do {
            g1 = g2;
            g2 = (g1 + m / g1) / 2.0;
        } while (Math.abs(g1 - g2) > 0.0001); // Corrección: comparación con tolerancia
        return g2;
    }
    
    void areaTriangulo() {
        double s = (a + b + c) / 2.0;
        area = raiz(s * (s - a) * (s - b) * (s - c));
    }
    
    void alturaTriangulo() {
        if (area > 0) {
            altura = (2 * area) / (double)a; // Corrección: cast a double
        } else {
            altura = 0;
        }
    }
    
    double f1() { 
        return area;
    }
    
    double f2() { 
        return altura;
    }
    
    // CARTEL DE SALIDA CONCATENADA
    public String obtenerInformacionConcatenada() {
        return "Triángulo con lados: " + a + ", " + b + ", " + c + 
               " | Área: " + String.format("%.2f", area) + 
               " | Altura: " + String.format("%.2f", altura);
    }
    
    // Método para verificar si es un triángulo válido
    public boolean esTrianguloValido() {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }
}

// Clase principal para probar la funcionalidad
public class TestTriangulo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Crear triángulo con constructor por defecto
        Triangulo triangulo1 = new Triangulo();
        
        // Crear triángulo con constructor con parámetros
        Triangulo triangulo2 = new Triangulo(3, 4, 5);
        
        // Configurar el primer triángulo usando setters
        triangulo1.setLados(6, 8, 10);
        
        System.out.println("=== ANÁLISIS DE LA ESTRUCTURA ===");
        System.out.println("a.) ESTRUCTURA DEL PROGRAMA:");
        System.out.println("- Clase: Triangulo");
        System.out.println("- Atributos: area, altura, a, b, c");
        System.out.println("- Métodos constructores: Triangulo(), Triangulo(int, int, int)");
        System.out.println("- Métodos de cálculo: f(), raiz(), areaTriangulo(), alturaTriangulo()");
        System.out.println("- Métodos de acceso: f1(), f2(), getters y setters");
        System.out.println("- Métodos utilitarios: mostrarInformacionTriangulo(), obtenerInformacionConcatenada()");
        
        // Probar funcionalidad
        if (triangulo2.esTrianguloValido()) {
            triangulo2.areaTriangulo();
            triangulo2.alturaTriangulo();
            
            System.out.println("\n=== RESULTADOS TRIÁNGULO 2 ===");
            triangulo2.mostrarInformacionTriangulo();
            System.out.println("\nCartel concatenado: " + triangulo2.obtenerInformacionConcatenada());
        }
        
        scanner.close();
    }
}

/* 
RESPUESTAS PUNTO 2:

a.) ESTRUCTURA DEL PROGRAMA:
- Clase: Triangulo
- Objetos: Instancias de la clase Triangulo
- Tipos de métodos:
  * Constructores: Triangulo(), Triangulo(int, int, int)
  * Métodos de instancia: f(), raiz(), areaTriangulo(), alturaTriangulo()
  * Métodos de acceso (getters): getArea(), getAltura(), getLadoA(), etc.
  * Métodos modificadores (setters): setArea(), setAltura(), setLados(), etc.
  * Métodos de retorno: f1(), f2()

b.) MÉTODO QUE INVOCA VARIABLES GLOBALES:
   mostrarInformacionTriangulo() - accede a todos los atributos de la clase

c.) MÉTODO CONSTRUCTOR CON VARIABLES LOCALES:
   Triangulo(int lado1, int lado2, int lado3) - usa parámetros locales

d.) GETTERS Y SETTERS:
   Implementados para todos los atributos de la clase

e.) CARTEL DE SALIDA CONCATENADA:
   obtenerInformacionConcatenada() - retorna string formateado con toda la información
*/