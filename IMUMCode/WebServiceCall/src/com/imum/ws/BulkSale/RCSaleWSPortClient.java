package com.imum.ws.BulkSale;

import javax.xml.ws.WebServiceRef;
// !THE CHANGES MADE TO THIS FILE WILL BE DESTROYED IF REGENERATED!
// This source file is generated by Oracle tools
// Contents may be subject to change
// For reporting problems, use the following
// Version = Oracle WebServices (11.1.1.0.0, build 130224.1947.04102)

public class RCSaleWSPortClient
{
  @WebServiceRef
  private static RCSaleWS_Service rCSaleWS_Service;

  public static void main(String [] args)
  {
    rCSaleWS_Service = new RCSaleWS_Service();
    RCSaleWS rCSaleWS = rCSaleWS_Service.getRCSaleWSPort();
    // Add your code to call the desired methods.
  }
}
