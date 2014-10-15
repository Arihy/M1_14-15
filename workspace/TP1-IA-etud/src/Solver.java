
import javax.swing.text.html.HTMLDocument;
import java.util.*;


public class Solver
{
    public CSP problem; // l'instance de CSP

    public Solver(CSP p)
    {
        problem = p;
    }

    // retourne une solution s'il en existe une, null sinon
    public HashMap<String,Object> searchSolution()
    {
        HashMap<String,Object> assignation = new HashMap<String,Object>();
        return  backtrack(assignation);
    }

    // l'algo r�cursif
    private HashMap<String,Object> backtrack(HashMap<String,Object> assignation)
    {
        if(assignation.size() == problem.getVarNumber())
        {
            return assignation;
        }

        String x = chooseVar(problem.getVar(), assignation.keySet());
        for(Iterator v = tri(problem.getDom(x)).iterator(); v.hasNext();)
        {
            HashMap<String,Object> newAssignation = new HashMap<String, Object>(assignation);
            Object val = v.next() ;
            newAssignation.put(x, val);

            if(consistant(newAssignation, problem.getConstraints()))
            {
                if(backtrack(newAssignation) != null)
                {
                    return backtrack(newAssignation);
                }
            }
        }
        return null;
    }

    // choix d'une variable
    private String chooseVar(Set<String> allVar, Set<String> assignedVar)
    {
        for(String s : allVar)
        {
            if(!assignedVar.contains(s))
            {
                return s;
            }
        }
        return null;
    }


    private TreeSet<Object> tri(TreeSet<Object> values)
    {
        return values;
    }

    // retourne l'ensemble des solutions
    public HashSet<HashMap<String,Object>> searchAllSolutions()
    {
        // TO DO
        return null;
    }

    private boolean consistant(HashMap<String,Object> assignedVar, ArrayList<Constraint> constraints)
    {
        for(Constraint c : constraints)
        {
            if(assignedVar.size() >= c.getArity())
            {
                //tester si les variables assignées apparessent dans la constrainte
                if(assignedVar.keySet().containsAll(c.getVariables()))
                {
                    //tester qu'il existe un tuple qui correspond aux variables assignées
                    ArrayList<String> orderedVars = c.getVariables();
                    boolean okTuple = false;
                    //créer un tuple avec les variables des assignations
                    ArrayList<Object> valTuple = new ArrayList<Object>(orderedVars.size());
                    for(int k = 0; k < orderedVars.size(); k++)
                    {
                        valTuple.add(k, assignedVar.get(orderedVars.get(k)));
                    }

                    //tester si le tuple crée appartient a la contrainte
                    //si oui continuer avec la prochaine contrainte,
                    //sinon echec
                    if(c.getTuples().contains(valTuple))
                    {
                        okTuple = true;
                    }
                    if(!okTuple)
                        return false;
                }
            }
        }
        return true;
    }
}
