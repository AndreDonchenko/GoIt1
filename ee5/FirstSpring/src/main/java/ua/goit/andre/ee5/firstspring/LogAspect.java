package ua.goit.andre.ee5.firstspring;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by Andre on 25.04.2016.
 */
public class LogAspect {
    private static final Logger log = Logger.getLogger(LogAspect.class);

    public Object onExecute(ProceedingJoinPoint pjp) throws Throwable {

        Object[] args = pjp.getArgs();
        StringBuilder argString = new StringBuilder();
        for (int i=0; i<args.length; i++) {
            argString.append(args[i]);
        }
        log.info ("CalcLog. Before execution: " + pjp.getSignature().getName() + " Arguments: " + argString);
        Object result = pjp.proceed();
        log.info ("CalcLog. After execution: " + pjp.getSignature().getName());
        return result;
    }
}
