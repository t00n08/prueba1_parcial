public class Main {
    public static void main(String[] args) {
        // Try-catch para atrapar cualquier error de validacion
        try {
            // Creo el gestor
            GestorTallerBicicletas gestor = new GestorTallerBicicletas();

            // Creo las bicicletas con los datos que venian en la tabla
            BicicletaElectrica biciE1 = new BicicletaElectrica("BIC-E01", 2023, 22.5, 60, false);
            BicicletaElectrica biciE2 = new BicicletaElectrica("BIC-E02", 2022, 24.0, 45, true);
            BicicletaMontanya biciM1 = new BicicletaMontanya("BIC-M01", 2021, 13.5, 2);
            BicicletaMontanya biciM2 = new BicicletaMontanya("BIC-M02", 2020, 12.0, 1);

            // Le activo la garantia extendida a la BIC-E01
            biciE1.activarGarantiaExtendida();

            // Guardo las bicis en la lista del gestor
            gestor.registrarBicicleta(biciE1);
            gestor.registrarBicicleta(biciE2);
            gestor.registrarBicicleta(biciM1);
            gestor.registrarBicicleta(biciM2);

            // Busqueda de la bici BIC-E01
            System.out.println("\n=== BUSQUEDA POR CODIGO: \"BIC-E01\" ===");
            Bicicleta buscada = gestor.buscarPorCodigo("BIC-E01");

            if (buscada != null && buscada instanceof BicicletaElectrica) {
                BicicletaElectrica e = (BicicletaElectrica) buscada;
                String cert = e.isBateriaCertificada() ? "Si" : "No";
                String gar = e.tieneGarantiaExtendida() ? "Si" : "No";

                // Muestro los datos formateados igual a la imagen de ejemplo
                System.out.println("Tipo: Bicicleta Eléctrica | Código: " + e.getCodigo() +
                        " | Año: " + e.getAnioFabricacion() +
                        " | Peso: " + e.getPeso() + " kg" +
                        " | Autonomia: " + e.getAutonomia() + " km" +
                        " | Batería certificada: " + cert +
                        "\nGarantia extendida: " + gar +
                        " | Costo mantención: $" + (int)e.calcularCostoMantencion());
            }
            System.out.println("---");

            // Listo todas las bicis registradas
            System.out.println("\n=== LISTADO DE BICICLETAS ===");
            gestor.listarTodas();

        } catch (IllegalArgumentException e) {
            // Si salta alguna excepcion de los setters muestra el mensaje aca
            System.err.println("Error de validación: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Ocurrió un error inesperado: " + e.getMessage());
        }
    }
}