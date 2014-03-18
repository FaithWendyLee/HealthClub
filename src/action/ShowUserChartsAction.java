package action;

import service.ManagerService;

public class ShowUserChartsAction extends BaseAction {
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
