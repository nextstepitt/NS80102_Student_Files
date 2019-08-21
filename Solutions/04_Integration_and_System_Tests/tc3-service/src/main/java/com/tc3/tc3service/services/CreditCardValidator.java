// CreditCardValidator.java
// Copyright © 2019 NextStep IT Training. All rights reserved.
//

package com.tc3.tc3service.services;

import com.tc3.tc3service.models.CardInfo;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;

/**
 * Credit card validation services
 *
 * <p>Used before trying to authorize a purchase to eliminate unecessary
 * requests to the authorization provider.</p>
 */
public class CreditCardValidator implements ICreditCardValidator {

    /**
     * Validate the card info
     *
     * <p>Rejections are not explained.</p>
     *
     * @param cardInfo the data to verify
     * @return true if the card is accepted
     */
    public boolean validateCardInfo(CardInfo cardInfo) {

        boolean result = true;

        if (validateCardNumber(cardInfo.getCardNumber()) == false) {

            result = false;

        } else if (validateProvider(cardInfo.getCardNumber()) == false) {

            result = false;

        } else if (validateExpirationDate(cardInfo.getExpires()) == false) {

            result = false;

        } else if (validateCCV(cardInfo.getCcv()) == false) {

            result = false;
        }

        return result;
    }

    /**
     * Verify an expiration date
     *
     * <p>Verify a card expiration data is within bounds, from today to today + five years.
     * Expiration dates hold the month and year of expiration, the day is irrelevant.</p>
     *
     * @param date a java.sql.Date with the month and year of expiration
     * @return true if the expiration date is accepted
     */
    private boolean validateExpirationDate(Date date) {

        boolean result = false;

        // Date compairsons are easy. To check to make sure a date is before an expiration
        // date we change the expiration date to 00:00 of the 1st of the month that follows,
        // because any DateTime in front of that time is still valid. We don't worry about
        // time zones; in the real world we shouldn't accept a card that is within a few
        // hours of cutoff, and it is really up to the provider to accept or reject it if
        // it is close.

        LocalDate when = date.toLocalDate();
        Calendar check = new Calendar.Builder().setCalendarType("iso8601").setDate(when.getYear(), when.getMonthValue(), 1).build();

        // Accept the card if the date is greator than the beginning of the current month,
        // which is found by getting the 1st of the current month. And, accept the card if
        // the date is less than five years from now, which is found by adding five years
        // and one month to bump it to the first of the following month.

        Calendar previous = Calendar.getInstance();
        previous.set(Calendar.DAY_OF_MONTH, 1);

        Calendar future = Calendar.getInstance();
        future.set(Calendar.DAY_OF_MONTH, 1);
        future.add(Calendar.MONTH, 1);
        future.add(Calendar.YEAR, 5);

        if (check.compareTo(previous) > 0 && check.compareTo(future) <= 0) {

            result = true;
        }

        return result;
    }

    /**
     *  Check the card number
     *
     *  <p>Check the validity of the card number using the Luhn algorithm. Invalid characters will cause the calculation
     *  to return false. Empty strings will cause a false return. Null strings are unexpected and will cause an exception.</p>
     *
     * @param cardNumber the string with the card number to check
     * @return true if the number is accepted
     * @throws NullPointerException null was passed for the card number
     */
    private boolean validateCardNumber(String cardNumber) {

        boolean result = false;

        int sum = 0;

        for (int i = cardNumber.length() - 1; i >= 0; --i) {

            int digit = Character.getNumericValue(cardNumber.charAt(i)) * (((i % 2) == (cardNumber.length() % 2)) ? 2 : 1);

            sum += (digit > 9) ? digit - 9 : digit;
        }

        if (sum > 0 && sum % 10 == 0) {

            result = true;
        }

        return result;
    }

    /**
     * Validate the CCV code
     *
     * @param ccv the CCV code
     * @return true if the CCV code is from a provider accepted
     */
    private boolean validateCCV(int ccv) {

        return ccv >= 100;
    }

    /**
     * Validate the provider
     *
     * <p>Validate that the card is from a provider we will accept. Visa starts with 4, American Express
     * starts with 34 or 37, and Mastercard starts with 51-55, and 222100-272099.</p>
     *
     * @param cardNumber the card number to check
     * @return true if the card is from a provider we accept
     */

    private boolean validateProvider(String cardNumber) {

        boolean result = false;
        int provider = Integer.parseInt(cardNumber.substring(0, 6));

        if (provider >= 400000 && provider <= 499999) {

            result = true;

        } else if (provider >= 510000 && provider <= 559999) {

            result = true;

        } else if ((provider >= 340000 && provider <= 349999)
                || (provider >= 370000 && provider <= 379999)) {

            result = true;

        } else if (provider >= 222100 && provider <= 272099) {

            result = true;
        }

        return result;
    }
}
