package lv.venta.datastr;

import lv.venta.datastr.nodes.MyEdgeNode;
import lv.venta.datastr.nodes.MyVerticeNode;

public class MyGraph<Ttype> {
    private MyVerticeNode[] vertices;
    private final int GRAPH_DEFAULT_SIZE = 10;
    private int size = GRAPH_DEFAULT_SIZE;
    private int counter = 0;

    public MyGraph() {
        vertices = new MyVerticeNode[size];
    }

    public MyGraph(int inputSize) {
        if(inputSize > 0) {
            size = inputSize;
        }
        vertices = new MyVerticeNode[size];
    }

    public boolean isEmpty() {
        return (counter==0);
    }

    public boolean isFull() {
        return (counter == size);
    }

    public int howManyElements() {
        return counter;
    }

    private void resize()
    {
        int newSize = (counter <= 100)? size * 2 : (int)(size * 1.5);
        MyVerticeNode[] verticesNew = new MyVerticeNode[newSize];
        for(int i = 0; i < size; i++) {
            vertices[i] = verticesNew[i];
        }

        vertices = verticesNew;
        System.gc();
        size = newSize;
    }
    public void addVertice(Ttype element) throws Exception {
        if(element == null) throw new Exception("Element is null");
        if(isFull()) resize();
        if(searchVerticeByElement(element) != -1) throw new Exception("Element already exists");
        MyVerticeNode newNode = new MyVerticeNode<Ttype>(element);
        vertices[counter++] = newNode;
    }
    private int searchVerticeByElement(Ttype element) {
        for(int i = 0; i < counter; i++) {
            if(vertices[i].getElement().equals(element)) return i;
        }
        return -1;
    }

    public void addEdge(Ttype verticeFrom, Ttype verticeTo, float weight) throws Exception {
        if(verticeFrom == null || verticeTo == null || weight <= 0 || weight > 41000) throw new Exception("Invalid input");
        if(verticeFrom.equals(verticeTo)) throw new Exception("Vertices are the same");
        int indexFrom = searchVerticeByElement(verticeFrom);
        int indexTo = searchVerticeByElement(verticeTo);
        if(indexFrom == -1 || indexTo == -1) throw new Exception("Vertice not found");
        MyEdgeNode newEdgeNode = new MyEdgeNode(indexTo, weight);
        if(vertices[indexFrom].getFirstEdgeNode() == null)
            vertices[indexFrom].setFirstEdgeNode(newEdgeNode);
         else {
            MyEdgeNode firstEdgeNode = vertices[indexFrom].getFirstEdgeNode();
            newEdgeNode.setNext(firstEdgeNode);
            firstEdgeNode.setPrevious(newEdgeNode);
            firstEdgeNode = newEdgeNode;
        }
    }
    public void print() throws Exception {
        if(isEmpty()) throw new Exception("Graph is empty");
        for(int i = 0; i < counter; i++) {
            System.out.print(vertices[i].getElement() + " -> ");
            MyEdgeNode tempEdge = vertices[i].getFirstEdgeNode();
            while (tempEdge != null) {
                System.out.print(vertices[tempEdge.getIndexOfNeighbour()].getElement() + " " + tempEdge.getWeight());
                tempEdge = tempEdge.getNext();
            }
            System.out.println();
        }
    }
}