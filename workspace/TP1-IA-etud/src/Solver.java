import java.util.*;

public class Solver
{
    public CSP problem; // l'instance de CSP

    public Solver(CSP p)
    {
        problem = p;
    }

    /**
     * Retourne une solution s'il en existe une
     * @return une solution du problème, null sinon
     */
    public HashMap<String,Object> searchSolution()
    {
        HashMap<String,Object> assignation = new HashMap<String,Object>();
        return  backtrack(assignation);
    }

    /**
     * Trouve une solution du problème s'il en existe
     * @param assignation HashMap contenant une solution partielle
     * @return appel recursif s'il trouve une solution partielle, null s'il n'y a pas de solution
     */
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
                HashMap<String, Object> res = backtrack(newAssignation);
                if(res != null)
                {
                    return res;
                }
            }
        }
        return null;
    }

    /**
     * Retourne la premiere variable non assignée
     * @param allVar Liste de toutes les variables du problème
     * @param assignedVar Liste des variables déjà assignées
     * @return un string, ou null s'il n'y a plus de variable non assignée
     */
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

    /**
     * Retourne l'ensemble des solutions du problème
     * @return HashSet contenant toutes les solutions possible du problème
     */
    public HashSet<HashMap<String,Object>> searchAllSolutions()
    {
        HashSet<HashMap<String,Object>> ens = new HashSet<HashMap<String, Object>>();
        HashMap<String,Object> assignation = new HashMap<String,Object>();
        backtrack(ens, assignation);
        return ens;
    }

    /**
     * Trouve toues les solutions du problème s'il en existe
     * @param ens HashSet de HashMap permettant de stoquer toutes les solutions
     * @param assignation HashMap contenant une solution partielle
     * @return appel recursif s'il trouve une solution partielle, null s'il n'y a pas de solution
     */
    private HashMap<String,Object> backtrack(HashSet<HashMap<String,Object>> ens, HashMap<String,Object> assignation)
    {
        if(assignation.size() == problem.getVarNumber())
        {
            HashMap<String,Object> newAssignation = new HashMap<String, Object>(assignation);
            System.out.println(newAssignation);
            ens.add(newAssignation);
            return null;
        }

        String x = chooseVar(problem.getVar(), assignation.keySet());
        for(Iterator v = tri(problem.getDom(x)).iterator(); v.hasNext();)
        {
            HashMap<String,Object> newAssignation = new HashMap<String, Object>(assignation);
            Object val = v.next() ;
            newAssignation.put(x, val);

            if(consistant(newAssignation, problem.getConstraints()))
            {
                HashMap<String,Object> res = backtrack(ens, newAssignation);
                if(res != null)
                {
                    return res;
                }
            }
        }
        return null;
    }

    /**
     * Teste si l'assignation ne viole pas les contraintes de rang ...
     * @param assignedVar Liste des assignations (variable - valeur)
     * @param constraints Liste des contraintes du problème
     * @return true si l'assignation ne viole pas les contraintes, false sinon
     */
    private boolean consistant(HashMap<String,Object> assignedVar, ArrayList<Constraint> constraints)
    {
        for(Constraint c : constraints)
        {
            //tester si les variables assignées apparessent dans la constrainte
            if(assignedVar.keySet().containsAll(c.getVariables()))
            {
                //tester qu'il existe un tuple qui correspond aux variables assignées
                ArrayList<String> orderedVars = c.getVariables();
                //créer un tuple avec les variables des assignations
                ArrayList<Object> valTuple = new ArrayList<Object>(orderedVars.size());
                for(int k = 0; k < orderedVars.size(); k++)
                {
                    valTuple.add(k, assignedVar.get(orderedVars.get(k)));
                }
                if(!c.violationTest(valTuple))
                    return false;
            }
        }
        return true;
    }
}
