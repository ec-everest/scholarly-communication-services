
package POJO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "AuN",
    "AuId"
})
public class AA {

    @JsonProperty("AuN")
    private String auN;
    @JsonProperty("AuId")
    private Integer auId;

    @JsonProperty("AuN")
    public String getAuN() {
        return auN;
    }

    @JsonProperty("AuN")
    public void setAuN(String auN) {
        this.auN = auN;
    }

    @JsonProperty("AuId")
    public Integer getAuId() {
        return auId;
    }

	@JsonProperty("AuId")
    public void setAuId(Integer auId) {
        this.auId = auId;
    }

    @Override
 	public String toString() {
 		return "Author name: " + auN;
 	}


}
