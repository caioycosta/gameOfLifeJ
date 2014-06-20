package br.unb.cic.lp.gol;

public abstract class TemplateRegraGoL {
	public EstadoAbstrato proximoEstado(Cell ctx, EstadoAbstrato estadoAtual)
	{
		TabelaEstado[] tbl = obterTabelaEstados();
		for (TabelaEstado trans : tbl)
		{
			boolean isinst = trans.getEstadoAtual().equals(estadoAtual.getClass());
			
			if (isinst
			&& (numberOfNeighborhoodStateCells(ctx.getY(), ctx.getX(), 
			ctx.getTabuleiro(), ctx, trans.getEstadoVizinho()) == trans.getQuantidadeVizinhos()
			|| trans.getQuantidadeVizinhos() == -1))
			{
				try {
					if (trans.getProximoEstado() == null) return null;
					return (EstadoAbstrato) trans.getProximoEstado().newInstance();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	protected abstract TabelaEstado[] obterTabelaEstados();
	
	/*
	 * Computa o numero de celulas vizinhas vivas, dada uma posicao no ambiente
	 * de referencia identificada pelos argumentos (i,j).
	 */
	protected int numberOfNeighborhoodStateCells(int i, int j, Cell[][] cells, Cell ctx, Class estadoAChecar) {
		int alive = 0;
		for (int a = i - 1; a <= i + 1; a++) {
			for (int b = j - 1; b <= j + 1; b++) {
				if (validPosition(a, b, ctx)  && (!(a==i && b == j)) && 
						estadoAChecar.isInstance( cells[a][b].getEstado())) {
					alive++;
				}
			}
		}
		return alive;
	}

	/*
	 * Verifica se uma posicao (a, b) referencia uma celula valida no tabuleiro.
	 */
	protected boolean validPosition(int a, int b, Cell ctx) {
		return a >= 0 && a < ctx.getHeight() && b >= 0 && b < ctx.getWidth();
	}
}
