package br.com.rfasioli.springaop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rfasioli.springaop.repository.entity.ResponsePayload;

public interface ResponsePayloadRepository extends JpaRepository<ResponsePayload, Integer> {
}
