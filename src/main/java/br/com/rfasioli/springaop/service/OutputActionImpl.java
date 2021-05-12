package br.com.rfasioli.springaop.service;

import br.com.rfasioli.springaop.interfaces.OutputAction;
import br.com.rfasioli.springaop.repository.ResponsePayloadRepository;
import br.com.rfasioli.springaop.repository.entity.ResponsePayload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class OutputActionImpl implements OutputAction {

    private static final Logger LOGGER = LoggerFactory.getLogger(OutputActionImpl.class);

    private final ResponsePayloadRepository repository;

    public OutputActionImpl(ResponsePayloadRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(Object arg) {
        LOGGER.info(arg.toString());
        ResponsePayload responsePayload = new ResponsePayload();
        responsePayload.setPayload(arg.toString());
        responsePayload.setHttp_status(200);
        repository.save(responsePayload);
    }
}
