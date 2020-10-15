/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscas;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Uso Exclusivo
 */
public class Extensao extends Busca{
    
    // Fila de dados FiFo
	private Queue<No> filaNos;
		
	public Extensao(int valorBusca) {
		this.filaNos = new LinkedList<No>();
		this.setValorBusca(valorBusca);
	}
	
	@Override
	public boolean buscarResultado(No no) {
		if (isResultadoBusca(no)) {
			// Se for o objetivo
			obterResultadoPaternal(no);
			return true;
		} else {			
			// Adicionar os nós na fila
			if (no.getNoEsquerda() != null) {
				this.filaNos.add(no.getNoEsquerda());
			}
			if (no.getNoDireita() != null) {
				this.filaNos.add(no.getNoDireita());
			}
			
			No noPonta = this.filaNos.poll();
			if (noPonta != null && buscarResultado(noPonta)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int contarNosFolha() {
		if (this.filaNos != null) {
			return this.filaNos.size();
		}
		return 0;
	}

    void buscarResultado(Grafo g) {
        if (isResultadoBusca(g)) {
			// Se for o objetivo
			obterResultadoPaternal(g);
			return true;
		} else {			
			// Adicionar os nós na fila
			if (g.getNoEsquerda() != null) {
				this.filaNos.add(g.getNoEsquerda());
			}
			if (g.getNoDireita() != null) {
				this.filaNos.add(g.getNoDireita());
			}
			
			Grafo noPonta = this.filaNos.poll();
			if (noPonta != null && buscarResultado(noPonta)) {
				return true;
			}
		}
		return false;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
