package View;

import java.util.concurrent.Semaphore;

import Controller.Carro;

public class Principal {
	public static void main(String[] args) {
		String[] direcoes = { "Sul -> Norte", "Norte -> Sul", "Oeste -> Leste", "Leste -> Oeste" };
		Semaphore semaforo = new Semaphore(1);
		for (int i = 0; i < direcoes.length; i++) {
			Carro carros = new Carro(i, direcoes[i], semaforo);
			carros.start();
		}
	}

}
