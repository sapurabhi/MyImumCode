package com.imum.ws.PVTIssuance;

import javax.xml.ws.WebServiceRef;
// !THE CHANGES MADE TO THIS FILE WILL BE DESTROYED IF REGENERATED!
// This source file is generated by Oracle tools
// Contents may be subject to change
// For reporting problems, use the following
// Version = Oracle WebServices (11.1.1.0.0, build 130224.1947.04102)

public class PVT_ObservationOrIssuance_ptClient
{
  @WebServiceRef
  private static Pvt_observationorissuance_client_ep pvt_observationorissuance_client_ep;

  public static void main(String [] args)
  {
    pvt_observationorissuance_client_ep = new Pvt_observationorissuance_client_ep();
    PVT_ObservationOrIssuance pVT_ObservationOrIssuance = pvt_observationorissuance_client_ep.getPVT_ObservationOrIssuance_pt();
    // Add your code to call the desired methods.
  }
}
