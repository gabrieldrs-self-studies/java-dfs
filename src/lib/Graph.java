package lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Graph {
    private Map<String, ArrayList<String>> graphMap;

    public Graph() {
        this.graphMap = new HashMap<>();

    }

    public String getRoot() {
        return (String) this.graphMap.keySet().toArray()[0];
    }

    public ArrayList<String> getVertexAdjVertex(String label) {
        return this.graphMap.get(label);
    }

    public void addVertex(String label) {
        this.graphMap.put(label, new ArrayList<>());
    }

    public void removeVertex(String label) {
        ArrayList<String> adjVertices = this.graphMap.get(label);

        if (adjVertices != null) {
            adjVertices.forEach( vertex -> {
                ArrayList<String> vertexAdjVertices = this.graphMap.get(vertex);
                vertexAdjVertices.remove(label);
            });
            this.graphMap.remove(label);
        }
    }

    public void addEdge(String label1, String label2) {
        ArrayList<String> adjVertices1 = this.graphMap.get(label1);
        ArrayList<String> adjVertices2 = this.graphMap.get(label2);

        if (adjVertices1 != null && adjVertices2 != null) {
            if (!adjVertices1.contains(label2))
                adjVertices1.add(label2);
            if (!adjVertices2.contains(label1))
                adjVertices2.add(label1);
        }
    }

    public void removeEdge(String label1, String label2) {
        ArrayList<String> adjVertices1 = this.graphMap.get(label1);
        ArrayList<String> adjVertices2 = this.graphMap.get(label2);

        if (adjVertices1 != null && adjVertices2 != null) {
            adjVertices1.remove(label2);
            adjVertices2.remove(label1);
        }
    }

    public void print() {
        this.graphMap.keySet().forEach(key -> {
            System.out.print("Vertex \"" + key + "\": ");
            ArrayList<String> adjList = this.graphMap.get(key);
            adjList.forEach( val -> {
                System.out.print("\"" + val + "\" ");
            });
            System.out.println();
        });
    }

}
