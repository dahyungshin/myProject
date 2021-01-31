package interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class AdminInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		try{
		String adminYn= (String) session.getAttribute("admin");
		if(!adminYn.equals("Y"))
		{
			response.sendRedirect("error.ino");
			return false;
		}
			return true;
		}catch(NullPointerException e){
			return false;	
		}
	}
	
}
