package action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Card;
import model.User;
import model.type.SexType;

import com.alibaba.fastjson.JSON;

import service.ManagerService;

/**
 * 实现了经理查看用户相关图表操作请求的处理
* @author 王选易
* @version 1.0
* @since 1.7
*/
public class ShowUserChartsAction extends BaseAction {
	private ManagerService managerService;
	private String sexData, ageData, addressData, statusData;

	@Override
	public String execute() throws Exception {
		List<Card> cards = managerService.getAllCards();
		List<User> users = managerService.getAllUser();
		Map<String, Integer> sexMap = new HashMap<String, Integer>();
		Map<String, Integer> ageMap = new HashMap<String, Integer>();
		Map<String, Integer> addressMap = new HashMap<String, Integer>();
		Map<String, Integer> statusMap = new HashMap<String, Integer>();
		for (User user : users) {
			// sex
			if (user.getSex() == SexType.MALE){
				incNum(sexMap, "男");
			}else{
				incNum(sexMap, "女");
			}
			// age
			int low = (user.getAge() / 10) * 10;
			int high = low + 10;
			incNum(ageMap, low + "-" + high );
			// address
			incNum(addressMap, user.getAddress());
		}
		for (Card card : cards) {
			switch (card.getStatus()) {
			case VALID:
				incNum(statusMap, "有效");
				break;
			case CANCEl:
				incNum(statusMap, "取消");
				break;
			case STOP:
				incNum(statusMap, "停止");
				break;
			case PAUSE:
				incNum(statusMap, "暂停");
				break;
			}
		}
		
		sexData = JSON.toJSONString(sexMap);
		System.out.println(sexData);
		ageData = JSON.toJSONString(ageMap);
		addressData = JSON.toJSONString(addressMap);
		statusData = JSON.toJSONString(statusMap);
		
		return "charts";
	}

	public ManagerService getManagerService() {
		return managerService;
	}

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}
	
	
	
	public String getSexData() {
		return sexData;
	}

	public void setSexData(String sexData) {
		this.sexData = sexData;
	}

	public String getAgeData() {
		return ageData;
	}

	public void setAgeData(String ageData) {
		this.ageData = ageData;
	}

	public String getAddressData() {
		return addressData;
	}

	public void setAddressData(String addressData) {
		this.addressData = addressData;
	}

	public String getStatusData() {
		return statusData;
	}

	public void setStatusData(String statusData) {
		this.statusData = statusData;
	}

	private void incNum(Map<String, Integer> map, String k){
		Integer num = map.get(k);
		if (map.get(k) == null){
			map.put(k, 1);
		}else{
			map.put(k, num + 1);
		}
	}
}
