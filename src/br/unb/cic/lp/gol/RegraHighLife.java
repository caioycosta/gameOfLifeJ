package br.unb.cic.lp.gol;

public class RegraHighLife extends RegraGoLPadrao {
	@Override
	protected TabelaEstado[] obterTabelaEstados() {
		TabelaEstado[] tb =  new TabelaEstado[9];							
		TabelaEstado[] stb = super.obterTabelaEstados();
		
		for (int i = 0; i < 9; i++)
		{
			tb[i] = new TabelaEstado();
		}
				
		tb[1] = stb[0];
		tb[2] = stb[1];
		tb[3] = stb[2];
		tb[4] = stb[3];
		tb[5] = stb[4];
		tb[6] = stb[5];
		tb[7] = stb[6];
		tb[8] = stb[7];
		
		tb[0].setEstadoAtual(EstadoMorto.class);
		tb[0].setProximoEstado(EstadoPreVivo.class);
		tb[0].setEstadoVizinho(EstadoVivo.class);
		tb[0].setQuantidadeVizinhos(6);
				
		return tb;
	}
}
