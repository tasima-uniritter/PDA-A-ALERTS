package br.com.unirriter.bobsin.pdaaalert.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import br.com.unirriter.bobsin.pdaaalert.domain.Metric;

import java.io.IOException;

public class MetricSerializer extends StdSerializer<Metric> {

    public MetricSerializer() {
        this(Metric.class);
    }

    public MetricSerializer(Class<Metric> t) {
        super(t);
    }

    @Override
    public void serialize(Metric value, JsonGenerator gen, SerializerProvider arg2) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("code", String.valueOf(value.getCode()));
        gen.writeEndObject();
    }
}

