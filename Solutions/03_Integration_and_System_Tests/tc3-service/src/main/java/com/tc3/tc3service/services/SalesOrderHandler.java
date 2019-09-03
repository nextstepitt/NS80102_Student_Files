// SalesOrderHandler.java
// Copyright © 2019 NextStep IT Training. All rights reserved.
//

package com.tc3.tc3service.services;

import com.tc3.tc3service.models.CardInfo;
import com.tc3.tc3service.models.SalesOrder;
import com.tc3.tc3service.models.SalesOrderItem;

import java.math.BigDecimal;
import java.util.Collection;

public class SalesOrderHandler {

    IAuthorizationProvider authorizationProvider;
    ICreditCardValidator creditCardValidator;

    public SalesOrderHandler(IAuthorizationProvider authorizationProvider, ICreditCardValidator creditCardValidator) {

        this.authorizationProvider = authorizationProvider;
        this.creditCardValidator = creditCardValidator;
    }

    public boolean CompleteSale(SalesOrder salesOrder, CardInfo cardInfo) {

        boolean result = true;

        if (validateSale(salesOrder) == false) {

            result = false;

        } else if (creditCardValidator.validateCardInfo(cardInfo) == false) {

            result = false;

        } else if (authorizationProvider.authorize(totalSalesOrder(salesOrder), cardInfo) == null) {

            return false;
        }

        return result;
    }

    private BigDecimal totalSalesOrder(SalesOrder salesOrder) {

        BigDecimal total = new BigDecimal(0);

        for (SalesOrderItem item : salesOrder.getSalesOrderItems()) {

            BigDecimal price = item.getPrice() != null ? item.getPrice() : new BigDecimal(0);
            BigDecimal quantity = new BigDecimal(item.getQuantity() != null ? item.getQuantity() : 0);

            total = total.add(price.multiply(quantity));
        }

        return total;
    }

    private boolean validateSale(SalesOrder salesOrder) {

        BigDecimal total = totalSalesOrder(salesOrder);

        return total.compareTo(new BigDecimal(0)) > 0 && total.compareTo(new BigDecimal(250.00)) <= 0;
    }
}
