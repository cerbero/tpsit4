package holt;

public class goGraph {
	public static void main(String[] args) {
		
		 // dichiaro che la variabile mygraph e' di tipo GrafoHolt:
        GrafoHolt mygraph;

        // costruisco l'oggetto mygraph:
        mygraph = new GrafoHolt(3);
        
        //stampo la matrice
        mygraph.print2D();
        System.out.println("\n");
        
        //inserisco il seguente problema 
        //P1 richiede R1
        //P2 richiede R2 
        //P2 richiede R3
        //P3 richiede R1
        
        mygraph.setRequest(0,0);
        mygraph.setRequest(1,1);
        mygraph.setRequest(1,2);
        mygraph.setRequest(2,0);
        
        //stampo la matrice
        System.out.println("Grafo post assegnamento:\n");

        mygraph.print2D();
        
	}
	
}
