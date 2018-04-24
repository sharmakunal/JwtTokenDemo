package rest;

import org.apache.commons.codec.binary.Base64;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import util.JWTUtil;

@RestController
//@RequestMapping("token")
public class UserController {
	
	@RequestMapping(value = "/gettoken", method = RequestMethod.GET)
	public @ResponseBody String getToken() throws Exception {
		return Base64.encodeBase64String(JWTUtil.createJWT().getBytes());
	}
}
