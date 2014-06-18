package br.unb.cic.lp.gol;

public class EstadoMorto extends EstadoAbstrato {

	@Override
	public boolean tentarMudarEstado(Cell ctx) {
		int i, j;
		Cell[][] cells;
		
		i = ctx.getY();
		j = ctx.getX();
		cells = ctx.getTabuleiro();
		
		if ( numberOfNeighborhoodAliveCells(i, j, cells, ctx) == 3 )
		{
			ctx.setEstado(new EstadoPreVivo());
			return true;
		}
		
		return false;
	}

	/*
	 * Computa o numero de celulas vizinhas vivas, dada uma posicao no ambiente
	 * de referencia identificada pelos argumentos (i,j).
	 */
	private int numberOfNeighborhoodAliveCells(int i, int j, Cell[][] cells, Cell ctx) {
		int alive = 0;
		for (int a = i - 1; a <= i + 1; a++) {
			for (int b = j - 1; b <= j + 1; b++) {
				if (validPosition(a, b, ctx)  && (!(a==i && b == j)) && 
						(cells[a][b].getEstado() instanceof EstadoVivo || cells[a][b].getEstado() instanceof EstadoPreMorto)) {
					alive++;
				}
			}
		}
		return alive;
	}

	/*
	 * Verifica se uma posicao (a, b) referencia uma celula valida no tabuleiro.
	 */
	private boolean validPosition(int a, int b, Cell ctx) {
		return a >= 0 && a < ctx.getHeight() && b >= 0 && b < ctx.getWidth();
	}
	
}
