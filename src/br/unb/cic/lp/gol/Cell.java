package br.unb.cic.lp.gol;

public class Cell {
	private EstadoAbstrato estadoAtual;

	public boolean isAlive() {
		return estadoAtual.isAlive(this);
	}

	public void kill() {
		estadoAtual.kill(this);
	}
	
	public void revive() {
		estadoAtual.revive(this);
	}
	
	public void setEstado(EstadoAbstrato proximoEstado)
	{
		estadoAtual = proximoEstado;
	}
}
