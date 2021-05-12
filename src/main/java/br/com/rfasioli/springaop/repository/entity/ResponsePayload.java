package br.com.rfasioli.springaop.repository.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "response_payload")
public class ResponsePayload {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idt_response_payload")
    Integer id;

    @Column(name = "des_payload")
    String payload;

    @Column(name = "cod_http_status")
    Integer http_status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public Integer getHttp_status() {
        return http_status;
    }

    public void setHttp_status(Integer http_status) {
        this.http_status = http_status;
    }

}
