import org.example.Conversor;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Conversor2Test {
    @ParameterizedTest
    @CsvSource({
            "1, I",
            "4, IV",
            "9, IX",
            "42, XLII",
            "99, XCIX",
            "2021, MMXXI",
            "3999, MMMCMXCIX",
            "0, Não é possível converter o número decimal informado para algarismos romanos o valor é 0.",
            "4000, Não é possível converter o número decimal informado para algarismos romanos o valor é maior que 3999.",
            "1492, MCDXCII",
            "1984, MCMLXXXIV"
    })
    public void testInteiroParaRomano(int valorDecimal, String valorRomanoEsperado) {
        Conversor conversor = new Conversor();
        String valorRomanoConvertido = conversor.inteiroParaRomano(valorDecimal);
        assertEquals(valorRomanoEsperado, valorRomanoConvertido);
    }

    @ParameterizedTest
    @CsvSource({
            "I, 1",
            "IV, 4",
            "IX, 9",
            "XLII, 42",
            "XCIX, 99",
            "MMXXI, 2021",
            "MMMCMXCIX, 3999",
            "ABC, -1",
            "IIII, -1",
            "XXXX, -1",
            "VV, -1"
    })
    public void testRomanoParaInteiro(String valorRomano, int valorDecimalEsperado) {
        Conversor conversor = new Conversor();
        int valorDecimalConvertido = conversor.romanoParaInteiro(valorRomano);
        assertEquals(valorDecimalEsperado, valorDecimalConvertido);
    }
}

