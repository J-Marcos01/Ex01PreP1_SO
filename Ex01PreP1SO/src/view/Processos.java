package view;
/*
 * 1) Considerando o esquema de escalonamento não preemptivo chamado FCFS, faça uma 
simulação de execução de processos, em Java com Threads e Semáforos, considerando 
que 20 processos foram carregados na memória, cada um deles pode durar de 4 a 120 
segundos para roda
*/
import java.util.concurrent.Semaphore;

import controller.ThreadProcessosFcfs;

public class Processos {

	public static void main(String[] args) {
		
		int perm=1;
		Semaphore semaforo = new Semaphore(perm);
		
		for (int i=1;i<21;i++) {
			
			int tempo=(int)((Math.random()*117)+4);
			ThreadProcessosFcfs t = new ThreadProcessosFcfs(semaforo, i, tempo);
			t.start();
		}
		
		
	}

}
