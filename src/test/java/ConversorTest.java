
import org.example.Conversor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConversorTest {

    @Test
    public void testInteiroParaRomano() {
        Conversor conversor = new Conversor();

        Assertions.assertEquals("I", conversor.inteiroParaRomano(1));
        Assertions.assertEquals("IV", conversor.inteiroParaRomano(4));
        Assertions.assertEquals("IX", conversor.inteiroParaRomano(9));
        Assertions.assertEquals("XLII", conversor.inteiroParaRomano(42));
        Assertions.assertEquals("XCIX", conversor.inteiroParaRomano(99));
        Assertions.assertEquals("MMXXIII", conversor.inteiroParaRomano(2023));

    }

    @Test
    public void testRomanoParaInteiro() {
        Conversor conversor = new Conversor();

        Assertions.assertEquals(1, conversor.romanoParaInteiro("I"));
        Assertions.assertEquals(4, conversor.romanoParaInteiro("IV"));
        Assertions.assertEquals(20, conversor.romanoParaInteiro("XX"));
        Assertions.assertEquals(42, conversor.romanoParaInteiro("XLII"));
        Assertions.assertEquals(99, conversor.romanoParaInteiro("XCIX"));
        Assertions.assertEquals(3999, conversor.romanoParaInteiro("MMMCMXCIX"));

        Assertions.assertEquals("O valor inserido é inválido", conversor.romanoParaInteiro("ABC"));
        Assertions.assertEquals("O valor inserido é inválido", conversor.romanoParaInteiro("IIII"));
        Assertions.assertEquals("O valor inserido é inválido", conversor.romanoParaInteiro("XXXX"));
        Assertions.assertEquals("O valor inserido é inválido", conversor.romanoParaInteiro("VV"));
        Assertions.assertEquals("O valor inserido é inválido", conversor.romanoParaInteiro("IC"));
    }

    @Test
    public void testeValor0(){
        Conversor conversor = new Conversor();

        Assertions.assertEquals("Não é possível converter o número decimal informado para algarismos romanos o valor é 0.",
                conversor.inteiroParaRomano(0));

    }

    @Test
    public void testeMaiorQue3999() {
        Conversor conversor = new Conversor();

        Assertions.assertEquals("Não é possível converter o número decimal informado para algarismos romanos o valor é maior que 3999.",
                conversor.inteiroParaRomano(4000));
    }
}
