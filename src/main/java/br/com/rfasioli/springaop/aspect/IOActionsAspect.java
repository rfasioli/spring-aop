package br.com.rfasioli.springaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Optional;

import br.com.rfasioli.springaop.interfaces.InputAction;
import br.com.rfasioli.springaop.interfaces.OutputAction;

@Aspect
@Component
public class IOActionsAspect {

    private final InputAction inputAction;
    private final OutputAction outputAction;

    public IOActionsAspect(InputAction inputAction, OutputAction outputAction) {
        this.inputAction = inputAction;
        this.outputAction = outputAction;
    }

    @Around("@annotation(IOActions)")
    public Object ioActions(ProceedingJoinPoint joinPoint) throws Throwable {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Annotation[] annotations = signature.getMethod().getAnnotations();

        Optional<IOActions> filtered = Arrays.stream(annotations)
                .filter(a -> a.annotationType().equals(IOActions.class))
                .map(o -> (IOActions)o)
                .findFirst();

        Arrays.stream(filtered.get().args()).forEach(arg ->
                inputAction.execute(joinPoint.getArgs()[Integer.parseInt(arg)]));

        Object proceed = joinPoint.proceed();
        outputAction.execute(proceed);
        return proceed;
    }

}
