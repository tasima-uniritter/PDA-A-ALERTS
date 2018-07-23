package br.com.unirriter.bobsin.pdaaalert.dto;

import br.com.unirriter.bobsin.pdaaalert.tools.JsonConverter;
import lombok.Data;


@Data
public class MetricDTO {
    private String origin;
    private Long metric;
    private Integer value;
    private String timestamp;
    private String rule;
    private Integer threshold;

    @Override
    public String toString() {
        return JsonConverter.objectToJson(this);
    }
}
