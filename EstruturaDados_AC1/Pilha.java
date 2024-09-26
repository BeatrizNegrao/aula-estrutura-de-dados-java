package EstruturaDados_AC1;

import java.util.ArrayList;

//Pilha implementada utilizando Listas
public class Pilha {
    ArrayList<Object> elementos;

    // Construtor
    public Pilha() {
        elementos = new ArrayList<Object>();
    }

    // Método que Verifica se a Pilha está Vazia
    public boolean pilhaVazia() {
        if (elementos.size() == 0)
            return true;
        else
            return false;
    }

    public void empilhar(Object item) {
        elementos.add(item);
    }

    public Object desempilhar() {
        if (!pilhaVazia())
            return elementos.remove(elementos.size() - 1);
        return null;
    }

    public Object exibirTopo() {
        if (!pilhaVazia())
            return elementos.get(elementos.size() - 1);
        return null;
    }
}
