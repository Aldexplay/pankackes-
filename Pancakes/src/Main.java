import java.util.LinkedList;

public class Main {
																						//Alexis Aldhair Garcia Sandez ITC matutino 6to semestre
	static String ordenInicial = "";

	public static void main(String[] args) {
		
		char[] charletras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		String ordenRandom = "";
		int numDiscos = 4;
		
		for(int i=0;i<=numDiscos-1;i++) {
			ordenInicial+=charletras[i];
		}
		
		ordenRandom = shuffle();		//shuffle funcion random
		algAleatorio(ordenRandom);
		busquedaA(ordenRandom);

	}	
																		//Funciones 
	private static void algAleatorio(String ordenRan) {
		char[] posicion = ordenRan.toCharArray();
		String orden = "";
	}
	
	private static String shuffle() {
		char[] pos = ordenInicial.toCharArray();
																		//cadena vacia
		String orden = "";
														//ciclo aleatorio
		for(int i=0;i<ordenInicial.length();i++) {	
			int ran = (int)(Math.random()*ordenInicial.length());
			if(pos[ran]!=0) {
				orden+=pos[ran];
				pos[ran]=0;
			}else {									//sino se regresa el ciclo
				i--;
			}
		}
		System.out.println("Inicio Aleatorios : "+orden);
		return orden;
	}
	
	private static void busquedaA(String ordenRan) {
		
		char[] pos = ordenRan.toCharArray();
		String orden = "";
		LinkedList<String> colaDisc= new LinkedList<String>();
		int[] A = new int[1000];
		int contador = 0;
		Integer[] Integer = new Integer[1000];
		
		colaDisc.add(ordenRan);
		A[0] = 0;
		Integer[0] = null;
		
		for(int a=0;!Boleano(orden);a++) {
			
			pos = colaDisc.get(a).toCharArray();
			
			for(int i=1;i<pos.length;i++) {
				
				if(A[a]!=i) {
					
					contador++;
					Integer[contador] = a;
					A[contador] = i;
					
						for(int j=i;j>=0;j--) {
							orden+=pos[j];
						}	
					
							for(int j=i+1;j<pos.length;j++) {
								orden+=pos[j];
							}
					
							if(Boleano(orden)) {
						break;
							}
					
					colaDisc.add(orden);
					orden = "";
					
				}
			}
		}
											//impresion de pasos y orden
		System.out.print("\n");
		for(int z=1;z>0;z++) {
			
			if(A[contador]==0) {
				
				System.out.println("Movimiento : "+orden);
			}else {
				System.out.println("Movimiento : "+orden+" : "+(A[contador]+1));
			}
			
			pos = orden.toCharArray();
			int x = A[contador];

			if(!(orden.contentEquals(ordenRan))) {
				orden = "";
				
				for(int j=x;j>=0;j--) {
					orden+=pos[j];
				}
				
				for(int j=x+1;j<pos.length;j++) {
					orden+=pos[j];
				}
				
				contador = Integer[contador];
			} else {
				System.out.println("Distancia a la que esta la solucion = "+z);
				System.out.println("Meta : "+ordenInicial);
				break;
			}	
		}
	}
	
	private static boolean Boleano(String ordenRan) {
		return ordenInicial.equals(ordenRan);	
	}
										//fin algoritmo
}