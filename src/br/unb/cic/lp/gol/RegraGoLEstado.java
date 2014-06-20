package br.unb.cic.lp.gol;

public class RegraGoLEstado extends RegraGoLPadrao {

	@Override
	protected TabelaEstado[] obterTabelaEstados() {
		TabelaEstado[] tb =  new TabelaEstado[14];							
		TabelaEstado[] stb = super.obterTabelaEstados();
		
		for (int i = 0; i < 14; i++)
		{
			tb[i] = new TabelaEstado();
		}
		
		tb[0] = stb[0];
		tb[1] = stb[1];
		tb[2] = stb[2];
		tb[3] = stb[3];
		tb[4] = stb[4];
		tb[5] = stb[5];
		tb[6] = stb[6];
		tb[7] = stb[7];
		
		tb[3].setProximoEstado(EstadoPreVivoX.class);		
		tb[4].setProximoEstado(EstadoPreVivoX.class);
					
		tb[8].setEstadoAtual(EstadoVivoX.class);
		tb[8].setProximoEstado(EstadoPreMorto.class);
		tb[8].setEstadoVizinho(EstadoVivo.class);
		tb[8].setQuantidadeVizinhos(0);
		
		tb[9].setEstadoAtual(EstadoVivoX.class);
		tb[9].setProximoEstado(EstadoPreMorto.class);
		tb[9].setEstadoVizinho(EstadoVivo.class);
		tb[9].setQuantidadeVizinhos(1);
		
		tb[10].setEstadoAtual(EstadoVivoX.class);
		tb[10].setProximoEstado(null);
		tb[10].setEstadoVizinho(EstadoVivo.class);
		tb[10].setQuantidadeVizinhos(2);
		
		tb[11].setEstadoAtual(EstadoVivoX.class);
		tb[11].setProximoEstado(null);
		tb[11].setEstadoVizinho(EstadoVivo.class);
		tb[11].setQuantidadeVizinhos(3);
		
		tb[12].setEstadoAtual(EstadoVivoX.class);
		tb[12].setProximoEstado(EstadoPreMorto.class);
		tb[12].setEstadoVizinho(EstadoVivo.class);
		tb[12].setQuantidadeVizinhos(-1);
		
		tb[13].setEstadoAtual(EstadoPreVivoX.class);
		tb[13].setProximoEstado(EstadoVivoX.class);
		tb[13].setEstadoVizinho(EstadoVivo.class);
		tb[13].setQuantidadeVizinhos(-1);
		
		return tb;
	}

}
