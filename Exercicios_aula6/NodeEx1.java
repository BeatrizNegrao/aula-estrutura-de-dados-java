package Exercicios_aula6;

public class NodeEx1 {
    private Object info; //Armazena as informações que serão atribuidas a lista
    private NodeEx1 proximoNo; // Aponta para o próximo nó

    // Construtor
    public NodeEx1(Object info, NodeEx1 proximoNo) { 
        this.info = info;
        this.proximoNo = proximoNo;
    }

    // Get e set 
    public Object getInfo() {
        return info;
    }

    public NodeEx1 getProxomoNo() {
        return proximoNo;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    public void setProximoNo(NodeEx1 proximoNo) {
        this.proximoNo = proximoNo;
    }
}
