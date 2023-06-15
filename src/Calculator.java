class Calculator {
    String calculate(String exp) {
        String res;
        String[] splitExp;

        splitExp = exp.split(" ");
        res = switch (splitExp[1]) {
            case "+" -> Integer.toString(Integer.parseInt(splitExp[0]) + Integer.parseInt(splitExp[2]));
            case "-" -> Integer.toString(Integer.parseInt(splitExp[0]) - Integer.parseInt(splitExp[2]));
            case "*" -> Integer.toString(Integer.parseInt(splitExp[0]) * Integer.parseInt(splitExp[2]));
            case "/" -> Integer.toString(Integer.parseInt(splitExp[0]) / Integer.parseInt(splitExp[2]));
            default -> "";
        };

        return res;
    }
}
