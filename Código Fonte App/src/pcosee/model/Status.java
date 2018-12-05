package pcosee.model;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class Status {

    @NotNull
    private String status;
    @Valid
    private Date data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

}
