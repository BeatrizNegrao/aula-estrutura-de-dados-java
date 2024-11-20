package Exercicios_aula7;

public class NodeDuploEx1 {
    private Object info;
    private NodeDuploEx1 proximo;
    private NodeDuploEx1 anterior;

    public NodeDuploEx1(Object info, NodeDuploEx1 proximo, NodeDuploEx1 anterior) {
        this.info = info;
        this.proximo = proximo;
        this.anterior = anterior;
    }

    public Object getInfo() {
        return info;
    }
    public NodeDuploEx1 getProximo() {
        return proximo;
    }
    public NodeDuploEx1 getAnterior() {
        return anterior;
    }
    public void setInfo(Object info) {
        this.info = info;
    }
    public void setProximo(NodeDuploEx1 proximo) {
        this.proximo = proximo;
    }
    public void setAnterior(NodeDuploEx1 anterior) {
        this.anterior = anterior;
    }
    
}
