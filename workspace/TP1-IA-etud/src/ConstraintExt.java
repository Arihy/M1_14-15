import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Arihy on 19/10/2014.
 */
public class ConstraintExt extends Constraint {
    private Set<ArrayList<Object>> valTuples; // ensemble de tuples de la contrainte

    public ConstraintExt(ArrayList<String> var, String name) {
        super(var, name);
        valTuples = new HashSet<ArrayList<Object>>();
    }

    public ConstraintExt(ArrayList<String> var) {
        super(var);
        valTuples = new HashSet<ArrayList<Object>>();
    }

    public ConstraintExt(BufferedReader readerFile) throws IOException {
        super();
        valTuples = new HashSet<ArrayList<Object>>();
        String line = readerFile.readLine();
        String[] tab = line.split(";");
        varTuple = new ArrayList<String>(tab.length);

        for(int j = 0; j < tab.length; j++)
        {
            varTuple.add(j, tab[j]);
        }

        line = readerFile.readLine();
        int nbTuple = Integer.parseInt(line);

        ArrayList<Object> valTuple;

        for(int j = 0; j < nbTuple; j++)
        {
            line = readerFile.readLine();
            String[] tab2 = line.split(";");
            valTuple = new ArrayList<Object>(tab.length);
            for(int k = 0; k < tab.length; k++)
            {
                valTuple.add(k, tab2[k]);
            }
            addTuple(valTuple);
        }
    }

    public Set<ArrayList<Object>> getTuples(){ return valTuples; }
	public void addTuple(ArrayList<Object> valTuple) {
        if(valTuple.size() != varTuple.size()) System.err.println("Le tuple " + valTuple + " n'a pas l'arite " + varTuple.size() + " de la contrainte " + name);
		else if(!valTuples.add(valTuple)) System.err.println("Le tuple " + valTuple + " est deja present dans la contrainte "+ name);
    }

    /**
     * Tester si le tuple appartient a la contrainte
     * @param tuple Un tuple
     * @return true si le tuple appartient a l'ensemble de tuples de la contrainte, false sinon
     */
    public boolean violationTest(ArrayList<Object> tuple)
    {
        return valTuples.contains(tuple);
    }

	public String toString()
    {
		return "\n Ext" + super.toString() + valTuples;
	}
}

