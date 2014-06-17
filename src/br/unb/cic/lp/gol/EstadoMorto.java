package br.unb.cic.lp.gol;

public class EstadoMorto extends EstadoAbstrato {

	@Override
	public boolean isAlive(Cell ctx) {		
		return false;
	}

	@Override
	public void kill(Cell ctx) {
		ctx.setEstado(new EstadoMorto());
	}

	@Override
	public void revive(Cell ctx) {
		ctx.setEstado(new EstadoVivo());
	}
	
}
