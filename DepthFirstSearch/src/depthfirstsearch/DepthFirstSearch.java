package depthfirstsearch;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

class DepthFirstSearch {

    //numero de vertices
    private final int vertice;

    // array para representar a lista adjacente
    private final LinkedList<Integer> adj[];

    public DepthFirstSearch(int v) {
        vertice = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        }
    }

    //Função para adicionar ponto nó no grafo
    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public void DFSUtil(int v, boolean visited[]) {
        //Marca o no como visitado e o imprime
        visited[v] = true;
        System.out.print(v + " \n");

        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    void DFS(int v) {
        // Marca todos os vertices como nao visitado
        boolean visited[] = new boolean[vertice];

        //Chama a função recursiva para mostrar na tela
        DFSUtil(v, visited);
    }

    public static void main(String args[]) {
        DepthFirstSearch graph = new DepthFirstSearch(21);

        graph.addEdge(0, 3);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
        graph.addEdge(5, 1);
        graph.addEdge(6, 0);
        graph.addEdge(7, 2);
        graph.addEdge(8, 5);
        graph.addEdge(9, 6);
        graph.addEdge(10, 8);
        graph.addEdge(11, 8);
        graph.addEdge(12, 7);
        graph.addEdge(13, 5);
        graph.addEdge(14, 6);
        graph.addEdge(15, 8);
        graph.addEdge(16, 9);
        graph.addEdge(17, 4);
        graph.addEdge(18, 7);
        graph.addEdge(19, 1);
        graph.addEdge(20, 17);

        Scanner s = new Scanner(System.in);
        
        System.out.print("Escolha um numero entre 0-21 para o vertice inicial: ");

        int vInicial = s.nextInt();

        graph.DFS(vInicial);
    }
}
