package com.imum.cpms.view.backing;

import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.RichForm;
import oracle.adf.view.rich.component.rich.data.RichTree;
import oracle.adf.view.rich.component.rich.fragment.RichRegion;
import oracle.adf.view.rich.component.rich.output.RichMessages;
import oracle.adf.view.rich.component.rich.output.RichOutputText;

import org.apache.myfaces.trinidad.component.UIXGroup;

public class Home {
    private RichForm f1;
    private RichDocument d1;
    private RichMessages m1;
    private RichTree t1;
    private RichOutputText ot1;
    
    private RichRegion r1;
    private UIXGroup g1;
    private RichRegion r2;
    private String outCome;

    public void setF1(RichForm f1) {
        this.f1 = f1;
    }

    public RichForm getF1() {
        return f1;
    }

    public void setD1(RichDocument d1) {
        this.d1 = d1;
    }

    public RichDocument getD1() {
        return d1;
    }

    public void setM1(RichMessages m1) {
        this.m1 = m1;
    }

    public RichMessages getM1() {
        return m1;
    }


    public void setT1(RichTree t1) {
        this.t1 = t1;
    }

    public RichTree getT1() {
        return t1;
    }

    public void setOt1(RichOutputText ot1) {
        this.ot1 = ot1;
    }

    public RichOutputText getOt1() {
        return ot1;
    }


    public void setR1(RichRegion r1) {
        this.r1 = r1;
    }

    public RichRegion getR1() {
        return r1;
    }

    public void setG1(UIXGroup g1) {
        this.g1 = g1;
    }

    public UIXGroup getG1() {
        return g1;
    }

    public void setR2(RichRegion r2) {
        this.r2 = r2;
    }

    public RichRegion getR2() {
        return r2;
    }

    public void setOutCome(String outCome) {
        this.outCome = outCome;
    }

    public String getOutCome() {
        return outCome;
    }
    
    public String getTestPage() {
        outCome = "success";
        return null;
    }
}
