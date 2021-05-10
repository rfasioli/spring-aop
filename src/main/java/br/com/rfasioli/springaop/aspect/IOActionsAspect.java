package br.com.rfasioli.springaop.aspect;

import br.com.rfasioli.springaop.interfaces.InputAction;
import br.com.rfasioli.springaop.interfaces.OutputAction;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

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
        inputAction.execute(joinPoint.getArgs());
        Object proceed = joinPoint.proceed();
        outputAction.execute(proceed);
        return proceed;
    }

}
