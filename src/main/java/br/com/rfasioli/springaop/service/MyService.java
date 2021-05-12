package br.com.rfasioli.springaop.service;

import br.com.rfasioli.springaop.aspect.IOActions;
import br.com.rfasioli.springaop.domain.Sample;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MyService {

    public MyService() {
    }

    public Sample serve(String inputName) {
        return Sample.newBuilder()
                .withUuid(UUID.randomUUID())
                .withName(inputName)
                .withScore(9.8)
                .withDescription("This is a sample domain object")
                .build();
    }
}
