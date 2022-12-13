package az.et.web.ee.lesson11;

import java.util.function.BiFunction;

public class Calculator {

    public String doOp(String x, String y, String op) {
        String result;

        try {
            Long a = doParse(x);
            Long b = doParse(y);
            switch (op) {
                case "add": result = calc(a, b, Long::sum); break;
                case "min": result = calc(a, b, (a1, b1) -> (a1 - b1)); break;
                case "div": result = String.valueOf(a / b); break;
                case "mul": result = String.valueOf(a * b); break;
                case "mod": result = String.valueOf(a % b); break;
                default: result = "unsupported operation type: " + op;
            }
        } catch (NumberFormatException nfe) {
            result = "Input is invalid!";
        }

        return result;
    }

    private static String calc(long a, long b, BiFunction<Long, Long, Long> calcFunction) {
        return String.valueOf(calcFunction.apply(a, b));
    }

    private Long doParse(String s) {
        return Long.parseLong(s);
    }

}
