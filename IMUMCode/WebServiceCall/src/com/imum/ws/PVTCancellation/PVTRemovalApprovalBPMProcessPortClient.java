package com.imum.ws.PVTCancellation;

import javax.xml.ws.WebServiceRef;
// !THE CHANGES MADE TO THIS FILE WILL BE DESTROYED IF REGENERATED!
// This source file is generated by Oracle tools
// Contents may be subject to change
// For reporting problems, use the following
// Version = Oracle WebServices (11.1.1.0.0, build 130224.1947.04102)

public class PVTRemovalApprovalBPMProcessPortClient
{
  @WebServiceRef
  private static PVTRemovalApprovalBPMProcessService pVTRemovalApprovalBPMProcessService;

  public static void main(String [] args)
  {
    pVTRemovalApprovalBPMProcessService = new PVTRemovalApprovalBPMProcessService();
    PVTRemovalApprovalBPMProcessPortType pVTRemovalApprovalBPMProcessPortType = pVTRemovalApprovalBPMProcessService.getPVTRemovalApprovalBPMProcessPort();
    // Add your code to call the desired methods.
  }
}
