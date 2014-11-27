import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe déffinissant une contrainte en général
 */
public abstract class Constraint {
	
	private static int num=0; //pour donner un num�ro unique � chaque contrainte
	protected String name; // nom de la contrainte
	protected ArrayList<String> varTuple; // ensemble ordonn� de variables

    public Constraint() {
        num++;
        this.name = "C"+num;
        varTuple = new ArrayList<String>();
    }

    /**
     * Constructeur initialisant les attributs
     * @param var ArrayList contenant la liste des variables de la contrainte
     */
	public Constraint(ArrayList<String> var) {
		num++;
		this.name = "C"+num;
		varTuple = var; 
	}

    /**
     * Constructeurs initialisant les attributs
     * @param var ArrayList contenant la liste des variables de la contrainte
     * @param name String nom de la contrainte
     */
	public Constraint(ArrayList<String> var, String name) {
		num++;
		this.name = name;
		varTuple = var; 
	}
	
	public int getArity() {
		return varTuple.size();
	}
	public String getName() {
		return name;
	}
	public ArrayList<String> getVariables() {
		return varTuple;
	}

    public abstract boolean violationTest(ArrayList<Object> tuple);

	public String toString() {
		return "\n\t"+ name + " = " + varTuple + " : ";
	}
}
