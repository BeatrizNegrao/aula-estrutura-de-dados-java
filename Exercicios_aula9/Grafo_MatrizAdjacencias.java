package Exercicios_aula9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

class Grafo_MatrizAdjacencias {
    int[][] matrizAdjacencias;
    String[] vertices;
    int indiceVertices;

    // Instancia a matriz conforme a quantidade de vertices
    public Grafo_MatrizAdjacencias(int qtdVertices) {
        this.matrizAdjacencias = new int[qtdVertices][qtdVertices];
        this.vertices = new String[qtdVertices];
        indiceVertices = 0;
    }

    // Método para adicionar um novo vértice
    public void addVertice(String nome) {
        if (indiceVertices < vertices.length) {
            vertices[indiceVertices] = nome;
            indiceVertices++;
        }
    }

    // Método para remover um vértice
    public void removeVertice() {
        if (indiceVertices > 0) {
            vertices[indiceVertices - 1] = "";
            indiceVertices--;
        }
    }

    // Método para adicionar as relações entre os vértices do grafo
    public void addArestaBidirecionais(int iVerticeA, int iVerticeB, int valor) {
        matrizAdjacencias[iVerticeA][iVerticeB] = valor;
        matrizAdjacencias[iVerticeB][iVerticeA] = valor;
    }

    // Método para adicionar a relação unidirecional entre o vértice A para B
    public void addArestaUnidirecionais(int iVerticeA, int iVerticeB, int valor) {
        matrizAdjacencias[iVerticeA][iVerticeB] = valor;
    }

    // Retorna as relações dos vétices indicado pelo índice iVertice
    public String relacoesVertices(int iVertice) {
        String relacoes = "";
        for (int i = 0; i < vertices.length; i++) {
            relacoes = relacoes + "\nVertice: " + i + " => ";
            for (int j = 0; j < vertices.length; j++) {
                if (matrizAdjacencias[i][j] != 0) {
                    relacoes = relacoes + "Vertice " + j + "(" + matrizAdjacencias[i][j] + ")";
                }
            }
        }
        return relacoes;
    }

    // irá buscar em profundidade até encontrar o vertice final, retornando uma
    // string com o caminho percorrido
    public String buscaProfundidade(int iVerticeInicial, int iVerticeFinal) {
        // instância da pilha original
        Stack<Integer> pilhaOriginal = new Stack<>();
        // Lista para armazenar o caminho percorrido
        Stack<Integer> pilhaAuxiliar = new Stack<>();
        // Lista de vértices visitados
        List<Integer> visitados = new ArrayList<>();

        // Adiciona o vértice inicial à pilha original
        pilhaOriginal.push(iVerticeInicial);

        while (!pilhaOriginal.isEmpty()) {
            // Remove o último elemento da pilha original
            int verticeAtual = pilhaOriginal.pop();

            // Verifica se o vértice já foi visitado
            if (!visitados.contains(verticeAtual)) {
                visitados.add(verticeAtual); // Marca o vértice como visitado

                // Verifica se o vértice final foi encontrado
                if (verticeAtual == iVerticeFinal) {
                    return "Caminho encontrado: " + visitados;
                }

                // Adiciona os vizinhos não visitados à pilha original
                for (int i = 0; i < vertices.length; i++) {
                    if (matrizAdjacencias[verticeAtual][i] != 0 && !visitados.contains(i)) {
                        pilhaAuxiliar.push(i);// empilha a pilha auxiliar na posição i
                    }
                }

                while (!pilhaAuxiliar.isEmpty()) { // enquanto a pilha auxiliar não estiver vazia
                    pilhaOriginal.push(pilhaAuxiliar.pop());
                }
            }
        }

        // Se não encontrou o vértice final
        return "Caminho não encontrado!";
    }

    public String buscaLargura(int iVerticeInicial, int iVerticeFinal) {
        LinkedList<Integer> fila = new LinkedList<>();
        List<Integer> visitados = new ArrayList<>();

        fila.add(iVerticeInicial); // adiciona o vértice inicial à fila

        while (!fila.isEmpty()) { // enquanto a fila não estiver vazia
            int verticeAtual = fila.poll(); // Remove o primeiro da fila

            // Verifica se o vértice já foi visitado
            if (!visitados.contains(verticeAtual)) {
                visitados.add(verticeAtual); // Marca o vértice como visitado

                if (verticeAtual == iVerticeFinal) { // se o vertice atual for igual ao vertice final
                    return "Caminho encontrado: " + visitados; // retorna os vértices visitados até o último vértice
                }

                // Adiciona os vizinhos não visitados à fila
                for (int i = 0; i < vertices.length; i++) {
                    if (matrizAdjacencias[verticeAtual][i] != 0 && !visitados.contains(i)) {
                        fila.add(i); // Adiciona o vizinho à fila
                    }
                }
            }
        }

        // Se não encontrou o vértice final
        return "Caminho não encontrado!";
    }

    public String buscaGulosa(int iVerticeInicial, int iVerticeFinal) {
        // Fila de prioridade para ordenar os vértices pelo custo direto da aresta
        PriorityQueue<int[]> filaPrioridade = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        // Lista para armazenar os vértices visitados
        List<Integer> visitados = new ArrayList<>();
    
        // Adiciona o vértice inicial à fila com custo 0
        filaPrioridade.add(new int[] { iVerticeInicial, 0 });
    
        while (!filaPrioridade.isEmpty()) { // enquanto a fila prioridade não estiver vazia
            // Remove o vértice com menor custo da fila
            int[] atual = filaPrioridade.poll();
            int verticeAtual = atual[0];
            
            // Verifica se o vértice já foi visitado
            if (!visitados.contains(verticeAtual)) {
                visitados.add(verticeAtual); // Marca o vértice como visitado
    
                // Verifica se o vértice atual chegou ao último vértice
                if (verticeAtual == iVerticeFinal) {
                    return "Caminho encontrado: " + visitados; // retornando o caminho percorrido até o destino
                }
    
                // Adiciona os vizinhos não visitados à fila com seus respectivos custos diretos
                for (int i = 0; i < matrizAdjacencias.length; i++) {
                    // verifica se existe uma aresta entre o vértice atual e o vertice na posição i
                    // e se o vértice na posição i ainda não foi visitado
                    if (matrizAdjacencias[verticeAtual][i] != 0 && !visitados.contains(i)) {
                        int menorCusto = matrizAdjacencias[verticeAtual][i]; // Obtém o menor custo da aresta
                        filaPrioridade.add(new int[] { i, menorCusto }); // Adiciona o vértice e o custo à fila
                    }
                }
            }
        }
    
        // Se não encontrou o vértice final
        return "Caminho não encontrado!";
    }

    public static void main(String[] args) {
        Grafo_MatrizAdjacencias meuGrafo = new Grafo_MatrizAdjacencias(4);

        meuGrafo.addArestaBidirecionais(0, 2, 10);
        meuGrafo.addArestaBidirecionais(0, 3, 5);
        meuGrafo.addArestaBidirecionais(0, 1, 2);
        meuGrafo.addArestaBidirecionais(2, 3, 8);
        meuGrafo.addArestaBidirecionais(3, 1, 7);

        System.out.println("---------------Relações dos vértices-----------");
        System.out.println(meuGrafo.relacoesVertices(0));

        System.out.println("-----------------------------------------------");

        System.out.println("---------------Busca em profundidade-----------");
        System.out.println(meuGrafo.buscaProfundidade(0, 3));
        System.out.println(meuGrafo.buscaProfundidade(0, 2));
        System.out.println(meuGrafo.buscaProfundidade(0, 1));
        System.out.println(meuGrafo.buscaProfundidade(2, 3));
        System.out.println(meuGrafo.buscaProfundidade(3, 1));

        System.out.println("-----------------------------------------------");

        System.out.println("------------------Busca em largura-------------");
        System.out.println(meuGrafo.buscaLargura(0, 3));
        System.out.println(meuGrafo.buscaLargura(0, 2));
        System.out.println(meuGrafo.buscaLargura(0, 1));

        System.out.println("-----------------------------------------------");

        System.out.println("------------------Busca gulosa-----------------");
        System.out.println(meuGrafo.buscaGulosa(0, 3));
        System.out.println(meuGrafo.buscaGulosa(0, 2));
        System.out.println(meuGrafo.buscaGulosa(0, 1));
    }
}
