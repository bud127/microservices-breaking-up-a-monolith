package com.xebia.msa.rest;


import com.xebia.msa.domain.Orderr;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class OrderResourceAssembler extends ResourceAssemblerSupport<Orderr, OrderResource> {

    public OrderResourceAssembler() {
        super(OrderController.class, OrderResource.class);
    }

    @Override
    public OrderResource toResource(Orderr orderr) {

        OrderResource resource = createResourceWithId(orderr.getUuid(), orderr);
        BeanUtils.copyProperties(orderr, resource);

        return resource;
    }

    public Orderr toClass(OrderResource resource){

        Orderr orderr = new Orderr(resource.getUuid(), resource.getOrdered(), resource.getShippingAddress(), resource.getStatus());
        orderr.setAccount(resource.getAccount());
        orderr.setPayment(resource.getPayment());
        orderr.setShipped(resource.getShipped());
        orderr.setShoppingCart(resource.getShoppingCart());
        return orderr;
    }
}
