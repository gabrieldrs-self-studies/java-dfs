package util.generators;

import lib.Graph;
import util.RandomString;

import java.util.ArrayList;
import java.util.Random;

public class BinaryTreeGenerator implements IGenerator {

    // This has no indication of right/left, but will suffice for the time being
    public Graph generate() {
        Graph g = new Graph();
        Random r = new Random();
        int numberOfVertices = r.nextInt(5)+10;

        ArrayList<String> verticesList = new ArrayList<>();

        for (int i = 0; i < numberOfVertices; i++) {
            String vertex = RandomString.generateRandomString(10);
            verticesList.add(vertex);
            g.addVertex(vertex);
        }

        ArrayList<String> levelNodes = new ArrayList<>();
        ArrayList<String> remainingVertices = (ArrayList<String>) verticesList.clone();
        levelNodes.add(g.getRoot());
        remainingVertices.remove(g.getRoot());
        while (levelNodes.size() > 0) {
            ArrayList<String> nextLevelNodes = new ArrayList<>();
            levelNodes.forEach( node -> {

                for (int i = 0; i < 2 && remainingVertices.size() > 0; i++) {
                    String child = remainingVertices.remove(0);
                    g.addEdge(node, child);
                    nextLevelNodes.add(child);
                }
            });
            levelNodes = nextLevelNodes;
        }
        return g;
    }

}
