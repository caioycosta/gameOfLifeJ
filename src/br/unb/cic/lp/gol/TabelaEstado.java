package br.unb.cic.lp.gol;

public class TabelaEstado {
	/**
	 * @return the estadoAtual
	 */
	public Class getEstadoAtual() {
		return estadoAtual;
	}
	/**
	 * @param estadoAtual the estadoAtual to set
	 */
	public void setEstadoAtual(Class estadoAtual) {
		this.estadoAtual = estadoAtual;
	}
	/**
	 * @return the proximoEstado
	 */
	public Class getProximoEstado() {
		return proximoEstado;
	}
	/**
	 * @param proximoEstado the proximoEstado to set
	 */
	public void setProximoEstado(Class proximoEstado) {
		this.proximoEstado = proximoEstado;
	}
	/**
	 * @return the estadoVizinho
	 */
	public Class getEstadoVizinho() {
		return estadoVizinho;
	}
	/**
	 * @param estadoVizinho the estadoVizinho to set
	 */
	public void setEstadoVizinho(Class estadoVizinho) {
		this.estadoVizinho = estadoVizinho;
	}
	/**
	 * @return the quantidadeVizinhos
	 */
	public int getQuantidadeVizinhos() {
		return quantidadeVizinhos;
	}
	/**
	 * @param quantidadeVizinhos the quantidadeVizinhos to set
	 */
	public void setQuantidadeVizinhos(int quantidadeVizinhos) {
		this.quantidadeVizinhos = quantidadeVizinhos;
	}
	private Class estadoAtual;
	private Class proximoEstado;
	private Class estadoVizinho;
	private int quantidadeVizinhos;
}
