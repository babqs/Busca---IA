#include <iostream>
#include <list>
using namespace std;

class Graph
{
    int vertices;
    list<int> *adjacente;

    bool DLS(int vertices, int goal, int limit);

public:
    Graph(int Vertice);
    void addEdge(int v, int w);
    bool DFS(int vertice, int goal, int max_depth);
};

Graph::Graph(int Vertice)
{
    this -> vertices = Vertice;
    adjacente = new list<int>[Vertice];
}

void Graph::addEdge(int v, int w)
{
    adjacente[v].push_back(w);
}

bool Graph::DLS(int source, int goal, int limit)
{
    if(source == goal)
        return true;

    if(limit <= 0)
        return false;

    for(auto i = adjacente[source].begin(); i != adjacente[source].end(); i++)
        if(DLS(*i, goal, limit-1) == true)
            return true;

    return false;
}

bool Graph::DFS(int source, int goal, int max_depth)
{
    for(int i = 0; i <= max_depth; i++)
        if(DLS(source, goal, i) == true)
            return true;

    return false;
}

int main()
{
    Graph graph(21);

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

    int source, goal, max_depth;

    cout << "Enter the source: ";
    cin >> source;
    cout << "Enter the goal: ";
    cin >> goal;
    cout << "Enter the mas depth: ";
    cin >> max_depth;

    if(graph.DFS(source, goal, max_depth) == true)
        cout <<"The goal is reachable from source within max depth";
    else
        cout << "The goal is not reachable from source within max depth";

    return 0;
}
