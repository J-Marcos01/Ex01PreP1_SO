package controller;
/*
 * 1) Considerando o esquema de escalonamento não preemptivo chamado FCFS, faça uma 
simulação de execução de processos, em Java com Threads e Semáforos, considerando 
que 20 processos foram carregados na memória, cada um deles pode durar de 4 a 120 
segundos para roda
*/
import java.util.concurrent.Semaphore;

public class ThreadProcessosFcfs extends Thread{

	private static double media ;
	private static int tempoAcumulado;
	private int idProcesso ;
	private int tempoProcesso;
	private static int qtdProcessos;
	private static Semaphore semaforo;
	
	
	public ThreadProcessosFcfs(Semaphore semaforo , int idProcesso,int tempoProcesso) {
		this.idProcesso=idProcesso;
		this.tempoProcesso=tempoProcesso;
		this.semaforo=semaforo;
	}
	
	public void run(){
		
		System.out.println("Processo #"+idProcesso +" Iniciou execução");
		try {
			semaforo.acquire();
			play();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			}
		finally {
			semaforo.release();
		}
	}

	private void play() {
		
		qtdProcessos++;
		
		tempoAcumulado+=tempoProcesso;
		
		if(qtdProcessos==20)
		{
			System.out.println("Tempo total de execução "+tempoAcumulado);
			media=tempoAcumulado/20;
			System.out.println("O tempo de execução em FCFS é :"+media);
		}
		
	}
	
	
}
