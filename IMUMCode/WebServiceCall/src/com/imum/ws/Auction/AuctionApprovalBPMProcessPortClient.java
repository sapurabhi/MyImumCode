package com.imum.ws.Auction;

import javax.xml.ws.WebServiceRef;
// !THE CHANGES MADE TO THIS FILE WILL BE DESTROYED IF REGENERATED!
// This source file is generated by Oracle tools
// Contents may be subject to change
// For reporting problems, use the following
// Version = Oracle WebServices (11.1.1.0.0, build 130224.1947.04102)

public class AuctionApprovalBPMProcessPortClient
{
  @WebServiceRef
  private static AuctionApprovalBPMProcessService auctionApprovalBPMProcessService;

  public static void main(String [] args)
  {
    auctionApprovalBPMProcessService = new AuctionApprovalBPMProcessService();
    AuctionApprovalBPMProcessPortType auctionApprovalBPMProcessPortType = auctionApprovalBPMProcessService.getAuctionApprovalBPMProcessPort();
    // Add your code to call the desired methods.
  }
}
