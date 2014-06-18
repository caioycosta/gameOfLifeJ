package br.unb.cic.lp.gol;

public class EstadoPreVivo extends EstadoAbstrato {

	@Override
	public boolean tentarMudarEstado(Cell ctx) {
		ctx.setEstado(new EstadoVivo());
		return true;
	}

}
