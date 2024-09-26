package EstruturaDados_AC1;

import java.util.ArrayList;

//1) Implemente o método adicionar().

public class FilaPacientes {

    ArrayList<Paciente> fila = new ArrayList<Paciente>();

    boolean sinaleiro = false;// Variável de controle para indicar se um paciente foi inserido na posição correta.

    // Método para adicionar um paciente na fila de acordo com sua prioridade.
    public void adicionar(Paciente item) {

        if (fila.size() == 0) { // Verifica se o tamanho da fila é zero. Se estiver, adiciona o paciente diretamente no final.
            fila.add(item); // Adiciona o paciente ao final da fila.
        } else {
            for (int i = 0; i < fila.size(); i++) { // Percorre a fila do início ao fim.
                if (fila.get(i).getPrioridade() > item.getPrioridade()) {
                    fila.add(i, item); /*  Se o paciente da fila na posição 'i' tiver prioridade maior que o novo
                                           paciente, o novo paciente será inserido antes.*/

                    sinaleiro = true;  // Marca que o paciente foi inserido na posição correta.
                    break; // Encerra o loop for, pois já encontrou a posição correta.
                }
            }

             // Se nenhum paciente com prioridade maior for encontrado, o novo paciente é adicionado ao final da fila.
            if (sinaleiro == false) { 
                fila.add(item); // Adiciona paciente ao final da fila.
            }
        }
    }

    public Paciente remover() {
        // Remove do inicio da Lista.....
        return fila.remove(0); // Remove e retorna o paciente na primeira posição da fila.
    }

    public Paciente exibirInicio() {
        // Lê a primeira posição sem remover
        return fila.get(0); // Retorna o paciente na primeira posição da fila.
    }

    public int tamanho() {
        // retorna o tamanho da lista.
        return fila.size();  // Retorna o tamanho da fila (quantidade de pacientes).
    }

    public ArrayList<Paciente> getFila() {
        // Retorna a Lista completa
        return fila;  // Retorna a lista inteira de pacientes.
    }
}
