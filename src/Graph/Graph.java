/*
 * @Author: Ereflect
 * @Date: 2023-02-07 12:36:47
 * @LastEditors: Please set LastEditors
 * @LastEditTime: 2023-02-07 18:04:24
 * @Description: adjacency list / bfs
 */
package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
    private int size;
    private List<Integer>[] adjacencyList;

    public Graph(int size) {
        this.size = size;
        this.adjacencyList = new ArrayList[size];
        for (int i = 0; i < size; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int src, int dest) {
        adjacencyList[src].add(dest);
    }

    public void bfs(int start) {
        boolean[] visited = new boolean[size];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            for (int neighbor : adjacencyList[node]) {
                if (!visited[neighbor]) {
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 2);
        graph.addEdge(3, 3);
        System.out.println("Following is Breadth First Traversal " +
                "(starting from vertex 2)");
        graph.bfs(2);
    }
}
