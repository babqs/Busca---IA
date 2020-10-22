#include <iostream>
#include <list>
#include <vector>
#include <stack>

using namespace std;

class Graph
{
    int vertice;
    list<int> *adj;

public:
    Graph(int vertice);
    void addEdge(int vertice, int weigth);
    void IDS(int source);
};

Graph::Graph(int v)
{
    this -> vertice = v;
    adj = new list<int>[v];
}

void Graph::addEdge(int vertice, int weigth)
{
    adj[vertice].push_back(weigth);
}

void Graph::IDS(int source)
{
    vector<bool> visited(vertice, false);

    stack<int> stack;

    stack.push(source);

    while(!stack.empty())
    {
        source = stack.top();
        stack.pop();

        if(!visited[source])
        {
            cout << source << " ";
            visited[source] = true;
        }

        for(auto i = adj[source].begin(); i != adj[source].end(); ++i)
            if(!visited[*i])
            stack.push(*i);
    }
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

    int s;

    cout << "Enter the source of the graph: ";
    cin >> s;

    graph.IDS(s);
}
