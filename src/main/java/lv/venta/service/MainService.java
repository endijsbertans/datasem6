package lv.venta.service;

import lv.venta.datastr.MyGraph;

public class MainService {
    public static void main(String[] args) {
        MyGraph<String> map = new MyGraph<>();
        try {
            map.addVertice("Rīga");
            map.addVertice("Tukums");
            map.addVertice("Kuldīga");
            map.addVertice("Ventspils");
            map.addVertice("Talsi");
            map.addEdge("Ventspils", "Rīga", 189);
            map.addEdge("Ventspils", "Kuldīga", 56.49f);
            map.addEdge("Ventspils", "Talsi", 64f);
            map.addEdge("Tukums", "Rīga", 58f);
            map.addEdge("Rīga", "Kuldīga", 148.88f);
            map.print();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
