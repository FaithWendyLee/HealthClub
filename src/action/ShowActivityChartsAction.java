package action;

import service.ManagerService;

public class ShowActivityChartsAction extends BaseAction {
	private ManagerService managerService;

	@Override
	public String execute() throws Exception {
		
		return "charts";
	}

	public ManagerService getManagerService() {
		return managerService;
	}

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}
}
