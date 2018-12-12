package astaire;

public class InputController implements Controller{
	private DancersStorage ds;
	private RunningOrder ro;

	public InputController () {
		ds = new DancersStorage("assets/danceShowData_dances.csv");
	}
	
	@Override
	public String listAllDancersIn(String dance) {
		return ds.getDancers(dance);
	}

	@Override
	public String listAllDancesAndPerformers() {
		ds.sortDances();
		return ds.getSortedDances();
	}

	@Override
	public String checkFeasibilityOfRunningOrder(String filename, int gaps) {
		ro = new RunningOrder(filename, gaps);
		return ro.checkFeasibility();
		// need to use a linked hashmap.
	}

	@Override
	public String generateRunningOrder(int gaps) {
		// TODO Auto-generated method stub
		return null;
	}

}
