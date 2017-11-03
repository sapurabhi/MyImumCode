package com.imum.cpms.transactions.pvt;

public class DocsBean {
    public DocsBean() {
        super();
    }
    
    
    private String docPath;
    private String DocName;
 
    

    public void setDocPath(String docPath) {
        this.docPath = docPath;
    }

    public String getDocPath() {
        return docPath;
    }

    public void setDocName(String DocName) {
        this.DocName = DocName;
    }

    public String getDocName() {
        return DocName;
    }
}
