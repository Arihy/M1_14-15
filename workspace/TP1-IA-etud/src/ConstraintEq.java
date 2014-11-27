import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Arihy on 21/10/2014.
 */
public class ConstraintEq extends Constraint {
    public ConstraintEq(ArrayList<String> var, String name) {
        super(var, name);
    }

    public ConstraintEq(ArrayList<String> var) {
        super(var);
    }

    /**
     * Constructeur initialisant la contrainte grace a un flux
     * @param readerFile BufferedReader
     * @throws IOException
     */
    public ConstraintEq(BufferedReader readerFile) throws IOException {
        super();
        String line = readerFile.readLine();
        String[] tab = line.split(";");
        varTuple = new ArrayList<String>(tab.length);

        for(int j = 0; j < tab.length; j++)
        {
            varTuple.add(j, tab[j]);
        }
    }

    /**
     * Tester si les valeur du tuple sont toutes égales
     * @param tuple Un tuple
     * @return true si toutes les valeurs du tuple sont égales, false sinon
     */
    public boolean violationTest(ArrayList<Object> tuple)
    {
        for(int i = 0; i < tuple.size() - 1; i++)
        {
            if(!tuple.get(i).equals(tuple.get(i + 1))) {
                return false;
            }
        }
        return true;
    }

    public String toString()
    {
        return "\n Eq" + super.toString();
    }
}
