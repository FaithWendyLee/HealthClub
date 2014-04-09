package action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

import model.Activity;
import service.ManagerService;

/**
 * 实现了经理查看有关活动的统计图表的操作请求的处理
* @author 王选易
* @version 1.0
* @since 1.7
*/
public class ShowActivityChartsAction extends BaseAction {
	private ManagerService managerService;
	
	private String daysumCategory, daysumData, placeCategory, placeData, coachCategory, coachData;

	@Override
	public String execute() throws Exception {
		List<Activity> activities = managerService.getAllActivities();
		Map<String, Integer> daysumMap = new HashMap<String, Integer>();
		Map<String, Integer> placeMap = new HashMap<String, Integer>();
		Map<String, Integer> coachMap = new HashMap<String, Integer>();
		for (Activity activity : activities) {
			addNum(daysumMap, activity.getTime().toString(), activity.getCards().size());
			incNum(placeMap, activity.getPlace());
			incNum(coachMap, "" + activity.getCoachNumber());
		}
		
		daysumCategory = JSON.toJSONString(daysumMap.keySet());
		daysumData = JSON.toJSONString(daysumMap.values());
		placeCategory = JSON.toJSONString(placeMap.keySet());
		placeData = JSON.toJSONString(placeMap.values());
		coachCategory = JSON.toJSONString(coachMap.keySet());
		coachData = JSON.toJSONString(coachMap.values());
		
		return "charts";
	}

	public ManagerService getManagerService() {
		return managerService;
	}

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}
	
	
	
	public String getDaysumCategory() {
		return daysumCategory;
	}

	public void setDaysumCategory(String daysumCategory) {
		this.daysumCategory = daysumCategory;
	}

	public String getDaysumData() {
		return daysumData;
	}

	public void setDaysumData(String daysumData) {
		this.daysumData = daysumData;
	}

	public String getPlaceCategory() {
		return placeCategory;
	}

	public void setPlaceCategory(String placeCategory) {
		this.placeCategory = placeCategory;
	}

	public String getPlaceData() {
		return placeData;
	}

	public void setPlaceData(String placeData) {
		this.placeData = placeData;
	}

	public String getCoachCategory() {
		return coachCategory;
	}

	public void setCoachCategory(String coachCategory) {
		this.coachCategory = coachCategory;
	}

	public String getCoachData() {
		return coachData;
	}

	public void setCoachData(String coachData) {
		this.coachData = coachData;
	}

	private void addNum(Map<String, Integer> map, String k, Integer v){
		Integer num = map.get(k);
		if (map.get(k) == null){
			map.put(k, v);
		}else{
			map.put(k, num + v);
		}
	}
	
	private void incNum(Map<String, Integer> map, String k){
		addNum(map, k, 1);
	}
}
