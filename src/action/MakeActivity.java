package action;

import model.Activity;
import service.StaffService;

public class MakeActivity extends BaseAction {
	StaffService staffService;
	
	Activity activity;
	
	@Override
	public String execute() throws Exception {
		
		return super.execute();
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
