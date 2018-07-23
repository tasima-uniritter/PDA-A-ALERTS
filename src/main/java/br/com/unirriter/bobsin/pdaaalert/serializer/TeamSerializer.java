package br.com.unirriter.bobsin.pdaaalert.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import br.com.unirriter.bobsin.pdaaalert.domain.Team;

import java.io.IOException;

public class TeamSerializer extends StdSerializer<Team> {

    public TeamSerializer() {
        this(Team.class);
    }

    public TeamSerializer(Class<Team> t) {
        super(t);
    }

    @Override
    public void serialize(Team value, JsonGenerator gen, SerializerProvider arg2) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("name", value.getTeamName());
        gen.writeEndObject();
    }
}

