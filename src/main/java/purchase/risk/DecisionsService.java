package purchase.risk;

import com.sun.jersey.spi.resource.Singleton;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Singleton
@Path("/")
public class DecisionsService {

    private final PurchaseController controller = new PurchaseController();

    @POST
    @Path("/decisions")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public PurchaseResponse process(PurchaseRequest request) {
        return controller.process(request);
    }

}
