public class BicicletaElectrica extends Bicicleta implements ConGarantiaExtendida {
    // Atributos especificos de la bici electrica
    private int autonomia;
    private boolean bateriaCertificada;
    private boolean garantiaActiva;

    // Constructor que llama a la clase padre con super
    public BicicletaElectrica(String codigo, int anioFabricacion, double peso, int autonomia, boolean bateriaCertificada) {
        super(codigo, anioFabricacion, peso);
        setAutonomia(autonomia);
        setBateriaCertificada(bateriaCertificada);
        this.garantiaActiva = false; // Parte desactivada por defecto
    }

    // Calculo de mantencion: base $45.000 + 25% si la bateria no esta certificada
    @Override
    public double calcularCostoMantencion() {
        double costoBase = 45000.0;
        if (!bateriaCertificada) {
            costoBase *= 1.25;
        }
        return costoBase;
    }

    // Metodos que vienen de la interfaz ConGarantiaExtendida
    @Override
    public boolean tieneGarantiaExtendida() {
        return garantiaActiva;
    }

    @Override
    public void activarGarantiaExtendida() {
        this.garantiaActiva = true;
    }

    // Getters y Setters con validacion de autonomia
    public int getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(int autonomia) {
        if (autonomia <= 0) {
            throw new IllegalArgumentException("La autonomía debe ser mayor a 0 km.");
        }
        this.autonomia = autonomia;
    }

    public boolean isBateriaCertificada() {
        return bateriaCertificada;
    }

    public void setBateriaCertificada(boolean bateriaCertificada) {
        this.bateriaCertificada = bateriaCertificada;
    }
}