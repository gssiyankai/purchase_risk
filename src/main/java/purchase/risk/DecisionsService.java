package purchase.risk;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/")
public class DecisionsService {

    private static final PurchaseController controller = new PurchaseController();

    @POST
    @Path("/decisions")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public PurchaseResponse process(PurchaseRequest request) {
        return controller.process(request);
    }

}
