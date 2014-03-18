package action;

import java.util.List;

import model.Activity;
import service.StaffService;

public class ShowActivitiesAction extends BaseAction {
	StaffService staffService;
	
	List<Activity> activities;
	
	@Override
	public String execute() throws Exception {
		this.setActivities(staffService.getAllActivities());
		session.put("activities", activities);
		return "show_all";
	}

	public StaffService getStaffService() {
		return staffService;
	}

	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}
	
}
