package br.unb.cic.lp.gol;

public class EstadoPreMorto extends EstadoVivo {

	@Override
	public boolean tentarMudarEstado(Cell ctx) {
		ctx.setEstado(new EstadoMorto());
		return true;
	}

}
