/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscas;

/**
 *
 * @author Uso Exclusivo
 */
public class Principal {
    
    public static void main(String[] args){
//                No no0 = new No("Arad");
//		No no1 = new No("Timissora");
//		No no2 = new No("Sibiu");
//		No no3 = new No("Zerind");
//		No no4 = new No("Lugoj");
//		No no5 = new No("Riminicu Vilces");
//		No no6 = new No("Fagares");
//		
//		no0.setNoEsquerda(no1);
//		//no0.setNoDireita(no 2);
//		
//		no1.setNoEsquerda(no3);
//		no1.setNoDireita(no4);
//		
//		no2.setNoEsquerda(no5);
//		no2.setNoDireita(no6);
//                
////                Profundidade profundidade = new Profundidade(4);
////                profundidade.exibirTextoResultado();
//
////
////Extensao extensao = new Extensao(5);
////extensao.exibirTextoResultado();

Grafo g = new Grafo();
        Grafo.Vertice arad = g.addVertice("Arad");
        Grafo.Vertice timisoara = g.addVertice("Timisoara");
        Grafo.Vertice sibiu = g.addVertice("Sibiu");
        Grafo.Vertice zerind = g.addVertice("Zerind");
        Grafo.Vertice lugoj = g.addVertice("Lugoj");
        Grafo.Vertice rimnicuVilces = g.addVertice("Rimnicu Vilces");
        Grafo.Vertice fagaras = g.addVertice("Fagaras");
        Grafo.Vertice oradea = g.addVertice("Oradea");
        Grafo.Vertice mehadia = g.addVertice("Mehadia");
        Grafo.Vertice craiova = g.addVertice("Craiova");
        Grafo.Vertice pitesti = g.addVertice("Pitesti");
        Grafo.Vertice bucharest = g.addVertice("Bucharest");
        Grafo.Vertice dobreta = g.addVertice("Dobreta");
        
        Grafo.Aresta at = g.addAresta(arad, timisoara);
        Grafo.Aresta as = g.addAresta(arad, sibiu);
        Grafo.Aresta az = g.addAresta(arad, zerind);
        Grafo.Aresta tl = g.addAresta(timisoara, lugoj);
        Grafo.Aresta sr = g.addAresta(sibiu, rimnicuVilces);
        Grafo.Aresta sf = g.addAresta(sibiu, fagaras);
        Grafo.Aresta zo = g.addAresta(zerind, oradea);
        Grafo.Aresta lm = g.addAresta(lugoj, oradea);
        Grafo.Aresta rc = g.addAresta(rimnicuVilces, craiova);
        Grafo.Aresta rp = g.addAresta(rimnicuVilces, pitesti);
        Grafo.Aresta fb = g.addAresta(fagaras, bucharest);
        Grafo.Aresta os = g.addAresta(oradea, sibiu);
        Grafo.Aresta md = g.addAresta(mehadia, dobreta);
        Grafo.Aresta cr = g.addAresta(craiova, rimnicuVilces);
        Grafo.Aresta cp = g.addAresta(craiova, pitesti);
        Grafo.Aresta pb = g.addAresta(pitesti, bucharest);
        Grafo.Aresta dc = g.addAresta(dobreta, craiova);
        
        System.out.println(g);
        
        Extensao extensao = new Extensao(5);
        extensao.buscarResultado(g);

    }
    
}
