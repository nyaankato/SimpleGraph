package com.graph;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Graph<Integer> graph = new Graph();
        graph.addVertices(List.of(1,2,3,4,5,6,7,8));
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(1,4);
        graph.addEdge(2,5);
        graph.addEdge(2,6);
        graph.addEdge(3,6);
        graph.addEdge(4,7);
        graph.addEdge(4,8);

        graph.getPath(5,8);
    }
}
