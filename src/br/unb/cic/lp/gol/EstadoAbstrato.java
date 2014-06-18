package br.unb.cic.lp.gol;

public abstract class EstadoAbstrato {
	public abstract void mudarEstado(Cell ctx);	
	public abstract boolean deveManterEstado(Cell ctx);	
}
