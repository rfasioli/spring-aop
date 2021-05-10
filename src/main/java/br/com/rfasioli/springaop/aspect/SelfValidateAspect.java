package br.com.rfasioli.springaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.validation.*;
import java.util.Set;

@Aspect
@Component
public class SelfValidateAspect {

    private final Validator validator;

    public SelfValidateAspect() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }

    @Around("@annotation(SelfValidate)")
    public Object ioActions(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = joinPoint.proceed();
        Set<ConstraintViolation<Object>> violations = validator.validate(joinPoint.getThis());

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }

        return result;
    }
}
