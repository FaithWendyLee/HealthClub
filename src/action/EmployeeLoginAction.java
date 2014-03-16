package action;

import model.Employee;
import service.ManagerService;
import service.StaffService;
import dao.EmployeeDao;

public class EmployeeLoginAction extends BaseAction {

	private Employee employee;
	
	private StaffService staffService;
	private ManagerService managerService;

	@Override
	public String execute() throws Exception {
		if (request.getParameter("type").equals("staff")){
			if (staffService.validateStaff(employee)){
				session.put("login", true);
				return "make_activity";
			}
			else{
				session.put("error", "您输入的用户名或者密码有误");
				return "staff_error";
			}
		}else{
			if (managerService.validateManager(employee)){
				session.put("login", true);
				return "manager_error";
			}
			else{
				session.put("error", "您输入的用户名或者密码有误");
				return "manager_error";
			}
		}
	}

	public StaffService getStaffService() {
		return staffService;
	}

	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public ManagerService getManagerService() {
		return managerService;
	}

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}
	
	
	
}
