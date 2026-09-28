/*
 * DIFERENCIAS ENTRE PARADIGMAS DE PROGRAMACION:
 * 1. Tipado y Declaracion: Java es de tipado estatico (se define el tipo de dato explícitamente).
 * 2. Estructura: POO agrupa atributos y metodos en clases.
 *
 * VENTAJAS DEL TIPADO ESTATICO: Permite detectar errores durante la compilacion.
 */
public abstract class Bicicleta {
    private String codigo;
    private int anioFabricacion;
    private double peso;

    public Bicicleta(String codigo, int anioFabricacion, double peso) {
        setCodigo(codigo);
        setAnioFabricacion(anioFabricacion);
        setPeso(peso);
    }

    public abstract double calcularCostoMantencion();

    public String obtenerInformacion() {
        return "Código: " + codigo + " | Año: " + anioFabricacion + " | Peso: " + peso + " kg";
    }

    public String obtenerInformacion(boolean incluirCosto) {
        if (incluirCosto) {
            return obtenerInformacion() + " | Costo mantención: $" + (int)calcularCostoMantencion();
        }
        return obtenerInformacion();
    }

    // --- GETTERS QUE NECESITA MAIN ---
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código de bicicleta no puede ser nulo ni vacío.");
        }
        this.codigo = codigo;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        if (anioFabricacion < 2000 || anioFabricacion > 2026) {
            throw new IllegalArgumentException("El año de fabricación debe estar entre 2000 y 2026.");
        }
        this.anioFabricacion = anioFabricacion;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException("El peso debe ser un valor mayor que cero.");
        }
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + " | Año: " + anioFabricacion;
    }
}