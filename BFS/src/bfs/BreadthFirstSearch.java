package bfs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class BreadthFirstSearch {

    // No. de vértices
    private int noVertice;
    //lista adjacente
    private LinkedList<Integer> adj[];

    public BreadthFirstSearch(int noV) {
        noVertice = noV;
        adj = new LinkedList[noV];
        for (int i = 0; i < noV; ++i) {
            adj[i] = new LinkedList();
        }
    }

    // função para adicionar um ponto (no) no grafo
    public void addEdge(int noV, int w) {
        adj[noV].add(w);
    }

    // imprime BFS transversal 
    public void BFS(int s) {
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

        BreadthFirstSearch g = new BreadthFirstSearch(21);

    g.addEdge(0, 3);
    g.addEdge(0, 1);
    g.addEdge(1, 2);
    g.addEdge(1, 4);
    g.addEdge(2, 3);
    g.addEdge(3, 1);
    g.addEdge(3, 5);
    g.addEdge(4, 5);
    g.addEdge(5, 1);
    g.addEdge(6, 0);
    g.addEdge(7, 2);
    g.addEdge(8, 5);
    g.addEdge(9, 6);
    g.addEdge(10, 8);
    g.addEdge(11, 8);
    g.addEdge(12, 7);
    g.addEdge(13, 5);
    g.addEdge(14, 6);
    g.addEdge(15, 8);
    g.addEdge(16, 9);
    g.addEdge(17, 4);
    g.addEdge(18, 7);
    g.addEdge(19, 1);
    g.addEdge(20, 17);

        Scanner s = new Scanner(System.in);

        System.out.print("Escolha um numero de 0-21 para o vertice inicial: ");
        int vInicial = s.nextInt();

        g.BFS(vInicial);
    }

}