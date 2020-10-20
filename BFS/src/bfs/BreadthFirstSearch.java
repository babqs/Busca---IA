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

        BreadthFirstSearch g = new BreadthFirstSearch(6);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 5);

        Scanner s = new Scanner(System.in);

        System.out.print("Escolha um numero de 0-5 para o vertice inicial: ");
        int vInicial = s.nextInt();

        g.BFS(vInicial);
    }

}