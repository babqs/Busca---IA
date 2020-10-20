#include <iostream>
#include <vector>
#include <list>
#include <queue>
#include <algorithm>
#include<stdlib.h>
using namespace std;

struct pQ{
    //caminho
	list<int> path;
	int cost;
	bool operator>(const pQ& rhs) const
	{
		return cost > rhs.cost;
	}
};

class comparison{
public:
	bool operator() (pQ p1, pQ p2) const{
		//comparando valores
		return (p1>p2);
	}
};

class Graph{
	int V;
	vector<int> *adj;
	vector<int> *wgt;
public:
	Graph(int V);
	void addEdge(int v, int w, int wgt);
	void UCF(int s, int t);
	void displayPath(struct pQ f);
};

Graph::Graph(int V)
{
	this->V = V;
	adj = new vector<int>[V];
	wgt = new vector<int>[V];
}

void Graph::addEdge(int v, int w, int wt) {
	adj[v].push_back(w);
	wgt[v].push_back(wt);

	//non-directed graph
	adj[w].push_back(v);
	wgt[w].push_back(wt);
}

void Graph::UCF(int s, int t){
	int current = 0, pos = 0;
	typedef priority_queue<pQ, vector<pQ>, comparison> mypq_type;
	mypq_type pq;

	pQ vstart;

	vstart.path.push_back(s);
	vstart.cost = 0;

	vector<int>::iterator i;
	pq.push(vstart);

	while(!pq.empty()){
		pQ currentPQ, tempPQ;
		current = pq.top().path.back();
		currentPQ = pq.top();

		pq.pop();
		if(current == t)
		{
			cout<<"found"<<endl;
			displayPath(currentPQ);
			exit(0);
		}
		else{
			for (i = adj[current].begin(); i != adj[current].end(); ++i)
			{
				tempPQ = currentPQ;
				tempPQ.path.push_back(*i);
				pos = find(adj[current].begin(), adj[current].end(), *i) - adj[current].begin();
				tempPQ.cost += wgt[current].at(pos);
				pq.push(tempPQ);
			}
		}
	}
}

void Graph::displayPath(struct pQ p)
{
  list<int>::iterator i;
	cout<<"Path: ";
  for (i = p.path.begin(); i != p.path.end(); ++i)
  {
    cout<<"->"<<*i;
  }
	cout<<endl;
  cout<<"Pathlength: "<<p.cost;
}

int main()
{
	int vstart = 0, vend = 0;
    Graph g(21);
	g.addEdge(0, 3, 7);
    g.addEdge(0, 1, 5);
    g.addEdge(1, 2, 3);
    g.addEdge(1, 4, 7);
    g.addEdge(2, 3, 4);
    g.addEdge(3, 1, 4);
    g.addEdge(3, 5, 2);
    g.addEdge(4, 5, 3);
    g.addEdge(5, 1, 1);
    g.addEdge(6, 0, 4);
    g.addEdge(7, 2, 6);
    g.addEdge(8, 5, 7);
    g.addEdge(9, 6, 8);
    g.addEdge(10, 8, 9);
    g.addEdge(11, 8, 10);
    g.addEdge(12, 7, 9);
    g.addEdge(13, 5, 10);
    g.addEdge(14, 6, 9);
    g.addEdge(15, 8, 11);
    g.addEdge(16, 9, 11);
    g.addEdge(17, 4, 12);
    g.addEdge(18, 7, 15);
    g.addEdge(19, 1, 14);
    g.addEdge(20, 2, 16);


	cout<<"Start vertex (Vertice inicial):";
	cin>>vstart;
	cout<<"End vertex (Vertice final):";
	cin>>vend;

	g.UCF(vstart, vend);
	return 0;
}
