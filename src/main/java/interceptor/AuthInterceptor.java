package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.binary.Base64;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import lombok.extern.slf4j.Slf4j;
import util.JWTUtil;

@Slf4j
public class AuthInterceptor extends HandlerInterceptorAdapter{

	private static String AUTH_TOKEN = "Authorization";
	private static String TOKEN_INITITAL = "Bearer ";
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		try {
			String tokenFromRequest = request.getHeader(AUTH_TOKEN);
			
			//try to get index value of token 
			int tokenValueIndex = tokenFromRequest == null ? -1 : tokenFromRequest.indexOf("Bearer ");
			
			//check if we get token from request
			if (StringUtils.isEmpty(tokenFromRequest) 
					|| !tokenFromRequest.startsWith(TOKEN_INITITAL)) {
				response.sendError(401);
				return false;
			}
			
			String token = tokenFromRequest.replace(TOKEN_INITITAL, "");
			
			tokenFromRequest = new String(Base64.decodeBase64(token));
			//just check validtity of token as we are not verifying other params
			JWTUtil.parseJWT(tokenFromRequest);
			return true;
		}catch(Exception ex){
			log.error("error authenticaing token", ex);
			response.sendError(401);
			return false;
		}
	}

}
