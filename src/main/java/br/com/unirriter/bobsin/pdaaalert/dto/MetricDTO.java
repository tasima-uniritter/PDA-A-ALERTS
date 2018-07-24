package br.com.unirriter.bobsin.pdaaalert.dto;

import br.com.unirriter.bobsin.pdaaalert.tools.JsonConverter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;

@JsonDeserialize
@Data
public class MetricDTO {
    private String origin;
    private String metric;
    private Integer value;
    private String timestamp;
    private String rule;
    private Integer threshold;

    @Override
    public String toString() {
        return JsonConverter.objectToJson(this);
    }
}
