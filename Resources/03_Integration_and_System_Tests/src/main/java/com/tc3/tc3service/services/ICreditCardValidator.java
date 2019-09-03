// ICreditCardValidator.java
// Copyright © 2019 NextStep IT Training. All rights reserved.
//

package com.tc3.tc3service.services;

import com.tc3.tc3service.models.CardInfo;

public interface ICreditCardValidator {

    boolean validateCardInfo(CardInfo cardInfo);
}
