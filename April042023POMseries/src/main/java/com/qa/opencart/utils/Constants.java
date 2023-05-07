package com.qa.opencart.utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {

    public static  final String LOGIN_PAGE_TITLE ="Account Login";
    public static final String LOGIN_PAGE_URL_FRACTION = "route=account/login";

    public static final String ACCOUNTS_PAGE_TITLE ="My Account";
    public static final int DEFAULT_TIMEOUT =5;
    public static final int IMAC_IMAGES_COUNT = 3;

    public static final int MACBOOKAIR_IMAGES_COUNT = 4;
    public static final int MACBOOKPRO_IMAGES_COUNT = 4;
    public static final String LOGIN_ERROR_MESSAGE = "Warning: No match for E-Mail Address and/or Password.";
	public static final String REGISTER_SUCCESS_MESSAGE = "Your Account Has Been Created!";
	public static final String REGISTER_SHEET_NAME = "registration";

    public static List<String> getExpectedAccSecList()
    {
      List<String> expSecList = new ArrayList<String>();
      expSecList.add("My Account");
      expSecList.add("My Orders");
      expSecList.add("My Affiliate Account");
      expSecList.add("Newsletter");
      return expSecList;
    }








}
