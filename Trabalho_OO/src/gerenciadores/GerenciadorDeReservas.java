package gerenciadores;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class GerenciadorDeReservas extends Gerenciador{
	
	private LinkedList<Reserva> reserva = new LinkedList<Reserva>();
	String strData;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
	Date data;
	
	public boolean reservaNormal() throws ParseException {
		Normal reservaNormal = new Normal();
		reservaNormal.setNumReserva(reserva.size()+1);
		
		strData = JOptionPane.showInputDialog("Data do início da reserva: ");
		data = dateFormat.parse(strData);
		reservaNormal.setDataInicio(data);
		strData = JOptionPane.showInputDialog("Data do início da reserva: ");
		data = dateFormat.parse(strData);
		reservaNormal.setDataFim(data);
		reservaNormal.setDiarias((int) (reservaNormal.getDataFim().getTime() - reservaNormal.getDataInicio().getTime()));
		
		
		return false;
	}
	
	public boolean reservaNormalReduzida() {
		
		return false;
	}

	public boolean reservaEmpresarial() {
	
	return false;
	}

	public boolean reservaMensal() {
	
		return false;
	}
	
	public String emitirRelatorio() {
		String relatorio = null;
		return relatorio;
	}
	
	public String emitirRelatorioConsolidado() {
		String relatorioConsolidado = null;
		return relatorioConsolidado;
	}

}
