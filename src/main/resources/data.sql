DROP TABLE IF EXISTS outbox;
DROP TABLE IF EXISTS request_payload;
DROP TABLE IF EXISTS response_payload;

CREATE TABLE outbox (
  idt_outbox INT AUTO_INCREMENT  PRIMARY KEY,
  des_payload VARCHAR(25000) NOT NULL,
  nam_dispatcher VARCHAR(250) NOT NULL,
  cod_status VARCHAR(30) NOT NULL,
  dt_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);

CREATE TABLE request_payload (
  idt_request_payload INT AUTO_INCREMENT  PRIMARY KEY,
  des_payload VARCHAR(25000) NOT NULL,
  dt_created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE response_payload (
  idt_response_payload INT AUTO_INCREMENT  PRIMARY KEY,
  des_payload VARCHAR(25000) NOT NULL,
  cod_http_status INT NOT NULL,
  dt_created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
