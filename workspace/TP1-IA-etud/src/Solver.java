
import javax.swing.text.html.HTMLDocument;
import java.util.*;


public class Solver
{

		public CSP problem; // l'instance de CSP                 
		private HashMap<String,Object> assignation; // codage d'une solution partielle ou totale
		
		public Solver(CSP p)
        {
			problem = p;
			assignation = new HashMap<String,Object>();               
		}
		
		// retourne une solution s'il en existe une, null sinon           
		public HashMap<String,Object> searchSolution()
        {
            assignation = new HashMap<String,Object>();
			return  backtrack();
		}
		
		// l'algo r�cursif
		private HashMap<String,Object> backtrack()
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
                System.out.println("var : " + x + " val : " + val );
                if(consistant(newAssignation, problem.getConstraints()))
                {
                    assignation = new HashMap<String, Object>(newAssignation);
                    if(backtrack() != null)
                    {
                        return assignation;
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

        private boolean consistant(HashMap<String,Object> assignedVar, ArrayList<Constraint> constraints)
        {
            boolean consistant = true;
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
                        int cptTuples = 0;
                        Object[] tuples = (Object[])c.getTuples().toArray();
                        while(cptTuples < tuples.length && !okTuple)
                        {
                            ArrayList tuple = (ArrayList)tuples[cptTuples];
                            int i = 0;
                            while(i<tuple.size() && assignedVar.get(orderedVars.get(i)).equals(tuple.get(i)))
                            {
                                i++;
                            }
                            if(i == tuple.size())
                            {
                                okTuple = true;
                            }
                            cptTuples ++;
                        }
                        if(!okTuple) return false;
                        //consistant = false;
                    }
                }
            }
            return consistant;
        }
		
		// retourne l'ensemble des solutions
		public HashSet<HashMap<String,Object>> searchAllSolutions()
        {
			// TO DO              
			return null;
		}
}
