package controller;

import java.util.List;

import dao.ChamadoDao;
import dao.VeiculoDao;
import exception.RegraNegocioException;
import model.Chamado;

public class ChamadoController {

	public void criarChamado(Chamado chamado) throws RegraNegocioException {
		if (chamado.getDataInicio() == null) {
			throw new RegraNegocioException("Erro: Data de in�cio inv�lida.");
		}
		
		if (chamado.getEndereco() == null || chamado.getEndereco().length() < 5) {
			throw new RegraNegocioException("Erro: Endere�o inv�lido.");
		}
		
		if (!chamado.getColaborador().isHabilitado()) {
			throw new RegraNegocioException("Erro: Colaborador n�o habilitado.");
		}
		
		if (!chamado.getVeiculo().isDisponivel()) {
			throw new RegraNegocioException("Erro: Ve�culo n�o dispon�vel.");
		}
		
		ChamadoDao.getInstance().criarChamado(chamado);
		VeiculoDao.getInstance().tornarIndisponivel(chamado.getVeiculo());
	}
	
	public void encerrarChamado(Chamado chamado) throws RegraNegocioException {
		if (chamado.getDataFim() == null) {
			throw new RegraNegocioException("Erro: Data de encerramento inv�lida.");
		}
		
		ChamadoDao.getInstance().atualizar(chamado);
		VeiculoDao.getInstance().tornarDisponivel(chamado.getVeiculo());
	}
	
	public void excluir(int id) throws RegraNegocioException {
		if (id == 0) {
			throw new RegraNegocioException("Erro: Id chamado inv�lido");
		}
		
		ChamadoDao.getInstance().excluir(id);
	}
	
	public List<Chamado> listar() throws RegraNegocioException {
		List<Chamado> chamados = ChamadoDao.getInstance().listar();
		
		if(chamados.isEmpty()) {
			throw new RegraNegocioException("Erro: N�o existem chamados cadastrados.");
		}
		
		return chamados;
	}
	
	public Chamado listById(int id) {
		return ChamadoDao.getInstance().listById(id);
	}
	
}
