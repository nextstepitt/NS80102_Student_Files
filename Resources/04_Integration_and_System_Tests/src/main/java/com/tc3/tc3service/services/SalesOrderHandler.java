package com.tc3.tc3service.services;

import com.tc3.tc3service.models.CardInfo;
import com.tc3.tc3service.models.SalesOrder;
import com.tc3.tc3service.models.SalesOrderItem;

import java.math.BigDecimal;

public class SalesOrderHandler {

    ICreditCardValidator creditCardValidator;
    IAuthorizationProvider authorizationProvider;

    public SalesOrderHandler(ICreditCardValidator validator, IAuthorizationProvider provider) {

        creditCardValidator = validator;
        authorizationProvider = provider;
    }

    public boolean CompleteSale(SalesOrder salesOrder, CardInfo cardInfo) {

        boolean result = true;

        if (ValidateSale(salesOrder) == false) {

            result = false;

        } else if (creditCardValidator.validateCardInfo(cardInfo) == false) {

            result = false;

        } else if (authorizationProvider.authorize(new BigDecimal(0.00), cardInfo) == null) {

            return false;
        }

        return result;
    }

    private BigDecimal TotalSalesOrder(SalesOrder salesOrder) {

        BigDecimal total = new BigDecimal(0);

        for (SalesOrderItem item : salesOrder.getSalesOrderItems()) {

            BigDecimal price = item.getPrice() != null ? item.getPrice() : new BigDecimal(0);
            BigDecimal quantity = new BigDecimal(item.getQuantity() != null ? item.getQuantity() : 0);

            total = total.add(price.multiply(quantity));
        }

        return total;
    }

    private boolean ValidateSale(SalesOrder salesOrder) {

        BigDecimal total = TotalSalesOrder(salesOrder);

        return total.compareTo(new BigDecimal(0)) > 0 && total.compareTo(new BigDecimal(250.00)) <= 0;
    }
}
