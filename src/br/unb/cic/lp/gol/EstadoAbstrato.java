package br.unb.cic.lp.gol;

public abstract class EstadoAbstrato {

	public boolean tentarMudarEstado(Cell ctx) {
		
		EstadoAbstrato proximo = ctx.getRegra().proximoEstado(ctx, this);
		
		if (proximo == null) return false;
		ctx.setEstado(proximo);
		return true;
		
	}
}
