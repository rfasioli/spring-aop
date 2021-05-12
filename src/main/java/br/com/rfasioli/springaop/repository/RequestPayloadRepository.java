package br.com.rfasioli.springaop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rfasioli.springaop.repository.entity.RequestPayload;

public interface RequestPayloadRepository extends JpaRepository<RequestPayload, Integer> {
}
