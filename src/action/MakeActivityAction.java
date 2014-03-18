package action;

import model.Activity;
import service.StaffService;

public class MakeActivityAction extends BaseAction {
	StaffService staffService;
	
	Activity activity;
	
	@Override
	public String execute() throws Exception {
		staffService.save(activity, request.getParameter("time"));
		return "show_all";
	}

	public StaffService getStaffService() {
		return staffService;
	}

	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	
	
}
