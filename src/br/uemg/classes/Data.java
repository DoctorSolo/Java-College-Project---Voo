package br.uemg.classes;

public class Data {
	private byte 	dia;
	private byte	mes;
	private int		ano;
	private byte	hora;
	private byte	minuto;
	
	public Data(byte dia, byte mes, int ano, byte hora, byte minuto) {
		format(dia, mes, ano, hora, minuto);
	}
	
	// Formatação em metodo ///////////////////////////////////////////////////////
	// Se nescessario digitar 90 dias o metodo já faz a conversão, 
									//levando em consideração o calendario lunar slamico (30||29 dias por mes)
	private void format (byte dia, byte mes, int ano, byte hora, byte minuto) {
		while (minuto >= 60) {
			hora += 1;
			minuto -= 60;
		}
		while (hora >= 24) {
			dia += 1;
			hora -= 24;
		}
		// formatação do dia //////
		while (true) {
			if (dia < 29) {
				break;
			}
			if (mes%2 == 0) {	// caso mes par então tera 29 dias
				mes += 1;
				dia -= 29;
			} else {			// caso mes impar então tera 30 dias
				mes += 1;
				dia -= 30;
			}
		}
		// mes ///////////////
		while (mes > 12) {
			ano += 1;
			mes -= 12;
		}
		// atribuições //////////////////////////////////
		this.dia 	= dia;
		this.mes 	= mes;
		this.ano 	= ano;
		this.hora 	= hora;
		this.minuto	= minuto;
		
	}
	
	
	
	
	
	// Formatação em String ///////////////////////////////////////////////////////
	public String toString() {
		return dia + "/" + mes + "/" + ano + " Horario " + hora + " : " + minuto;
	}


	
	
	
	// getters and setters ////////////////////////////////////////////////////////
	public byte getDia() {
		return dia;
	}


	public void setDia(byte dia) {
		this.dia = dia;
	}


	public byte getMes() {
		return mes;
	}


	public void setMes(byte mes) {
		this.mes = mes;
	}


	public int getAno() {
		return ano;
	}


	public void setAno(int ano) {
		this.ano = ano;
	}


	public byte getHora() {
		return hora;
	}


	public void setHora(byte hora) {
		this.hora = hora;
	}


	public byte getMinuto() {
		return minuto;
	}


	public void setMinuto(byte minuto) {
		this.minuto = minuto;
	}
	
}
