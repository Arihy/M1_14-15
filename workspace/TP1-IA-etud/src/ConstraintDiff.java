import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Arihy on 21/10/2014.
 */
public class ConstraintDiff extends Constraint {
    public ConstraintDiff(ArrayList<String> var, String name) {
        super(var, name);
    }

    public ConstraintDiff(ArrayList<String> var) {
        super(var);
    }

    public ConstraintDiff(BufferedReader readerFile) throws IOException {
        super();
        String line = readerFile.readLine();
    }

    /**
     * Tester si les valeur du tuple sont deux a deux différentes
     * @param tuple Un tuple
     * @return false si une valeur du tuple est égale à une autre, true sinon
     */
    public boolean violationTest(ArrayList<Object> tuple)
    {
        for(int i = 0; i < tuple.size() - 1; i++)
        {
            if(tuple.get(i) == tuple.get(i + 1))
                return false;
        }
        return false;
    }

    public String toString()
    {
        return "\n Diff" + super.toString();
    }
}
