package kr.co.greenapple.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kr.co.greenapple.beans.UserBean;

public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return UserBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserBean userBean = (UserBean)target;
		
		String beanName = errors.getObjectName();
		
//		회원가입 혹은 정보수정 시 유효성 검사
		if(beanName.equals("joinUserBean") || beanName.equals("modifyUserBean")) {
			if(userBean.getUser_pw().equals(userBean.getUser_pw2()) == false) {
				errors.rejectValue("user_pw", "NotEquals");
				errors.rejectValue("user_pw2", "NotEquals");
			}
		}
//		회원가입때만 하는 유효성 검사(아이디 중복 검사)
		if(beanName.equals("joinUserBean")) {
			
			if(userBean.isUserIdExist() == false) {
				errors.rejectValue("user_id", "DontCheckUserIdExist");
			}
			
		}
//		전화번호 중복 검사
		if(beanName.equals("joinUserBean")) {
			
			if(userBean.isUserIdExist() == false) {
				errors.rejectValue("user_tel", "DontCheckUserTelExist");
			}
			
		}
		
	}

}
