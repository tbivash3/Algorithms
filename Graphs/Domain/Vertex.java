package Graphs.Domain;

import java.util.LinkedList;

public class Vertex {
    private LinkedList<Vertex> adjacents;

    public Vertex() {
        this.adjacents = new LinkedList<>();
    }

    public void addAdjacent(Vertex adjacentVertex) {
        adjacents.add(adjacentVertex);
    }

    public LinkedList<Vertex> getAdjacents() {
        return this.adjacents;
    }
}
