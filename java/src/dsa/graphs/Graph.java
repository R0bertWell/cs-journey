package dsa.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {
    HashMap<String, List<String>> adjacencyList;

    public Graph(){
        adjacencyList = new HashMap<>();
    }

    public boolean addVertex(String vertice){
        if(!this.adjacencyList.containsKey(vertice)){
            ArrayList<String> list = new ArrayList<>();
            this.adjacencyList.put(vertice, list);
            return true;
        }
        return false;
    }

    public boolean addEdge(String vertice, String edge){
        if(this.adjacencyList.containsKey(vertice) && this.adjacencyList.containsKey(edge)){
            if(!this.adjacencyList.get(vertice).contains(edge)) {
                this.adjacencyList.get(vertice).add(edge);
            }
            if(!this.adjacencyList.get(edge).contains(vertice)){
                this.adjacencyList.get(edge).add(vertice);
            }
            return true;
        }

        return false;
    }

    public boolean removeEdge(String vertice, String edge){
        if(this.adjacencyList.containsKey(vertice) && this.adjacencyList.get(vertice).contains(edge)){
            this.adjacencyList.get(vertice).remove(edge);
            if(this.adjacencyList.containsKey(edge)){
                this.adjacencyList.get(edge).remove(vertice);
            }
            return true;
        }

        return false;
    }

    private void removeVertice(String vertice) {

        if(this.adjacencyList.containsKey(vertice)){
            List<String> toRemoveEdge = this.adjacencyList.get(vertice);
            this.adjacencyList.remove(vertice);
            for(String edge : toRemoveEdge){
                this.adjacencyList.get(edge).remove(vertice);
                /*if(edges != null){
                    edges.remove(vertice);
                }*/
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        graph.addEdge("A", "B");
        graph.addEdge("B", "A");
        graph.addEdge("B", "C");
        graph.addEdge("C", "A");
        graph.removeVertice("A");
        System.out.println(graph.adjacencyList.toString());
    }
}
