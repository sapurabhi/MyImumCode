package com.imum.cpms.util;

import com.imum.cpms.model.masters.vo.GenRoleUVORowImpl;
import com.imum.cpms.model.masters.vo.LocationMstVORowImpl;

import com.imum.cpms.model.transactions.vo.PVTDocsVOImpl;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;

public class Shuttle {
    public Shuttle() {
    }

    public static List<SelectItem> getAll(String iteratorName,
                                          String valueAttrName,
                                          String displayAttrName) {
        return ADFUtils.selectItemsForIterator(iteratorName, valueAttrName,
                                               displayAttrName);
    }

    public static List getSelected(String iteratorName, String attrName) {
        List selected = new ArrayList();
        DCIteratorBinding iterator =
            ((DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry()).findIteratorBinding(iteratorName);
        Row[] rowSet = iterator.getAllRowsInRange();
        for (Row r : rowSet) {
            selected.add(r.getAttribute(attrName));
        }
        return selected;
    }

    public static void setSelected(List selectedValues, String pkAttName,
                                   String fkIteratorName, String fk1AttName,
                                   String fk2AttName, String deleteOpName,
                                   String createInsertOpName,String clickedButtonVal) {
        if (selectedValues == null)
            selectedValues = new ArrayList(0);
        DCBindingContainer dcbindings =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        Object pkAtt = ADFUtils.getBoundAttributeValue(pkAttName);
        DCIteratorBinding iterator =
            dcbindings.findIteratorBinding(fkIteratorName);
        OperationBinding deleteOp =
            dcbindings.getOperationBinding(deleteOpName);
        OperationBinding createInsertOp =
            dcbindings.getOperationBinding(createInsertOpName);

        Row[] rowSet = iterator.getAllRowsInRange();
        for (Row row : rowSet) {
            Object fk2Att = row.getAttribute(fk2AttName);
            if (!selectedValues.contains(fk2Att)) {
                iterator.setCurrentRowWithKey(row.getKey().toStringFormat(true));
                deleteOp.execute();
            } else {
                selectedValues.remove(fk2Att);
            }
        }
        if(clickedButtonVal !=null && clickedButtonVal.equalsIgnoreCase("NEW")) {
          newRoleCommit(selectedValues,createInsertOpName,fkIteratorName);
        }
        else
        {
        for (Object val : selectedValues) {
            java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
            createInsertOp.execute();
            Row row = iterator.getCurrentRow();
            row.setAttribute(fk2AttName, val);
            row.setAttribute(fk1AttName, pkAtt);
            row.setAttribute("CreatedDate",sqlDate);
            row.setAttribute("Updatedate",sqlDate);
            row.setAttribute("activeflag", "Y");
            
        }
        }
    }

    public static String newRoleCommit(List selectedValues,String createInsertOpName,String fkIteratorName) {
        DCBindingContainer dcbindings = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
            OperationBinding roleCommit =
            dcbindings.getOperationBinding("MenuRoleCommit");
            roleCommit.execute();
           if(roleCommit.getErrors().size()>0) {
              return "";
            }
                
        OperationBinding createInsertOp =
            dcbindings.getOperationBinding(createInsertOpName);
            
        DCBindingContainer bindings =
                      (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBindings =
             bindings.findIteratorBinding("GenRoleUVO1Iterator1");
        ViewObject genRole = dcItteratorBindings.getViewObject();
        genRole.executeQuery();
        //Getting Newly inserted values
        GenRoleUVORowImpl genRoleImpl = (GenRoleUVORowImpl)genRole.first(); 
    
        BigDecimal roleID = genRoleImpl.getRoleID();
        System.out.println("RoleID  :::::::::::::::::   "+roleID); 
        DCIteratorBinding iterator = dcbindings.findIteratorBinding(fkIteratorName);
        if(roleID!=null){
        for (Object val : selectedValues) {
            System.out.println("MenuID  :::::::::::::::::   "+val); 
            java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
            createInsertOp.execute();
            Row row = iterator.getCurrentRow();
            row.setAttribute("MenuID", val);
            row.setAttribute("RoleID",roleID);
            row.setAttribute("CreatedDate",sqlDate);
            row.setAttribute("activeflag", "Y");
          }
        }
        return null;
        
    }

}
