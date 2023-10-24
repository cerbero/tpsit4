package holt;

public class GrafoHolt {
	// GLi attributi della classe GrafoHolt sono : 
	// la dimensione del Grafo e una matrice che 
	// rappresenta il grafo stessp 
	int dimension;
	int [][] grafo;
	
	public GrafoHolt(int dimension) {
		//IL Costrutture della classe 
		// crea e inizializza la matrice che rappresenta 
		// il grafo 
		this.grafo =  new int[dimension][dimension];
		this.dimension=dimension;
		for (int i = 0; i < this.dimension; i++) {
			for (int j = 0; j < this.dimension; j++) {
				 this.grafo[i][j]=0;
				}

			}

	}
	
	public Boolean checkcolum(int resources) {
		// Il metodo controlla se la risorsa non è già stata 
		//assegnata
		int somma = 0;
		for (int i = 0; i < this.dimension; i++) {
			somma = somma  + this.grafo[i][resources];
			}
		if (somma == 0) {
			return (true);
		}
		else {
			return(false);
		}
	}

	public void setRequest(int process, int resources) {
		// il metodo assegna : 
		//      1 risorsa assegnata 
		//      2 processo in attesa

		if (this.grafo[process][resources]==0) {
			if (this.checkcolum(resources)){
				this.grafo[process][resources]=1;
			}
			else {
				this.grafo[process][resources]=2;
			}
		}
		else {
			System.out.print("Assegnamento non possibile");
		}
		
	}
	
	 public  void print2D() {
		 //stampa la matrice a video 
	        for (int i = 0; i < this.dimension; i++) {
	            for (int j = 0; j < this.dimension; j++) {
	                System.out.print(this.grafo[i][j] + " ");
	            }
	        System.out.print("\n");
	        }
	    }
	
	
	
}