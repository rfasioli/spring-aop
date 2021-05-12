package br.com.rfasioli.springaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@Aspect
@Component
public class SelfValidateAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(SelfValidateAspect.class);

    private final Validator validator;

    public SelfValidateAspect() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }

    @Around("@annotation(SelfValidate)")
    public Object ioActions(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = joinPoint.proceed();

        LOGGER.info(String.format("Validando %s", joinPoint.getSignature().getName()));

        Set<ConstraintViolation<Object>> violations = validator.validate(joinPoint.getThis());

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }

        LOGGER.info(String.format("%s validado!", joinPoint.getSignature().getName()));

        return result;
    }
}
