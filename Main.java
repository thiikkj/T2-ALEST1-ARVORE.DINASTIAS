public class Main {
    static void ancestral(String a, String b) {
        boolean r = Dinastias.ehAncestral(a, b);
        System.out.println("ehAncestral(\"" + a + "\", \"" + b + "\") -> " + (r ? "TRUE" : "FALSE"));
    }

    static void irmaos(String a, String b) {
        boolean r = Dinastias.saoIrmaos(a, b);
        System.out.println("saoIrmaos(\"" + a + "\", \"" + b + "\") -> " + (r ? "TRUE" : "FALSE"));
    }

    static void primos(String a, String b) {
        boolean r = Dinastias.saoPrimos(a, b);
        System.out.println("saoPrimos(\"" + a + "\", \"" + b + "\") -> " + (r ? "TRUE" : "FALSE"));
    }

    public static void main(String[] args) throws Exception {
        Dinastias.carregar("Relacoes.txt");

        System.out.println("7.1 Casos validos");
        ancestral("Rickard Stark", "Robb Stark");
        ancestral("Rickard Stark", "Jon Snow");
        ancestral("Aerys II Targaryen", "Jon Snow");
        ancestral("Robb Stark", "Rickard Stark");
        ancestral("Tywin Lannister", "Jon Snow");
        irmaos("Robb Stark", "Sansa Stark");
        irmaos("Cersei Lannister", "Jaime Lannister");
        irmaos("Robb Stark", "Jon Snow");
        primos("Robb Stark", "Jon Snow");
        primos("Jaime Lannister", "Lancel Lannister");
        primos("Robb Stark", "Sansa Stark");
        primos("Robb Stark", "Cersei Lannister");

        System.out.println();
        System.out.println("7.2 Casos invalidos");
        ancestral("Rickard Stark", "Pessoa Inexistente");
        ancestral("Pessoa Inexistente", "Robb Stark");
        ancestral("Rickard Stark", "Rickard Stark");
        irmaos("Robb Stark", "Pessoa Inexistente");
        irmaos("Robb Stark", "Robb Stark");
        irmaos("Willam Stark", "Maekar I Targaryen");
        primos("Robb Stark", "Pessoa Inexistente");
        primos("Jon Snow", "Jon Snow");
    }
}