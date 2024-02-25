import java.util.ArrayList;

import DataLayer.ChefManager;
import DataLayer.DeveloperManager;
import DataLayer.ProjectManager;
import DataLayer.Statistics;

public class test {

	public static void main(String[] args) {
		DeveloperManager devManager = new DeveloperManager();
		ProjectManager pm=new ProjectManager();
		ArrayList<Integer> idTechnologiesTest = new ArrayList<>();
		idTechnologiesTest.add(1);  // Remplacez 1, 2, 3, etc. par les IDs réels de vos technologies
		idTechnologiesTest.add(2);
		idTechnologiesTest.add(3);
		Statistics st= new Statistics();
		ChefManager ch=new ChefManager();
		ArrayList<Integer> idDecTest = new ArrayList<>();
		ArrayList<Integer> ListDev = new ArrayList<>();
		
		System.out.println(ch.RecupererListeDev(1));
	}
}
