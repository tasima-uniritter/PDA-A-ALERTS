package br.com.unirriter.bobsin.pdaaalert.dto;

import br.com.unirriter.bobsin.pdaaalert.tools.JsonConverter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;

@JsonDeserialize
@Data
public class MetricDTO {
	@JsonProperty("origin")
    private String origin;
	
	@JsonProperty("metric")
	private String metric;

	@JsonProperty("value")
	private Integer value;
	
	@JsonProperty("timestamp")
    private String timestamp;
	
	@JsonProperty("rule")
    private String rule;
	
	@JsonProperty("threshold")
    private Integer threshold;

    @Override
    public String toString() {
        return JsonConverter.objectToJson(this);
    }
}
