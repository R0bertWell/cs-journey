package problem_solving.interview;

import java.util.*;

public class SignalPathAnalyzer {
    // Classe que representa uma aresta do grafo
    static class Edge {
        int to;
        int weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    // Classe usada na BFS para armazenar o estado atual do caminho
    static class State {
        int currentNode;
        int totalWeight;
        Set<Integer> visited;

        State(int currentNode, int totalWeight, Set<Integer> visited) {
            this.currentNode = currentNode;
            this.totalWeight = totalWeight;
            this.visited = visited;
        }
    }

    public static List<Integer> getReachableNodesWithDivisiblePaths(
            int totalNodes,
            List<Integer> from,
            List<Integer> to,
            List<Integer> weights,
            int signalSpeed) {

        // 1. Construir o grafo como uma lista de adjacência
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int i = 1; i <= totalNodes; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < from.size(); i++) {
            int u = from.get(i);
            int v = to.get(i);
            int w = weights.get(i);

            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));  // Grafo não direcionado
        }

        List<Integer> result = new ArrayList<>();

        // 2. Para cada nó, fazer BFS e verificar quantos nós pode alcançar com soma divisível
        for (int startNode = 1; startNode <= totalNodes; startNode++) {
            Set<Integer> validDestinations = new HashSet<>();

            Queue<State> queue = new LinkedList<>();
            queue.offer(new State(startNode, 0, new HashSet<>(Set.of(startNode))));

            while (!queue.isEmpty()) {
                State state = queue.poll();

                for (Edge edge : graph.get(state.currentNode)) {
                    int nextNode = edge.to;
                    int newSum = state.totalWeight + edge.weight;

                    // Evitar ciclos
                    if (state.visited.contains(nextNode)) continue;

                    Set<Integer> newVisited = new HashSet<>(state.visited);
                    newVisited.add(nextNode);

                    if (newSum % signalSpeed == 0) {
                        validDestinations.add(nextNode);
                    }

                    queue.offer(new State(nextNode, newSum, newVisited));
                }
            }

            result.add(validDestinations.size());
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = getReachableNodesWithDivisiblePaths(
                4,
                List.of(1, 1, 2),
                List.of(2, 3, 4),
                List.of(2, 5, 3),
                5
        );
        System.out.println(result); // Esperado: [2, 0, 2, 2]
    }
}
