package controller;
import java.util.concurrent.Semaphore;

public class Metodos3 extends Thread {
	private int tipo;
	private Semaphore semaforo;
	
	public Metodos3(Semaphore semaforo, int tipo) {
		this.semaforo = semaforo;
		this.tipo = tipo;
	}
	public void run() {	
		
			try {
				semaforo.acquire();
				transacao(tipo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo.release();
			}
	}
	private void transacao(int tipo) {
		if (tipo == 0) {
			int codigo = (int) ((Math.random()*9000000)+1000000);
			int saldo = (int) ((Math.random()*100001));
			int valor = (int) ((Math.random()*100001));
			saldo += valor;
			System.err.println("Codigo da conta: " + codigo + "\nSaldo: " + (saldo-valor) +"\nValor a"
					+ " depositar: " + valor +"\nSaldo apos transacao: " + saldo + "\n");
		} else {
			int codigo = (int) ((Math.random()*9000000)+1000000);
			int saldo = (int) ((Math.random()*100001));
			int valor = (int) ((Math.random()*saldo));
			saldo -= valor;
			System.out.println("Codigo da conta: " + codigo + "\nSaldo: " + (saldo+valor) +"\nValor a"
					+ " sacar: " + valor +"\nSaldo apos transacao: " + saldo + "\n");
		}
		try {
			sleep(2000);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
	}
}
