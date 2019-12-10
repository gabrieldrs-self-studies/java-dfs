package util.generators;

import lib.Graph;
import util.RandomString;

import java.util.ArrayList;
import java.util.Random;

public class GraphGenerator implements IGenerator {

    public Graph generate() {
        Graph g = new Graph();
        Random r = new Random();
        int numberOfVertices = r.nextInt(5)+10;
        int numberOfEdges = r.nextInt(10)+10;

        ArrayList<String> verticesList = new ArrayList<>();

        for (int i = 0; i < numberOfVertices; i++) {
            String vertex = RandomString.generateRandomString(10);
            verticesList.add(vertex);
            g.addVertex(vertex);
        }

        for (int i = 0; i < numberOfEdges; i++) {
            ArrayList<String> verticesListCopy = (ArrayList<String>) verticesList.clone();
            String vertex1 = verticesList.get(r.nextInt(verticesList.size()));
            ArrayList<String> v1AdjList = g.getVertexAdjVertices(vertex1);
            verticesListCopy.removeAll(v1AdjList);
            String vertex2 = verticesListCopy.get(r.nextInt(verticesListCopy.size()));
            g.addEdge(vertex1, vertex2);
        }

        // Adds edges to vertices that ended up without any
        verticesList.forEach(val -> {
            if (g.getVertexAdjVertices(val).size() == 0) {
                String vertex = verticesList.get(r.nextInt(verticesList.size()));
                g.addEdge(val, vertex);
            }
        });

        return g;
    }
}
