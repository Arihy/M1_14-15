
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
                HashMap<String,Object> newAssignation = assignation;
                newAssignation.put(x, v.next());
                if(consistant(newAssignation.keySet(), problem.getConstraints()))
                {
                    assignation = newAssignation;
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

        private boolean consistant(Set<String> assignedVar, ArrayList<Constraint> constraints)
        {
            // TO DO
            return false;
        }
		
		// retourne l'ensemble des solutions
		public HashSet<HashMap<String,Object>> searchAllSolutions()
        {
			// TO DO              
			return null;
		}
}
