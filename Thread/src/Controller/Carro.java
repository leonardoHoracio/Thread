package Controller;

import java.util.concurrent.Semaphore;

public class Carro extends Thread {

		private int codCarro;
		private String direcao;
		private Semaphore semaforo;
		
		public Carro(int codCarro, String direcao, Semaphore semaforo) {
			super();
			this.codCarro = codCarro + 1;
			this.direcao = direcao;
			this.semaforo = semaforo;
		}
		
		@Override
		public void run() {
			try {
				semaforo.acquire();
				atravessando();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo.release();
			}
			liberado();
		}
		
		private void atravessando() {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("O carro " + codCarro + " está atravessando");
		}
		
		private void liberado() {
			System.out.println("O carro " + codCarro + " atravessou " + direcao);
		}
}
