import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Dinastias {
    static List<Tree<String>> raizes = new ArrayList<>();

    //Busca em pré-ordem a partir de um nó
    static Tree<String> buscar(Tree<String> no, String nome) {
        if (no.item.equals(nome)) return no;
        for (int i = 0; i < no.childrenCount(); i++) {
            Tree<String> achado = buscar(no.getChild(i), nome);
            if (achado != null) return achado;
        }
        return null;
    }

    static Tree<String> buscarNaFloresta(String nome) {
        for (Tree<String> raiz : raizes) {
            Tree<String> achado = buscar(raiz, nome);
            if (achado != null) return achado;
        }
        return null;
    }

    static Tree<String> buscarRaiz(String nome) {
        for (Tree<String> raiz : raizes) {
            if (raiz.item.equals(nome)) return raiz;
        }
        return null;
    }

    static void inserir(String nomePai, String nomeFilho) {
        Tree<String> pai = buscarNaFloresta(nomePai);
        if (pai == null) {
            pai = new Tree<>(nomePai);
            raizes.add(pai);
        }
        Tree<String> filho = buscarRaiz(nomeFilho);
        if (filho != null) {
            raizes.remove(filho); // deixa de ser raiz
        } else {
            filho = new Tree<>(nomeFilho);
        }
        pai.addChild(filho);
    }

    static void carregar(String arquivo) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(arquivo));
        br.readLine(); // primeira linha: número de relações
        Pattern aspas = Pattern.compile("\"([^\"]+)\"");
        List<String> nomes = new ArrayList<>();
        String linha;
        while ((linha = br.readLine()) != null) {
            Matcher m = aspas.matcher(linha);
            while (m.find()) nomes.add(m.group(1));
        }
        br.close();
        for (int i = 0; i + 1 < nomes.size(); i += 2) {
            inserir(nomes.get(i), nomes.get(i + 1));
        }
    }

    static boolean ehAncestral(String ancestral, String descendente) {
        Tree<String> no = buscarNaFloresta(descendente);
        if (no == null) return false;
        Tree<String> atual = no.parent;
        while (atual != null) {
            if (atual.item.equals(ancestral)) return true;
            atual = atual.parent;
        }
        return false;
    }

    static boolean saoIrmaos(String pessoa1, String pessoa2) {
        Tree<String> a = buscarNaFloresta(pessoa1);
        Tree<String> b = buscarNaFloresta(pessoa2);
        if (a == null || b == null || a == b) return false;
        return a.parent != null && a.parent == b.parent;
    }

    static Tree<String> avo(Tree<String> no) {
        if (no.parent == null) return null;
        return no.parent.parent;
    }

    static boolean saoPrimos(String pessoa1, String pessoa2) {
        Tree<String> a = buscarNaFloresta(pessoa1);
        Tree<String> b = buscarNaFloresta(pessoa2);
        if (a == null || b == null || a == b) return false;
        Tree<String> avoA = avo(a);
        return avoA != null && avoA == avo(b) && a.parent != b.parent;
    }
}