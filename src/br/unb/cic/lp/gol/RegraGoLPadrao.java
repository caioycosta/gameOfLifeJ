package br.unb.cic.lp.gol;

public class RegraGoLPadrao extends TemplateRegraGoL {

	@Override
	protected TabelaEstado[] obterTabelaEstados() {
		TabelaEstado[] tb = new TabelaEstado[8];
		for (int i = 0; i < 8; i++)
		{
			tb[i] = new TabelaEstado();
		}
		tb[0].setEstadoAtual(EstadoMorto.class);
		tb[0].setProximoEstado(EstadoPreVivo.class);
		tb[0].setEstadoVizinho(EstadoVivo.class);
		tb[0].setQuantidadeVizinhos(3);
		
		tb[1].setEstadoAtual(EstadoVivo.class);
		tb[1].setProximoEstado(EstadoPreMorto.class);
		tb[1].setEstadoVizinho(EstadoVivo.class);
		tb[1].setQuantidadeVizinhos(0);
		
		tb[2].setEstadoAtual(EstadoVivo.class);
		tb[2].setProximoEstado(EstadoPreMorto.class);
		tb[2].setEstadoVizinho(EstadoVivo.class);
		tb[2].setQuantidadeVizinhos(1);
		
		tb[3].setEstadoAtual(EstadoVivo.class);
		tb[3].setProximoEstado(null);
		tb[3].setEstadoVizinho(EstadoVivo.class);
		tb[3].setQuantidadeVizinhos(2);
		
		tb[4].setEstadoAtual(EstadoVivo.class);
		tb[4].setProximoEstado(null);
		tb[4].setEstadoVizinho(EstadoVivo.class);
		tb[4].setQuantidadeVizinhos(3);
		
		tb[5].setEstadoAtual(EstadoVivo.class);
		tb[5].setProximoEstado(EstadoPreMorto.class);
		tb[5].setEstadoVizinho(EstadoVivo.class);
		tb[5].setQuantidadeVizinhos(-1);
		
		tb[6].setEstadoAtual(EstadoPreMorto.class);
		tb[6].setProximoEstado(EstadoMorto.class);
		tb[6].setEstadoVizinho(EstadoVivo.class);
		tb[6].setQuantidadeVizinhos(-1);
		
		tb[7].setEstadoAtual(EstadoPreVivo.class);
		tb[7].setProximoEstado(EstadoVivo.class);
		tb[7].setEstadoVizinho(EstadoVivo.class);
		tb[7].setQuantidadeVizinhos(-1);
		
		return tb;
	}
	
}
