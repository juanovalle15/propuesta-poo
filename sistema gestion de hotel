// Enum para tipos de habitación
enum TipoHabitacion {
    INDIVIDUAL("Individual", 1),
    DOBLE("Doble", 2),
    SUITE("Suite", 4),
    FAMILIAR("Familiar", 6);
    
    private final String nombre;
    private final int capacidad;
    
    TipoHabitacion(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
    }
    
    public String getNombre() { return nombre; }
    public int getCapacidad() { return capacidad; }
}

// Enum para estado de reserva
enum EstadoReserva {
    PENDIENTE("Pendiente"),
    CONFIRMADA("Confirmada"),
    CANCELADA("Cancelada"),
    COMPLETADA("Completada");
    
    private final String estado;
    
    EstadoReserva(String estado) {
        this.estado = estado;
    }
    
    public String getEstado() { return estado; }
}

// Clase Habitación mejorada
public class Habitacion {
    private int numero;
    private TipoHabitacion tipo;
    private double precioPorNoche;
    private boolean disponible;
    private boolean mantenimiento;
    
    public Habitacion(int numero, TipoHabitacion tipo, double precioPorNoche) {
        this.numero = numero;
        this.tipo = tipo;
        this.precioPorNoche = precioPorNoche;
        this.disponible = true;
        this.mantenimiento = false;
    }
    
    public void ocupar() {
        if (mantenimiento) {
            throw new IllegalStateException("Habitación en mantenimiento");
        }
        this.disponible = false;
    }
    
    public void liberar() {
        this.disponible = true;
    }
    
    public void ponerEnMantenimiento() {
        this.disponible = false;
        this.mantenimiento = true;
    }
    
    public void sacarDeMantenimiento() {
        this.mantenimiento = false;
        this.disponible = true;
    }
    
    public boolean estaDisponible() {
        return disponible && !mantenimiento;
    }
    
    // Getters
    public int getNumero() { return numero; }
    public TipoHabitacion getTipo() { return tipo; }
    public double getPrecioPorNoche() { return precioPorNoche; }
    public boolean isDisponible() { return disponible; }
    public boolean isMantenimiento() { return mantenimiento; }
    
    // Setters
    public void setPrecioPorNoche(double precioPorNoche) {
        if (precioPorNoche <= 0) {
            throw new IllegalArgumentException("El precio debe ser positivo");
        }
        this.precioPorNoche = precioPorNoche;
    }
    
    @Override
    public String toString() {
        String estado = mantenimiento ? "En Mantenimiento" : 
                        (disponible ? "Disponible" : "Ocupada");
        return String.format("Hab %d - %s ($%.2f/noche) - %s", 
                           numero, tipo.getNombre(), precioPorNoche, estado);
    }
}

// Clase Cliente mejorada
public class Cliente {
    private static int contadorId = 1;
    private int id;
    private String nombre;
    private String telefono;
    private String email;
    private String documento;
    private boolean vip;
    
    public Cliente(String nombre, String telefono, String email, String documento) {
        this.id = contadorId++;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.documento = documento;
        this.vip = false;
    }
    
    public void marcarComoVip() {
        this.vip = true;
    }
    
    public double obtenerDescuento() {
        return vip ? 0.10 : 0.0; // 10% descuento para VIP
    }
    
    // Getters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
    public String getEmail() { return email; }
    public String getDocumento() { return documento; }
    public boolean isVip() { return vip; }
    
    // Setters
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public void setEmail(String email) { this.email = email; }
    
    @Override
    public String toString() {
        return String.format("Cliente #%d - %s (Doc: %s) %s", 
                           id, nombre, documento, vip ? "[VIP]" : "");
    }
}

// Clase Reserva mejorada
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
    private static int contadorId = 1;
    private int id;
    private Date fechaEntrada;
    private Date fechaSalida;
    private Habitacion habitacion;
    private Cliente cliente;
    private EstadoReserva estado;
    private double descuentoAplicado;
    private int numeroHuespedes;
    
    public Reserva(Date fechaEntrada, Date fechaSalida, 
                   Habitacion habitacion, Cliente cliente, int numeroHuespedes) {
        if (fechaSalida.before(fechaEntrada)) {
            throw new IllegalArgumentException("Fecha de salida debe ser después de entrada");
        }
        if (numeroHuespedes > habitacion.getTipo().getCapacidad()) {
            throw new IllegalArgumentException("Demasiados huéspedes para esta habitación");
        }
        
        this.id = contadorId++;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.habitacion = habitacion;
        this.cliente = cliente;
        this.estado = EstadoReserva.PENDIENTE;
        this.numeroHuespedes = numeroHuespedes;
        this.descuentoAplicado = cliente.obtenerDescuento();
    }
    
    public long calcularDias() {
        long diferencia = fechaSalida.getTime() - fechaEntrada.getTime();
        long dias = TimeUnit.DAYS.convert(diferencia, TimeUnit.MILLISECONDS);
        return Math.max(1, dias);
    }
    
    public double calcularSubtotal() {
        return calcularDias() * habitacion.getPrecioPorNoche();
    }
    
    public double calcularDescuento() {
        return calcularSubtotal() * descuentoAplicado;
    }
    
    public double calcularTotal() {
        return calcularSubtotal() - calcularDescuento();
    }
    
    public void confirmar() {
        if (estado != EstadoReserva.PENDIENTE) {
            throw new IllegalStateException("Solo se pueden confirmar reservas pendientes");
        }
        habitacion.ocupar();
        estado = EstadoReserva.CONFIRMADA;
    }
    
    public void cancelar() {
        if (estado == EstadoReserva.CONFIRMADA) {
            habitacion.liberar();
        }
        estado = EstadoReserva.CANCELADA;
    }
    
    public void completar() {
        if (estado != EstadoReserva.CONFIRMADA) {
            throw new IllegalStateException("Solo se pueden completar reservas confirmadas");
        }
        habitacion.liberar();
        estado = EstadoReserva.COMPLETADA;
    }
    
    // Getters
    public int getId() { return id; }
    public Date getFechaEntrada() { return fechaEntrada; }
    public Date getFechaSalida() { return fechaSalida; }
    public Habitacion getHabitacion() { return habitacion; }
    public Cliente getCliente() { return cliente; }
    public EstadoReserva getEstado() { return estado; }
    public int getNumeroHuespedes() { return numeroHuespedes; }
    
    // Setters con validaciones
    public void setFechaEntrada(Date fechaEntrada) {
        if (estado != EstadoReserva.PENDIENTE) {
            throw new IllegalStateException("No se puede modificar reserva confirmada");
        }
        this.fechaEntrada = fechaEntrada;
    }
    
    public void setFechaSalida(Date fechaSalida) {
        if (estado != EstadoReserva.PENDIENTE) {
            throw new IllegalStateException("No se puede modificar reserva confirmada");
        }
        this.fechaSalida = fechaSalida;
    }
    
    @Override
    public String toString() {
        return String.format("Reserva #%d - %s - Hab %d (%d días) - %s - Total: $%.2f",
                           id, cliente.getNombre(), habitacion.getNumero(), 
                           calcularDias(), estado.getEstado(), calcularTotal());
    }
}

// Nueva clase: Gestor de Hotel
import java.util.*;

public class GestorHotel {
    private List<Habitacion> habitaciones;
    private List<Cliente> clientes;
    private List<Reserva> reservas;
    private String nombreHotel;
    
    public GestorHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
        this.habitaciones = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }
    
    public void agregarHabitacion(Habitacion habitacion) {
        habitaciones.add(habitacion);
    }
    
    public void registrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }
    
    public List<Habitacion> buscarHabitacionesDisponibles(TipoHabitacion tipo) {
        List<Habitacion> disponibles = new ArrayList<>();
        for (Habitacion hab : habitaciones) {
            if (hab.getTipo() == tipo && hab.estaDisponible()) {
                disponibles.add(hab);
            }
        }
        return disponibles;
    }
    
    public Cliente buscarClientePorDocumento(String documento) {
        for (Cliente cliente : clientes) {
            if (cliente.getDocumento().equals(documento)) {
                return cliente;
            }
        }
        return null;
    }
    
    public Habitacion buscarHabitacionPorNumero(int numero) {
        for (Habitacion hab : habitaciones) {
            if (hab.getNumero() == numero) {
                return hab;
            }
        }
        return null;
    }
    
    public Reserva crearReserva(Date entrada, Date salida, int numeroHab, 
                               String documento, int huespedes) {
        Cliente cliente = buscarClientePorDocumento(documento);
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente no encontrado");
        }
        
        Habitacion habitacion = buscarHabitacionPorNumero(numeroHab);
        if (habitacion == null) {
            throw new IllegalArgumentException("Habitación no encontrada");
        }
        
        if (!habitacion.estaDisponible()) {
            throw new IllegalArgumentException("Habitación no disponible");
        }
        
        Reserva reserva = new Reserva(entrada, salida, habitacion, cliente, huespedes);
        reservas.add(reserva);
        return reserva;
    }
    
    public List<Reserva> listarReservasPorEstado(EstadoReserva estado) {
        List<Reserva> resultado = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if (reserva.getEstado() == estado) {
                resultado.add(reserva);
            }
        }
        return resultado;
    }
    
    public double calcularIngresosPorPeriodo(Date inicio, Date fin) {
        double ingresos = 0;
        for (Reserva reserva : reservas) {
            if (reserva.getEstado() == EstadoReserva.COMPLETADA &&
                !reserva.getFechaEntrada().before(inicio) &&
                !reserva.getFechaSalida().after(fin)) {
                ingresos += reserva.calcularTotal();
            }
        }
        return ingresos;
    }
    
    public void generarReporteOcupacion() {
        System.out.println("\n=== REPORTE DE OCUPACIÓN - " + nombreHotel + " ===");
        int ocupadas = 0, disponibles = 0, mantenimiento = 0;
        
        for (Habitacion hab : habitaciones) {
            if (hab.isMantenimiento()) {
                mantenimiento++;
            } else if (hab.isDisponible()) {
                disponibles++;
            } else {
                ocupadas++;
            }
        }
        
        System.out.println("Total habitaciones: " + habitaciones.size());
        System.out.println("Ocupadas: " + ocupadas);
        System.out.println("Disponibles: " + disponibles);
        System.out.println("En mantenimiento: " + mantenimiento);
        System.out.println("Ocupación: " + 
                          String.format("%.1f%%", (ocupadas * 100.0 / habitaciones.size())));
    }
    
    // Getters
    public String getNombreHotel() { return nombreHotel; }
    public List<Habitacion> getHabitaciones() { return new ArrayList<>(habitaciones); }
    public List<Cliente> getClientes() { return new ArrayList<>(clientes); }
    public List<Reserva> getReservas() { return new ArrayList<>(reservas); }
}

// Clase principal con ejemplo de uso
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {
        // Crear gestor del hotel
        GestorHotel hotel = new GestorHotel("Hotel Universidad Nacional");
        
        // Crear habitaciones
        hotel.agregarHabitacion(new Habitacion(101, TipoHabitacion.INDIVIDUAL, 80000));
        hotel.agregarHabitacion(new Habitacion(102, TipoHabitacion.DOBLE, 120000));
        hotel.agregarHabitacion(new Habitacion(201, TipoHabitacion.SUITE, 200000));
        hotel.agregarHabitacion(new Habitacion(301, TipoHabitacion.FAMILIAR, 180000));
        
        // Registrar clientes
        Cliente cliente1 = new Cliente("Juan Pablo Ovalle", "313-653-4957", 
                                     "juan@unal.edu.co", "1234567890");
        Cliente cliente2 = new Cliente("María González", "310-123-4567", 
                                     "maria@email.com", "0987654321");
        cliente2.marcarComoVip(); // Cliente VIP
        
        hotel.registrarCliente(cliente1);
        hotel.registrarCliente(cliente2);
        
        // Crear fechas
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date entrada1 = sdf.parse("20/05/2025");
        Date salida1 = sdf.parse("23/05/2025");
        Date entrada2 = sdf.parse("25/05/2025");
        Date salida2 = sdf.parse("27/05/2025");
        
        try {
            // Crear reservas
            Reserva reserva1 = hotel.crearReserva(entrada1, salida1, 101, 
                                                 "1234567890", 1);
            Reserva reserva2 = hotel.crearReserva(entrada2, salida2, 201, 
                                                 "0987654321", 2);
            
            System.out.println("=== RESERVAS CREADAS ===");
            System.out.println(reserva1);
            System.out.println(reserva2);
            
            // Confirmar reservas
            reserva1.confirmar();
            reserva2.confirmar();
            System.out.println("\nReservas confirmadas!");
            
            // Buscar habitaciones disponibles
            System.out.println("\n=== HABITACIONES DOBLES DISPONIBLES ===");
            var habitacionesDobles = hotel.buscarHabitacionesDisponibles(TipoHabitacion.DOBLE);
            for (Habitacion hab : habitacionesDobles) {
                System.out.println(hab);
            }
            
            // Completar una reserva
            reserva1.completar();
            System.out.println("\nReserva #1 completada!");
            
            // Generar reporte
            hotel.generarReporteOcupacion();
            
            // Poner habitación en mantenimiento
            Habitacion hab102 = hotel.buscarHabitacionPorNumero(102);
            hab102.ponerEnMantenimiento();
            System.out.println("\nHabitación 102 puesta en mantenimiento");
            
            // Reporte final
            hotel.generarReporteOcupacion();
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
