package action;

import java.util.Date;
import java.util.List;

import dao.ActivityDao;
import model.Activity;
import service.StaffService;

public class ChangeActivityAction extends BaseAction {
	ActivityDao activityDao;
	
	String place;
	int coachNumber;
	Date time;
	int index;
	
	@Override
	public String execute() throws Exception {
		@SuppressWarnings("unchecked")
		Activity p_activity = ((List<Activity>) session.get("activities")).get(index);
		p_activity.setCoachNumber(coachNumber);
		p_activity.setPlace(place);
		p_activity.setTime(time);
		activityDao.update(p_activity);
		return "show_all";
	}

	public ActivityDao getActivityDao() {
		return activityDao;
	}


	public void setActivityDao(ActivityDao activityDao) {
		this.activityDao = activityDao;
	}


	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public int getCoachNumber() {
		return coachNumber;
	}

	public void setCoachNumber(int coachNumber) {
		this.coachNumber = coachNumber;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}


	
}
