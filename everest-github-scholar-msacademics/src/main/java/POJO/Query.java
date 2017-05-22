
package POJO;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "expr",
    "entities"
})
public class Query {

    @JsonProperty("expr")
    private String expr;
    @JsonProperty("entities")
    private List<Entity> entities = new ArrayList<Entity>();

    @JsonProperty("expr")
    public String getExpr() {
        return expr;
    }

    @JsonProperty("expr")
    public void setExpr(String expr) {
        this.expr = expr;
    }

    @JsonProperty("entities")
    public List<Entity> getEntities() {
        return entities;
    }

    @JsonProperty("entities")
    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }

	@Override
	public String toString() {
        return expr + "\n" + entities + "\n";
	}

}
