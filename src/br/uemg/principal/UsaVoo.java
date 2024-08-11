package br.uemg.principal;
import br.uemg.classes.Voo;

public class UsaVoo {
	
	public static void main(String[] args) {
		Voo voo1 = new Voo(1523943,(byte)13,(byte)4, 2025,(byte)14,(byte)0);
		Voo voo2 = new Voo(1685843,(byte)90,(byte)4, 2025,(byte)13,(byte)0);
		
		// assentos são numerados de 0 a 99, no total são 100 vagas///
		// Passagens ////////////////////////////////////////////////
		voo1.configura(voo1.ret_voo(), voo1.ret_data(),(byte)5);
		voo1.configura(voo1.ret_voo(), voo1.ret_data(),(byte)99);
		voo1.configura(voo1.ret_voo(), voo1.ret_data(),(byte)98);
	
		voo2.configura(voo2.ret_voo(), voo2.ret_data(),(byte)5);
		voo2.configura(voo2.ret_voo(), voo2.ret_data(),(byte)10);
	}
	
}
