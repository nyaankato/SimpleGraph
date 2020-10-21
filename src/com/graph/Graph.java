package com.graph;

import java.util.*;

public class Graph<E> {

    private Map<E, List<E>> graph;

    private boolean isDirected;

    public Graph(Map<E, List<E>> graph, boolean isDirected) {
        this.graph = graph;
        this.isDirected = isDirected;
    }

    public Graph() {
        this.graph = new HashMap<E, List<E>>();
        this.isDirected = false;
    }

    public boolean isDirected() {
        return isDirected;
    }

    public void setDirected(boolean directed) {
        isDirected = directed;
    }

    public void addVertex(E vertex) {
        graph.put(vertex, new ArrayList<E>());
    }

    public void addVertices(List<E> vertices) {
        for (E vertex : vertices)
            addVertex(vertex);
    }

    public void addEdge(E from, E to) {
        if (graph.containsKey(from) & graph.containsKey(from))
            if (isDirected)
                graph.get(from).add(to);
            else {
                graph.get(from).add(to);
                graph.get(to).add(from);
            }
        //else throw exception
    }

    public void getPath(E from, E to) {
        Set<E> visited = new LinkedHashSet<E>();
        Queue<E> queue = new LinkedList<E>();
        Map<E, List<E>> paths = new HashMap<E, List<E>>();
        queue.add(from);
        visited.add(from);
        paths.put(from, new ArrayList() {{
            add(from);
        }});
        while (!queue.isEmpty()) {
            E vertex = queue.poll();
            if (vertex.equals(to)) {
                System.out.println(paths.get(vertex));
            }
            else
                for (E v : graph.get(vertex)) {
                    if (!visited.contains(v)) {
                        visited.add(v);
                        queue.add(v);
                        List<E> pathToV = new ArrayList<>(paths.get(vertex));
                        pathToV.add(v);
                        paths.put(v, pathToV);
                    }
                }
        }
    }
}

