package bfs;

import java.util.Iterator;
import java.util.LinkedList;

public class BFS {

    // No. de vértices
    private int noVertice;
    //lista adjacente
    private LinkedList<Integer> adj[];

    BFS(int noV) {
        noVertice = noV;
        adj = new LinkedList[noV];
        for (int i = 0; i < noV; ++i) {
            adj[i] = new LinkedList();
        }
    }

    // função para adicionar um ponto (no) no grafo
    void addEdge(int noV, int w) {
        adj[noV].add(w);
    }

    // imprime BFS transversal 
    void BFS(int s) {
        // marca todos os vertices como não visitado 
        boolean visited[] = new boolean[noVertice];

        // cria uma fila 
        LinkedList<Integer> queue = new LinkedList<Integer>();
        
        // marca o no como visitado e o adiciona na fila
        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            //imprimie o vertice 
            s = queue.poll();
            System.out.print(s + " ");

            // pega todos os vertices adjacentes
            // marca como visitado e adiciona na fila
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {

        BFS g = new BFS(8);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 5);

        System.out.println("BFS: " + "começando do vértice 0");
        g.BFS(0);
        
        System.out.println("\nBFS: " + "começando do vértice 1");
        g.BFS(1);
        
        System.out.println("\nBFS: " + "começando do vértice 2");
        g.BFS(2);
        
        System.out.println("\nBFS: " + "começando do vértice 3");
        g.BFS(3);
        
        System.out.println("\nBFS: " + "começando do vértice 4");
        g.BFS(4);
        
        System.out.println("\nBFS: " + "começando do vértice 5");
        g.BFS(5);
    }

}
