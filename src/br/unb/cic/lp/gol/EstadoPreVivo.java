package br.unb.cic.lp.gol;

public class EstadoPreVivo extends EstadoMorto {

	@Override
	public boolean tentarMudarEstado(Cell ctx) {
		ctx.setEstado(new EstadoVivo());
		return true;
	}

}
