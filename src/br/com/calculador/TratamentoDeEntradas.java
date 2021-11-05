package br.com.calculador;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TratamentoDeEntradas {

	/*
	 * m�todo que formata a data para dia/mes/ano
	 * retorna em String
	 */
	
	public String formataData(LocalDate dataParaFormatar) {
		
		DateTimeFormatter formatoDeData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
		return dataParaFormatar.format(formatoDeData);
		
	}
	
	/*
	 * m�todo que soma os dias na data passada
	 * retorna uma data resultante LocalDate
	 */
	
	public LocalDate somarDias(LocalDate dataParaSomar, int diasParaSomar) {
		
		return dataParaSomar.plusDays(diasParaSomar);
		
	}
	
	/*
	 * 
	 * M�todo que checa se teve alguma entrada no textfield que n�o seja n�mero
	 * Se sim, retora true
	 * 
	 */
	
	public boolean checaNumero(JTextField txtFieldSomarDias) {
		long valor = 0;
		try {
			valor = Long.parseLong(txtFieldSomarDias.getText());
			return false;
		} catch (NumberFormatException ex) {
			return true;	
		}
	}
	
	
	/*
	 * 
	 * M�todo que checa se o textField de entrada de dados est� vazio
	 * Se sim, retorna true
	 * 
	 */
	
	public boolean checaTextField(JTextField jTextField) {
		
		boolean estaVazio = jTextField.getText().trim().isEmpty();
		return estaVazio;
		
	}
	
	/*
	 * 
	 * M�todo que realiza o c�lculo de acordo com a entrada v�lida
	 * mostra o resultado no JLabel lblDataResultante
	 * 
	 */
	
	public void calcula(JTextField txtFieldSomarDias, LocalDate dataAtual, int diasParaSomar, 
			JLabel lblDataResultante, JLabel lblmensagemCorrecao) {
		
		if (checaTextField(txtFieldSomarDias) || checaNumero(txtFieldSomarDias)) {
			lblmensagemCorrecao.setText("Dados Inv�lidos");
		} else {
			String entradaDoField = txtFieldSomarDias.getText();
			diasParaSomar = Integer.parseInt(entradaDoField);
			lblDataResultante.setText(formataData(somarDias(dataAtual, diasParaSomar)));
			lblmensagemCorrecao.setText("");
		}
	}
	
}



