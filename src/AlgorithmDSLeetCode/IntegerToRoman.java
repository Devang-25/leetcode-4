package AlgorithmDSLeetCode;

public class IntegerToRoman {

    static final int MIN_VALUE = 1;
    static final int MAX_VALUE = 3999;
    static final String[] RN_M = {"", "M", "MM", "MMM"};
    static final String[] RN_C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    static final String[] RN_X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    static final String[] RN_I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    public String intToRoman(int number) {
        if (number < MIN_VALUE || number > MAX_VALUE) {
            throw new IllegalArgumentException(
                    String.format(
                            "The number must be in the range [%d, %d]",
                            MIN_VALUE,
                            MAX_VALUE
                    )
            );
        }

        return new StringBuilder()
                .append(RN_M[number / 1000])
                .append(RN_C[(number % 1000) / 100])
                .append(RN_X[(number % 100) / 10])
                .append(RN_I[(number % 10)])
                .toString();
    }

}
