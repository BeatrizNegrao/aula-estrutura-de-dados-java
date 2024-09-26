package EstruturaDados_AC1;

import java.util.ArrayList;
import java.util.List;

    public class FilaPacientes {
        ArrayList<Paciente> fila = new ArrayList<Paciente>();
        boolean sinaleiro = false; // Variável de controle para indicar se a pessoa foi inserida na posição correta.

        public void adicionar(Paciente item) {

            if (fila.size() == 0 ) { // verifica se o tamanho da fila é igual a zero 
                fila.add(item); // adiciona o item ao final da fila 
            } else { 
                for (int i = 0; i < fila.size(); i++) { // Percorre do início ao fim da fila.
                    if (fila.get(i).getPrioridade() > item.getPrioridade()) {
                        fila.add(i, item); // Insere o item de maior prioridade antes do item de menor prioridade na posição 'i'.
                        sinaleiro = true;  // Marca que o item de prioridade foi inserido.
                        break; // Encerra o loop for, pois já encontrou a posição correta.
                    }
                }
                if (sinaleiro == false) { // Se nenhuma item for encontrado (todas na fila são de mesma prioridade).
                    fila.add(item); // Adiciona item ao final da fila.
                }
            }
        }

        public Paciente remover() {
            // Remove do inicio da Lista.....
            return fila.remove(0);
        }

        public Paciente exibirInicio() {
            // Lê a primeira posição sem remover
            return fila.get(0);
        }

        public int tamanho() {
            // retorna o tamanho da lista.
            return fila.size();
        }

        public ArrayList<Paciente> getFila() {
            // Retorna a Lista completa
            return fila;
        }
    }

