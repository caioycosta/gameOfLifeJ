package br.unb.cic.lp.gol;

public abstract class EstadoAbstrato {
	public abstract boolean isAlive(Cell ctx);

	public abstract void kill(Cell ctx);
	
	public abstract void revive(Cell ctx);
}
