package alioune.test;


/* NGALA Stephane
 * KABLAN Applah
 */


import java.util.concurrent.CyclicBarrier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
	private static List<Integer> resultats = new ArrayList<Integer>();
	private static List<Integer> segmentValeurs = new ArrayList<Integer>();
	
	/*affichage des nombres premiers entre 0 et le multiple de
	1000 en paramètre*/
	public static void printCyclicBarrier(int nombre) throws Exception {
		int nb = nombre / 1000;		
		coupeNbre(nombre);
		CyclicBarrier barrier = new CyclicBarrier(5);
		
		Callable<List<Integer>> task1 = () -> {
			List<Integer> list1 = chercherNombrePremier(segmentValeurs.get(1));
			barrier.await();
			return list1;
		};
		
		Callable<List<Integer>> task2 = () -> {
			List<Integer> list2 = chercherNombrePremier(segmentValeurs.get(2));
			barrier.await();
			return list2;
		};
		
		Callable<List<Integer>> task3 = () -> {
			List<Integer> list3 = chercherNombrePremier(segmentValeurs.get(3));
			barrier.await();
			return list3;
		};
		
		Callable<List<Integer>> task4 = () -> {
			List<Integer> list4 = chercherNombrePremier(segmentValeurs.get(4));
			barrier.await();
			return list4;
		};
		
		Callable<List<Integer>> task5 = () -> {
			List<Integer> list5 = chercherNombrePremier(segmentValeurs.get(5));
			barrier.await();
			return list5;
		};
		
		ExecutorService es = Executors.newFixedThreadPool(nb);
		
	     Future<List<Integer>> futureList1 = es.submit(task1);
	     Future<List<Integer>> futureList2 = es.submit(task2);
	     Future<List<Integer>> futureList3 = es.submit(task3);
	     Future<List<Integer>> futureList4 = es.submit(task4);
	     Future<List<Integer>> futureList5 = es.submit(task5);
	     
	     resultats.addAll(futureList1.get());
	     resultats.addAll(futureList2.get());
	     resultats.addAll(futureList3.get());
	     resultats.addAll(futureList4.get());
	     resultats.addAll(futureList5.get());
	     
	     resultats.forEach(System.out::println);
	     
	}
	
	/*retourne tous les nombres premiers compris un multiple de 1000 et son
	précédent*/
	public static List<Integer> chercherNombrePremier(int nombre) {
		List<Integer> list = new ArrayList<>();
		for(int i = nombre - 1000; i < nombre; i ++) {
			if(nombrePremier(i)) {
				list.add(i);
			}
		}
		return list;
	}
	
	//divise le nombre en multiples de 1000
	public static void coupeNbre(int nombre) {
		if(nombre > 1000) {
			for(int i = 0; i <= nombre; i = i + 1000) {
				segmentValeurs.add(i);
			}
		}
	}
	
	//Retourne la valeur premier
	public static boolean nombrePremier(int nombre) {
		int res;
		boolean test = true;
		
		for(int i = 2; i < nombre; i++) {
			res = nombre % i;
			
			if(res == 0) {
				test = false;
			}
		}
		return test ;
	}
	
	public static void main(String[] args) throws Exception {
		Main .printCyclicBarrier(6000);
		}
}