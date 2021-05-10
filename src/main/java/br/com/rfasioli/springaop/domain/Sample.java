package br.com.rfasioli.springaop.domain;

import br.com.rfasioli.springaop.aspect.SelfValidate;

import java.util.UUID;

public class Sample {

    private UUID uuid;
    private String name;
    private String description;
    private Double score;

    private Sample(Builder builder) {
        uuid = builder.uuid;
        name = builder.name;
        description = builder.description;
        score = builder.score;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(Sample copy) {
        Builder builder = new Builder();
        builder.uuid = copy.getUuid();
        builder.name = copy.getName();
        builder.description = copy.getDescription();
        builder.score = copy.getScore();
        return builder;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getScore() {
        return score;
    }


    public static final class Builder {
        private UUID uuid;
        private String name;
        private String description;
        private Double score;

        private Builder() {
        }

        public Builder withUuid(UUID uuid) {
            this.uuid = uuid;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withScore(Double score) {
            this.score = score;
            return this;
        }

        @SelfValidate
        public Sample build() {
            return new Sample(this);
        }
    }
}
