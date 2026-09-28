public class BicicletaMontanya extends Bicicleta {
    // Atributo propio de la bici de montaña
    private int suspensiones;

    public BicicletaMontanya(String codigo, int anioFabricacion, double peso, int suspensiones) {
        super(codigo, anioFabricacion, peso);
        setSuspensiones(suspensiones);
    }

    // Calculo de mantencion: base $30.000 + 15% si tiene mas de 1 suspension
    @Override
    public double calcularCostoMantencion() {
        double costoBase = 30000.0;
        if (suspensiones > 1) {
            costoBase *= 1.15;
        }
        return costoBase;
    }

    // Getter y Setter con validacion
    public int getSuspensiones() {
        return suspensiones;
    }

    public void setSuspensiones(int suspensiones) {
        if (suspensiones < 0) {
            throw new IllegalArgumentException("La cantidad de suspensiones no puede ser negativa.");
        }
        this.suspensiones = suspensiones;
    }
}