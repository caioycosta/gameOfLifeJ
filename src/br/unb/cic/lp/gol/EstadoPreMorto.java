package br.unb.cic.lp.gol;

public class EstadoPreMorto extends EstadoAbstrato {

	@Override
	public boolean tentarMudarEstado(Cell ctx) {
		ctx.setEstado(new EstadoMorto());
		return true;
	}

}
