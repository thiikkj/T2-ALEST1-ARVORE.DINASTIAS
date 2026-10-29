public class Main {
    static void mostrar(String chamada, boolean resultado) {
        System.out.println(chamada + " -> " + resultado);
    }

    public static void main(String[] args) throws Exception {
        Dinastias.carregar("Relacoes.txt");

        mostrar("ehAncestral(Rickard Stark, Robb Stark)",
                Dinastias.ehAncestral("Rickard Stark", "Robb Stark"));
        mostrar("ehAncestral(Rickard Stark, Jon Snow)",
                Dinastias.ehAncestral("Rickard Stark", "Jon Snow"));
        mostrar("ehAncestral(Aerys II Targaryen, Jon Snow)",
                Dinastias.ehAncestral("Aerys II Targaryen", "Jon Snow"));
        mostrar("saoIrmaos(Robb Stark, Sansa Stark)",
                Dinastias.saoIrmaos("Robb Stark", "Sansa Stark"));
        mostrar("saoIrmaos(Robb Stark, Jon Snow)",
                Dinastias.saoIrmaos("Robb Stark", "Jon Snow"));
        mostrar("saoPrimos(Robb Stark, Jon Snow)",
                Dinastias.saoPrimos("Robb Stark", "Jon Snow"));
        mostrar("ehAncestral(Rickard Stark, Pessoa Inexistente)",
                Dinastias.ehAncestral("Rickard Stark", "Pessoa Inexistente"));
    }
}