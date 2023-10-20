package anderk222.cine.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;

import anderk222.cine.util.gson.LocalDateAdapter;
import anderk222.cine.util.gson.LocalDateTimeAdapter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {

    @Expose
    private String msgUsuario;
    @Expose
    private String msgTecnico;
    @Expose
    private JsonElement body;
    @Expose
    private String code;

    // Constructores

    public Response(ResponseEnum rEnum, Object body) {

        this.body = body == null ? null : getGson().toJsonTree(body);
        this.msgUsuario = rEnum.msgUsuario;
        this.code = rEnum.codRespuesta;
        this.msgTecnico = rEnum.msgTecnico;
    }

    public Response(Object body) {

        this.body = body == null ? null : (JsonObject) getGson().toJsonTree(body);
    }

    public Response(ResponseEnum rEnum) {

        this.msgUsuario = rEnum.msgUsuario;
        this.code = rEnum.codRespuesta;
        this.msgTecnico = rEnum.msgTecnico;
    }

    // Static methods

    public static Response resEnum(ResponseEnum rEnum) {

        return new Response(rEnum, null);

    }

    public static Response body(Object body) {

        return new Response(ResponseEnum.RESPONSE_OK, body);

    }

    public static Response ok() {

        return new Response(ResponseEnum.RESPONSE_OK);

    }

    // Methods

    public Response setResEnum(ResponseEnum rEnum) {

        this.msgUsuario = rEnum.msgUsuario;
        this.code = rEnum.codRespuesta;
        this.msgTecnico = rEnum.msgTecnico;

        return this;

    }

    public Response setBody(Object body) {

        this.body = body == null ? null : (JsonObject) getGson().toJsonTree(body);

        return this;

    }

    public Response msgTecnico(String msg) {

        this.msgTecnico = msg;
        return this;

    }

    public Response msgUsuario(String msg) {

        this.msgUsuario = msg;

        return this;
    }

    public boolean isSuccess(){

        return this.code.equalsIgnoreCase(ResponseEnum.RESPONSE_OK.codRespuesta);

    }

    private static Gson getGson() {

        return new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .serializeNulls()
                .create();
    }

}