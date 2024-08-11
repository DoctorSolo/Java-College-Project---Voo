package br.uemg.classes;
import br.uemg.classes.Data; //Importa formatação da data ////////////////

public class Voo {
	// atributos ///////////////////////////////////////////////
	private Data		data;
	private int			num_voo;
	private boolean[]	vagas	= new boolean[100];				// vagas com numero fixo, se true está prenchido;
	private byte 		vagaT	= (byte) (vagas.length - 1);	// numero maximo de vagas;
	private byte		vagaM	= 0;							// numero minimo de vagas podendo ser 0 ou 1;
	
	// metodos////////////////////////////////////////////////////////////
	
	// metodo que configura todos os metodos /////////////////////////////
	public void configura (int num_voo, Data data, byte assento) {
		System.out.println("");
		proximo_livre	(assento);
		ocupa 			(assento);
		vagas 			(vagaT);
		assent_livre 	((byte)0);
	}
	
	// Retorna o numero do proximo assento livre ////////////////////////
	private byte proximo_livre (byte assento) {
		if (assento >= vagaT || assento < vagaM) {	// Verifica se o assento digitado passou ou está no limite que é 99 ou 0 /////////////
			assento = (byte) (vagaT + 1);			// Caso sim entao retorna 100 sempre (mesmo para valores negativos) para ficar facil de trabalhar
		} else {
			for (byte i = (byte) (assento + 1); i <= vagaT; i++) {	// Conta o numero do proximo assento até o livre ////////
				if (i == vagaT || vagas[i]) {		// Caso chegar no final e não encotrar então recebe o valor vagaT+1 e sai do loop
					assento = (byte) (vagaT + 1);
					break;
				}
				if (!vagas[i]) {		// Caso ele encotre um proximo assento valido ele sai do loop ///////////////////////
					assento = i;
					break;
				}
			}
		}
		if (assento >= vagaT) {			// Informa ao usuario se tiver um proximo assento //////
			System.out.println("Sem proximo assento");
		} else {
			System.out.println("O numero do proximo assento livre é: " + (assento));
		}
		return assento;
	}
	
	// Verifica se o assento está desocupado, caso sim retorna True //////////////
	private boolean verifica (byte assento) {
		if (assento < vagaM || assento > vagaT || vagas[assento] == true) {
			return true;
		}
		return false;
	}
	
	// Ocupa o assento se a verificação der false ////////////////////////
	private boolean ocupa (byte assento) {
		verifica (assento);					// Usa o metodo verifica
		if (verifica(assento)) {			// verifica == true é assento ocupado ou não existe
			System.out.println("Assento ocupado ou inexistente....");
			return false;
		}
		System.out.println("Ocupado com sucesso....");
		return vagas[assento] = true;
	}
	
	
	// Retorna o numero de assentos desocupados //////////////////////////
	private byte vagas (byte vaga_livre) {
		vaga_livre += 1;		// Defino + 1 porque vagaT considera o 0, como é numero de vagas prefiro do 1 ao 100
		for (boolean vaga : vagas) {
			if (vaga == true) {
				vaga_livre -= 1;	// para cada true em vagas retiro 1 
			}
		}
		System.out.println("O numero de assentos desocupados são: " + vaga_livre);
		return vaga_livre;
	}
	
	// Assentos livre, deve receber 0 como parametro, aqui é para ver todos os assentos desocupados
	public void assent_livre (byte assentos){
		System.out.println("Os assentos desocupados são: ");
		for (boolean vaga : vagas) {
			if (vaga == false) {
				System.out.print("["+ (assentos) +"]");
			}
			assentos += 1;
		}
		System.out.println("\n");
	}
	
	
	// Retorna o numero do voo ///////////////////////////////////////////
	public int ret_voo () {
		System.out.println("Numero do voo: " + num_voo);
		return num_voo;
	}
	
	// Retorna a data e a hora do voo ///////////////////////////////////
	public Data ret_data () {
		System.out.println("Data: " + data);
		return data;
	}
	
	
	
	
	// contrutor //////////////////////////////////////////////////
	public Voo(int num_voo, byte dia, byte mes, int ano, byte hora, byte minuto) {
		this.num_voo	= num_voo;
		this.data 		= new Data(dia,mes,ano,hora,minuto);	// Para formatar a Data para ficar melhor
	}
	
}

