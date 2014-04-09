package action;

import java.util.List;

import model.Activity;
import service.StaffService;

/**
 * 实现了服务员查看所有操作请求的处理
* @author 王选易
* @version 1.0
* @since 1.7
*/
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
