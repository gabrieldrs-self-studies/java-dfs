import lib.Graph;
import util.generators.BinaryTreeGenerator;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Graph g = new BinaryTreeGenerator().generate();

        g.print();

        depthFirstVisit(g);
    }

    public static void depthFirstVisit(Graph g) {
        depthVisit(g, g.getRoot(), "");
    }

    public static void depthVisit(Graph g, String node, String parent) {
        System.out.println("Visited \"" + node + "\"");
        ArrayList<String> adjVertices = g.getVertexAdjVertices(node);
        adjVertices.forEach(v -> {
            if (!v.equals(parent)) {
                depthVisit(g, v, node);
            }
        });
    }
}
