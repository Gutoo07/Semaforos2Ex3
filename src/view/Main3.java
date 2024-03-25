package view;
import java.util.concurrent.Semaphore;

import controller.Metodos3;

public class Main3 {

	public static void main(String[] args) {
		Semaphore deposito = new Semaphore(1);
		Semaphore saque = new Semaphore(1);

		for (int i = 0; i < 20; i++) {
			int tipo = (int) ((Math.random()*2));
			
			if (tipo == 0) {
				Thread transacao = new Metodos3(deposito, 0);		
				transacao.start();	
			} else if (tipo == 1){			
				Thread transacao = new Metodos3(saque, 1);		
				transacao.start();
			}
		}
	}
}
