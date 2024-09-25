package Exercicios_aula4;

import javax.swing.*;
import java.awt.*;

public class DesenhoJanela extends JPanel {
    private int[] listaPontos;
    private int[] mediaMovel;

    public DesenhoJanela(int[][] matrizPontos) {
        int[] listaPontos = new int[matrizPontos[0].length];
        int[] mediaMovel = new int[matrizPontos[1].length];
        System.arraycopy(matrizPontos[0], 0, listaPontos, 0,
                matrizPontos[0].length); // Preenche ListaPontos
        System.arraycopy(matrizPontos[1], 0, mediaMovel, 0,
                matrizPontos[1].length); // Preenche ListaPontos
        criarJanela();
    }

    public DesenhoJanela(int[] listaPontos, int[] mediaMovel) {
        this.listaPontos = listaPontos;
        this.mediaMovel = mediaMovel;
        criarJanela();
    }

    // Método para desenhar pontos brancos
    public void desenharPonto(int x, int y, Graphics g) {
        g.fillOval(x, y, 5, 5); // Desenha um ponto branco com diâmetro de 5 pixels
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Aqui você pode adicionar o código para desenhar na janela
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 400, 400); // desenha um retângulo preto
        g.setColor(Color.red);
        for (int i = 0; i < listaPontos.length; i++) {
            desenharPonto(i * (400 / listaPontos.length), listaPontos[i], g);
        }
        g.setColor(Color.blue);
        for (int i = 0; i < mediaMovel.length; i++) {
            desenharPonto(i * (400 / mediaMovel.length), mediaMovel[i], g);
        }
    }

    private void criarJanela() {
        JFrame frame = new JFrame("Janela de Desenho");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.add(this);
        frame.setVisible(true);
    }
}
