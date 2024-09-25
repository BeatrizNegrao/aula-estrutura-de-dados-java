package Exercicios_aula4;

public class MediaMovelVetor {
    /*
     * Em estatística, a média móvel é um recurso utilizado para se
     * identificar a tendência de um conjunto de dados dispostos em uma série de
     * tempo.
     * A média móvel é calculada com base em uma janela de amostras que se desloca
     * ao longo do tempo.
     */
    int[] vetorAmostras;// Armazena todos os dados da amostra
    int[] mediaMovel; // Armazena os dados da janela móvel
    int janela;// Tamanho da janela móvel
    int soma = 0;

    public MediaMovelVetor(int tamanhoAmostras, int janela) {
        this.janela = janela;
        vetorAmostras = new int[tamanhoAmostras];
        mediaMovel = new int[tamanhoAmostras - janela];
        preencherAmostras();
    }

    public void calculaMediaMovel() { // Calcula a média das amostras considerando a janela estipulada

        int media;
        
        System.out.println("Médias: ");
        for (int i = 0; i < vetorAmostras.length - janela; i++) { //Desloca a janela ao longo do vetor de amostra 
            soma = 0; // inicializa a soma da janela
            for (int b = 0; b < janela; b++) { // 
                soma = soma + vetorAmostras[i + b]; // soma os elementos da janela
            }

            // Calcula a média e armazena no vetor de médias móveis
          media = soma / janela; // calcula média
          mediaMovel[i] = media; // Armazena a média em mediaMovel[i] 
           
        }

    }

    private void preencherAmostras() {
        // Preenche o vetor de amostras com valores aleatórios
        Double numeroRandomico;
        System.out.println("Amostras: ");
        for (int i = 0; i < vetorAmostras.length; i++) {
            numeroRandomico = (Math.random() * 400);
            vetorAmostras[i] = numeroRandomico.intValue();
            System.out.print(vetorAmostras[i] + " | ");
        }
    }
}
