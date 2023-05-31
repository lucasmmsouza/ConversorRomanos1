package org.example;

import java.util.HashMap;

public class Conversor {

    public String inteiroParaRomano(int valor) {
        if (valor <= 0) {
            return "Não é possível converter o número decimal informado para algarismos romanos o valor é 0.";
        }
        else if (valor > 3999){
            return "Não é possível converter o número decimal informado para algarismos romanos o valor é maior que 3999.";
        }



        String[] unidadeDeMilhar = { "", "M", "MM", "MMM" };
        String[] centenas = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
        String[] dezenas = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
        String[] unidades = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };

        return unidadeDeMilhar[valor / 1000] + centenas[(valor % 1000) / 100] + dezenas[(valor % 100) / 10]
                + unidades[valor % 10];
    }

    public int romanoParaInteiro(String s) {
        if (!isRomanoValido(s)) {
            return -1;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int resultado = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && map.get(s.charAt(i)) > map.get(s.charAt(i - 1))) {
                resultado += map.get(s.charAt(i)) - 2 * map.get(s.charAt(i - 1));
            } else {
                resultado += map.get(s.charAt(i));
            }
        }

        return resultado;
    }

    private boolean isRomanoValido(String s) {
        // Verifica se a string contém apenas caracteres válidos
        for (char c : s.toCharArray()) {
            if (c != 'I' && c != 'V' && c != 'X' && c != 'L' && c != 'C' && c != 'D' && c != 'M') {
                return false;
            }
        }

        // Verifica se a string segue as regras de repetição de caracteres válidos
        int countI = 0;
        int countX = 0;
        int countC = 0;
        int countM = 0;

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            if (current == 'I') {
                countI++;
                countX = 0;
                countC = 0;
                countM = 0;

                if (countI > 3) {
                    return false;
                }
            } else if (current == 'X') {
                countI = 0;
                countX++;
                countC = 0;
                countM = 0;

                if (countX > 3) {
                    return false;
                }
            } else if (current == 'C') {
                countI = 0;
                countX = 0;
                countC++;
                countM = 0;

                if (countC > 3) {
                    return false;
                }
            } else if (current == 'M') {
                countI = 0;
                countX = 0;
                countC = 0;
                countM++;

                if (countM > 3) {
                    return false;
                }
            } else {
                countI = 0;
                countX = 0;
                countC = 0;
                countM = 0;
            }

            if (i > 0) {
                char previous = s.charAt(i - 1);

                if (current == 'V' || current == 'L' || current == 'D') {
                    if (previous == current) {
                        return false;
                    }
                } else if (current == 'C') {
                    if (previous == 'I' || previous == 'V' || previous == 'L' || previous == 'D') {
                        return false;
                    }
                }

                if (current == 'V' && previous == 'X') {
                    return false;
                } else if (current == 'L' && previous == 'C') {
                    return false;
                } else if (current == 'D' && previous == 'M') {
                    return false;
                }
            }
        }

        return true;
    }
}

