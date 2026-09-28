import java.util.ArrayList;
import java.util.List;

public class GestorTallerBicicletas {
    // Lista para guardar las bicicletas ingresadas
    private List<Bicicleta> listaBicicletas;

    public GestorTallerBicicletas() {
        this.listaBicicletas = new ArrayList<>();
    }

    // Registra una bicicleta y avisa por consola
    public void registrarBicicleta(Bicicleta bicicleta) {
        if (bicicleta != null) {
            listaBicicletas.add(bicicleta);
            System.out.println(bicicleta.getCodigo() + " (" + bicicleta.getClass().getSimpleName() + ") registrada correctamente.");
        }
    }

    // Busca una bici recorriendo la lista por el codigo
    public Bicicleta buscarPorCodigo(String codigo) {
        for (Bicicleta b : listaBicicletas) {
            if (b.getCodigo().equalsIgnoreCase(codigo)) {
                return b;
            }
        }
        return null; // Retorna null si no la encuentra
    }

    // Muestra todas las bicis registradas usando el toString()
    public void listarTodas() {
        for (Bicicleta b : listaBicicletas) {
            System.out.println(b.toString());
        }
    }
}