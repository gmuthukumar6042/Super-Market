package com.supermarket.businesslogic;

import com.supermarket.model.SupermMarketModel;

public class BusinessLogic {

	public boolean Logic(SupermMarketModel mobj) {
		if (mobj.getDeptid().equalsIgnoreCase("Admin")) {
			return true;
		} else
			return false;

	}

}
