package benakka.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Component
@Aspect
@EnableAspectJAutoProxy
public class CacheableAspect {

    private Map<String, Object> cache = new HashMap<>();

    @Around("@annotation(benakka.aspects.Cacheable)")
    public Object handleCache(ProceedingJoinPoint joinPoint) throws Throwable {

        String key = joinPoint.getTarget().toString() + joinPoint.getSignature().getName();
        Logger logger=Logger.getLogger(CacheableAspect.class.getName());
        if (cache.containsKey(key)) {
            logger.info("Résultat récupéré du cache");
            return cache.get(key);
        }

        Object result = joinPoint.proceed();
        cache.put(key, result);
        logger.info("Résultat ajouté au cache");

        return result;
    }
}
