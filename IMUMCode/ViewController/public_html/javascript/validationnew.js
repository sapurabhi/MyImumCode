function emiratesIdFormatit12(evt) {
      var source = evt.getSource();
    var emiratesId;
    //mobileNumber = source.getValue("it34");
     // emiratesId = source.getSelecttedValue();
     emiratesId = source.getSubmittedValue();
      //alert(emiratesId);
      var length = emiratesId.length;
            //alert("length is :"+length);
            var value;
            if (length == 3) {
                //alert("In after3");
                value = emiratesId + "-";
                emiratesId = value;
            }else if (length == 8) {
            //alert("In after8");
            value = emiratesId + "-";
                emiratesId= value;
            }else if (length == 16) {
                value = emiratesId+"-";
               emiratesId= value;
            }else if (length == 17) {
                //alert("Inafter17"); 
                value = emiratesId+"-";
               emiratesId= value;
            }
            source.findComponent("it12").setValue(emiratesId);
      }