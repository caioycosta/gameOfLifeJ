package br.unb.cic.lp.gol;

public class EstadoVivo extends EstadoAbstrato {

	@Override
	public boolean isAlive(Cell ctx) {		
		return true;
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
