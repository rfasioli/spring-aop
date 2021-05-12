package br.com.rfasioli.springaop.service;

import br.com.rfasioli.springaop.interfaces.InputAction;
import br.com.rfasioli.springaop.repository.RequestPayloadRepository;
import br.com.rfasioli.springaop.repository.entity.RequestPayload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Component
public class InputActionImpl implements InputAction {

    private static final Logger LOGGER = LoggerFactory.getLogger(InputActionImpl.class);

    private final RequestPayloadRepository repository;

    public InputActionImpl(RequestPayloadRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(Object arg) {
        LOGGER.info(arg.toString());
        RequestPayload requestPayload = new RequestPayload();
        requestPayload.setPayload(arg.toString());
        repository.save(requestPayload);
    }
}
