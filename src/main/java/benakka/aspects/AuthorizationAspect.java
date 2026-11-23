package benakka.aspects;

import benakka.aspects.SecurityContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class AuthorizationAspect {
    @Around(value="@annotation(securedBy)", argNames = "pjp,securedBy")
    public Object secure(ProceedingJoinPoint pjp, SecuredBy securedBy) throws Throwable {
        String[] roles = securedBy.roles();
        boolean authorized=false;
        for (String r:roles){
            if(benakka.aspects.SecurityContext.hasRole(r)){
                authorized=true;
                break;
            }
        }
        if (authorized==true){
            return pjp.proceed();
        }
        throw new RuntimeException("Unauthorized > 403");
    }
}
