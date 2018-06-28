package br.com.unirriter.bobsin.pdaaalert.dto;

import br.com.unirriter.bobsin.pdaaalert.tools.JsonConverter;
import lombok.Data;


@Data
public class MetricDTO {
    private String metric;
    private String origin;
    private Integer value;
    private String rule;
    private String timestamp;
    private Integer threshold;

    @Override
    public String toString() {
        return JsonConverter.objectToJson(this);
    }
}
