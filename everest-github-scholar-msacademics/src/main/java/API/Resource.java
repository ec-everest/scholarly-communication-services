package API;

import java.net.URI;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.*;

import POJO.*;

@Path("/")
public class Resource {
	@GET
	@Path("MASpaper/{title: .+}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getPapers(@PathParam("title") String title) throws Exception{
		if (title == null || title.isEmpty()){
			//HTTP 400: bad request
			return Response.status(400).entity("Introduzca un título (las palabras del título deben estar separadas por espacios)").build();
		}
		HttpClient httpclient = HttpClients.createDefault();
		//Building URIs according to microsoft academid api structure
		String t = title.toLowerCase().replaceAll("[-']", " ").replaceAll("[():,.\"]","").replace("[","").replace("]", "").replace("/", " ")
				.replaceAll("\\s+", " ");
		URIBuilder builder = new URIBuilder("https://api.projectoxford.ai/academic/v1.0/evaluate");
		builder.setParameter("expr",  "Ti='"+t+"'");
		builder.setParameter("model", "latest");
		builder.setParameter("attributes", "Id,ECC,AA.AuN"); //Returns ID of paper, number of citations and author of the paper
		URI uri = builder.build();
		HttpGet request = new HttpGet(uri);
		//Header for accessing the API 
		request.setHeader("Ocp-Apim-Subscription-Key", "3ec18e264e4549a9b05de0a7b18daf2e");

		HttpResponse response = httpclient.execute(request);
		HttpEntity entity = response.getEntity();
		
		if (entity != null) {
			Query q = new Query();
			ObjectMapper mapper = new ObjectMapper();
			String json = EntityUtils.toString(entity);
			q = mapper.readValue(json, Query.class);
			if (q.getEntities().isEmpty()){
				//HTTP 204: no content
				return Response.status(200).entity("La búsqueda no produjo ningún resultado").build();
			}
			else{
				return Response.status(200).entity(json).build();
			}
		}
		else{ 
			return Response.status(400).entity("No hubo respuesta por parte del servidor").build();
		}
		
	}
}
