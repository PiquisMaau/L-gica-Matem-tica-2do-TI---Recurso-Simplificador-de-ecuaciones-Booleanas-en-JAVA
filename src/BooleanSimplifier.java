public class BooleanSimplifier {

    public static String simplificar(String exp) {
        exp = exp.replace(" ", "");

        // Reglas básicas
        exp = exp.replaceAll("\\+0", "");
        exp = exp.replaceAll("0\\+", "");
        exp = exp.replaceAll("\\*1", "");
        exp = exp.replaceAll("1\\*", "");

        exp = exp.replaceAll("\\+1", "1");
        exp = exp.replaceAll("1\\+", "1");

        exp = exp.replaceAll("\\*0", "0");
        exp = exp.replaceAll("0\\*", "0");

        // Idempotencia
        exp = exp.replaceAll("([A-Z])\\+\\1", "$1");
        exp = exp.replaceAll("([A-Z])\\*\\1", "$1");

        // Complemento
        exp = exp.replaceAll("([A-Z])\\+\\1'", "1");
        exp = exp.replaceAll("([A-Z])'\\+\\1", "1");
        exp = exp.replaceAll("([A-Z])\\*\\1'", "0");
        exp = exp.replaceAll("([A-Z])'\\*\\1", "0");

        // Absorción: A + A*B = A
        exp = exp.replaceAll("([A-Z])\\+\\1\\*([A-Z])", "$1");
        exp = exp.replaceAll("([A-Z])\\*([A-Z])\\+\\1", "$1");

        // Limpieza final
        exp = exp.replaceAll("\\(1\\)", "1");
        exp = exp.replaceAll("\\(0\\)", "0");

        return exp;
    }
}

