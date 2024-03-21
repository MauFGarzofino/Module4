import org.junit.jupiter.api.Test;
import test.VerificadorPrimo;

import static org.junit.jupiter.api.Assertions.*;

class VerificadorPrimoTests {
    @Test
    void testNumerosNegativos() {
        VerificadorPrimo verificador = new VerificadorPrimo();
        assertFalse(verificador.esPrimo(-1), "-1 no debería ser primo");
        assertFalse(verificador.esPrimo(-2), "-2 no debería ser primo");
    }

    @Test
    void testCero() {
        VerificadorPrimo verificador = new VerificadorPrimo();
        assertFalse(verificador.esPrimo(0), "0 no debería ser primo");
    }
    @Test
    void testPrimosPequeños() {
        VerificadorPrimo verificador = new VerificadorPrimo();
        assertTrue(verificador.esPrimo(5), "El 5 debería ser primo");
    }

    @Test
    void testNumerosPrimosGrandes() {
        VerificadorPrimo verificador = new VerificadorPrimo();
        assertTrue(verificador.esPrimo(5557), "5557 debería ser primo");
    }
}
