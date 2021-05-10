package br.com.rfasioli.springaop.service;

import br.com.rfasioli.springaop.interfaces.InputAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class InputActionImpl implements InputAction {

    private static final Logger LOGGER = LoggerFactory.getLogger(InputActionImpl.class);

    @Override
    public void execute(Object[] args) {
        Arrays.asList(args).forEach(arg -> LOGGER.info(arg.toString()));
    }
}
