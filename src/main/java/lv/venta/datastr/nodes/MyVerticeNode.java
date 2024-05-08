package lv.venta.datastr.nodes;

public class MyVerticeNode<Ttype> {
    private Ttype element;
    private MyEdgeNode firstEdgeNode = null;


    public void setElement(Ttype element) {
        if(element != null)
            this.element = element;
        else
            this.element = (Ttype)new Object();
    }

    public void setFirstEdgeNode(MyEdgeNode firstEdgeNode) {
        this.firstEdgeNode = firstEdgeNode;
    }

    public Ttype getElement() {
        return element;
    }

    public MyEdgeNode getFirstEdgeNode() {
        return firstEdgeNode;
    }

    public MyVerticeNode(Ttype element) {
        setElement(element);
    }
    @Override
    public String toString() {
        return "MyVerticeNode{" +
                "element=" + element +
                ", firstEdgeNode=" + firstEdgeNode +
                '}';
    }
}
