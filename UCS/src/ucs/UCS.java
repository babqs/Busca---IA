package ucs;

public class UCS {

    //função para encontrar o vértice de valor menor de distância
    static final int verticeMenor = 9;

    public int distancia(int dist[], Boolean sptSet[]) {
        //inicializa valor minimo
        int minimo = Integer.MAX_VALUE, min_index = -1;

        for (int i = 0; i < verticeMenor; i++) {
            if (sptSet[i] == false && dist[i] <= minimo) {
                minimo = dist[i];
                min_index = i;
            }
        }
        return min_index;
    }

    //mostra a distancia 
    public void imprimeDistancia(int dist[], int n) {
        System.out.println("Distância do vértice da fonte");
        for (int i = 0; i < verticeMenor; i++) {
            System.out.println(i + " distancia " + dist[i]);
        }
    }

    // Função que implemente Djkstra's algoritmo para um graforepresentado de matiz adjacente
    public void dijkstra(int graph[][], int src) {
        // a menor distancia de src a i
        int dist[] = new int[verticeMenor];

        // verifica se é o menor caminho dizendo true ou false
        Boolean sptSet[] = new Boolean[verticeMenor];

        // Inicializa todas as distâncias como inifinitas e sptSet[] como falso
        for (int i = 0; i < verticeMenor; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        // A distância do vértice da fonte de si mesmo é sempre 0 
        dist[src] = 0;

        // encontra o menor caminho para todos os vértices
        for (int count = 0; count < verticeMenor - 1; count++) {
            // pega a distancia minima dos vertices não processados
            int d = distancia(dist, sptSet);

            // marca como processado
            sptSet[d] = true;

            // Atualiza a distancia do valor dos vertices adjacentes 
            for (int i = 0; i < verticeMenor; i++) {
                // de d para i, e o peso total do caminho de src para v através de d é menor do que o valor actual de dist[i] 
                if (!sptSet[i] && graph[d][i] != 0 && dist[d] != Integer.MAX_VALUE && dist[d] + graph[d][i] < dist[i]) {
                    dist[i] = dist[d] + graph[d][i];
                }
            }
        }
        imprimeDistancia(dist, verticeMenor);
    }

    public static void main(String[] args) {
        //exemplo de grafo
        int graph[][] = new int[][]{{329, 253, 374},
                                    {244},
                                    {193, 176},
                                    {380},
                                    {241},
                                    {160, 100},
                                    {0},
                                    {253},
                                    {242},
                                    {193, 100},
                                    {0},
                                    {77, 80},
                                    {160},
                                    {100},
                                    {},
                                    {151, 199},
                                    {161},
                                    {226},
                                    {},
                                    {234},
                                    {}};

        UCS u = new UCS();
        UCS u1 = new UCS();
        UCS u2 = new UCS();
        UCS u3 = new UCS();

        u.dijkstra(graph, 0);
        u1.dijkstra(graph, 1);
        u2.dijkstra(graph, 2);
        u3.dijkstra(graph, 3);
    }
}

//    'Arad': ['Timisoara', 'Sibiu', 'Zerind'],      Arad - 366         Rimnicu Vilcea - 193
//    'Timisora': ['', 'Lugoj'],                    Bucharest - 0       Sibiu - 253
//    'Sibiu': ['Rimnicu Vilces', 'Fagaras'],       Craiova - 160       Timisora - 329
//    'Zerind': ['', 'Oradea'],                    Drobeta - 242        Urziceni - 80
//    'Lugoj': ['Mehadia', ''],                    Eforie - 161        Vaslui - 199
//    'Rimnicu Vilces': ['Craiova', 'Pitesti'],    Fagaras - 176        Zerind - 374
//    'Fagaras': ['', 'Bucharest'],                Giurgiu - 77
//    'Oradea': ['', 'Sibiu'],                     Hirsova - 151
//    'Mehadia': ['Dobreta', ''],                  Iasi - 226
//    'Cariova': ['Rimnciu Vilcea', 'Pistesti'],   Lugoj - 244
//    'Pitesti': ['Bucharest'],                    Mehadia - 241
//    'Bucharest': ['Giurgiu', 'Urziceni'],                            Neamt - 234
//    'Dobreta': ['Craiova'],                    Oradea - 380
//    'Craiova': ['Pitesti'],                      Pitesti - 100
//    'Giurgiu': [''],
//    'Urziceni': ['Hirsova', 'Vaslui'],
//    'Hirsova': ['Eforie'],
//    'Vaslui': ['Iasi'],
//    'Eforie': [],
//    'Iasi': ['Neamt'],
//    'Neamt': [],