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
    void addEdgge(int vertice, int weight);
    bool DFS(int vertice, int goal, int max_depth);
};

Graph::Graph(int Vertice)
{
    this -> vertices = Vertice;
    adjacente = new list<int>[Vertice];
}

void Graph::addEdgge(int vertice, int weigth)
{
    adjacente[vertice].push_back(weigth);
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

    graph.addEdgge(0, 3);
    graph.addEdgge(0, 1);
    graph.addEdgge(1, 2);
    graph.addEdgge(1, 4);
    graph.addEdgge(2, 3);
    graph.addEdgge(3, 1);
    graph.addEdgge(3, 5);
    graph.addEdgge(4, 5);
    graph.addEdgge(5, 1);
    graph.addEdgge(6, 0);
    graph.addEdgge(7, 2);
    graph.addEdgge(8, 5);
    graph.addEdgge(9, 6);
    graph.addEdgge(10, 8);
    graph.addEdgge(11, 8);
    graph.addEdgge(12, 7);
    graph.addEdgge(13, 5);
    graph.addEdgge(14, 6);
    graph.addEdgge(15, 8);
    graph.addEdgge(16, 9);
    graph.addEdgge(17, 4);
    graph.addEdgge(18, 7);
    graph.addEdgge(19, 1);
    graph.addEdgge(20, 17);

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
