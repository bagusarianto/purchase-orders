package com.programato.api;

import com.programato.models.PurchaseOrder;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@Path("/api/purchase")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PurchaseResource {
    @GET
    public List<PurchaseOrder> index() {
        return PurchaseOrder.listAll();
    }

    @POST
    @Transactional
    public PurchaseOrder create(PurchaseOrder po) {
        po.details = po
                .details.
                        stream().map(r -> {
                    r.itemTotal = r.quantity * r.itemPrice;
                    return r;
                })
                .collect(Collectors.toList());
        po.persist();
        return po;
    }
}
