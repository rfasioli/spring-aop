package br.com.rfasioli.springaop.service;

import br.com.rfasioli.springaop.interfaces.OutputAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class OutputActionImpl implements OutputAction {

    private static final Logger LOGGER = LoggerFactory.getLogger(OutputActionImpl.class);

    @Override
    public void execute(Object arg) {
        LOGGER.info(arg.toString());
    }
}
