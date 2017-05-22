
package POJO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "prob",
    "Ti",
    "Id",
    "ECC",
    "AA"
})
public class Entity {

    @JsonProperty("prob")
    private Double prob;
	@JsonProperty("Ti")
    private String ti;
    @JsonProperty("Id")
    private Long id;
    @JsonProperty("ECC")
    private Integer ecc;
    @JsonProperty("AA")
    private List<AA> aA = new ArrayList<AA>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("prob")
    public Double getProb() {
        return prob;
    }

    @JsonProperty("prob")
    public void setProb(Double prob) {
        this.prob = prob;
    }

    @JsonProperty("Ti")
    public String getTi() {
        return ti;
    }

    @JsonProperty("Ti")
    public void setTi(String ti) {
        this.ti = ti;
    }

    @JsonProperty("Id")
    public Long getId() {
        return id;
    }

    @JsonProperty("Y")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("ECC")
    public Integer getECC() {
        return ecc;
    }

    @JsonProperty("ECC")
    public void setECC(Integer ecc) {
        this.ecc = ecc;
    }

    @JsonProperty("AA")
    public List<AA> getAA() {
        return aA;
    }

    @JsonProperty("AA")
    public void setAA(List<AA> aA) {
        this.aA = aA;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
    
    @Override
	public String toString() {
		return "{Id = " + id + ", ECC=" + ecc + ", Authors=" + aA + "}\n";
	}

}
