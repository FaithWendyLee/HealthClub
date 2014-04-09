package action;

import model.Activity;
import service.StaffService;

/**
 * 实现了对新建活动操作POST请求的处理
* @author 王选易
* @version 1.0
* @since 1.7
*/
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
