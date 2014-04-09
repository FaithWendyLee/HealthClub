package action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 基础的Action类，实现了Action需要的公用属性和公用方法
* @author 王选易
* @version 1.0
* @since 1.7
*/
public class BaseAction extends ActionSupport implements SessionAware,
		ServletRequestAware, ServletResponseAware {
	private static final long serialVersionUID = 1L;

	public HttpServletRequest request;
	public HttpServletResponse response;
	public Map<String, Object> session;

	/**
	 * 设置返回过去的HttpResponse
	 */
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	/**
	 * 设置换送过来的HttpRequest
	 */
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * 设置当前用户的session，
	 * @param Map 参数为一个Map而不是一个session
	 */
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
