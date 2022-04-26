package com.app.util;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.app.entity.Role;
import com.app.exception.BusinessException;
import com.app.model.SessonUser;


@Aspect
@Component
public class SecurityImpl {

	
	  @Autowired
	     private SessonUser SessonUser; 
	@Around(value = "@annotation(SecurityInterface)" , argNames = "SecurityInterface")
	public Object checkSecurity( ProceedingJoinPoint proceedingJoinPoint, SecurityInterface securityInterface) throws BusinessException {
		securityInterface.checkApi();
		Object proceed=null;
		SecurityConstant checkSercurity = securityInterface.checkApi();
		System.err.println("value is "+checkSercurity);
		System.err.println("string  is "+checkSercurity.toString());
		try {
			
			System.err.println("TRY !!");
			
			if( SessonUser.getRoles()==null) {
				
				throw new BusinessException("session Time Out",null,HttpStatus.UNAUTHORIZED);
				
			}
			List<Role> roles = SessonUser.getRoles();
			for (Role role : roles) {
				System.err.println("name is "+role.getName());
			}
			try {
				String collect = roles.stream()
						.filter(p -> p.getName().equals(checkSercurity.toString())).collect(Collectors.toList()).get(0).getName();
				System.err.println("collect is "+collect);
			}
			catch (Exception e) {
				// TODO: handle exception
				throw new BusinessException("You don't have premission",null,HttpStatus.UNAUTHORIZED);

			}
//			} catch (Exception e) {
//				// TODO: handle exception
//				throw new BusinessException("you don;t have access");
//			}
			
			proceed = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
//			Exception ex = new Exception("bad request");
//			apiException.handleAllExceptions();
//			ResponseEntity<ErrorResponse> handleAllExceptions = apiException.handleAllExceptions();
			System.err.println("EXCV !!");
//		if(e.getMessage()==null) {
//			
//			throw new BusinessException("You don't have pression",null,HttpStatus.UNAUTHORIZED);
//		
//		}
			throw new BusinessException(e.getMessage(),null,HttpStatus.UNAUTHORIZED);
			
			
//	throw e;
		}
		return proceed;
	}
}
