                                                                                                                    

import java.util.HashMap;
import java.util.HashSet;

// exemple de main pour le test de l'algorithme de backtrack

public class TP {

	public static void main(String args[]) {
		//Lire un CSP depuis un fichier
		//String fileName = "example.txt";
		//String fileName = "4reines";
		//String fileName = "automobile";
		String fileName = "coloration";
		CSP myProblem;
		try {
            System.out.println("Chargement du fichier : "+new java.io.File( "." ).getCanonicalPath()+"/"+fileName);
            myProblem = new CSP(fileName);
        }catch(Exception e) {
            System.err.println("Erreur lors du chargement du fichier " + fileName);
			System.err.println(e);
			return;
		}
		System.out.println("\nRecherche d'une solution au probleme :\n" + myProblem);
		Solver mySolver = new Solver(myProblem);
		//HashMap<String,Object> mySolution = mySolver.searchSolution();
        HashSet<HashMap<String,Object>> mySolution = mySolver.searchAllSolutions();
        if (mySolution == null) System.out.println("Pas de solution !");
		else {
            System.out.println("Il y a "+mySolution.size()+" solution(s)");
            System.out.println("Solution est " + mySolution);
        }
    }
}
