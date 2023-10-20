package anderk222.cine.dto;

import com.google.gson.annotations.Expose;

import lombok.Data;

@Data
public class DoubleIdentificator {

    @Expose
    private long id;
    @Expose
    private long id2;
    
}
