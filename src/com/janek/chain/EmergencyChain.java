package com.janek.chain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by RENT on 2017-06-02.
 */
public class EmergencyChain {

    private List<ChainElement> chain;

    public EmergencyChain(){
        chain = new ArrayList<>();
        chain.add(new PoliceChainElement());
        chain.add(new FirefightersChainElement());
        chain.add(new AmbulanceChainElement());
    }

    public void invoke(int phoneNumber) {
        Iterator<ChainElement> iterator = chain.iterator();
        ChainElement chainElement = null;
        boolean flag = false;
        while (iterator.hasNext()) {
            ChainElement next = iterator.next();
            if(next.isMyResponsibility(phoneNumber)) {
                chainElement = next;
                flag = true;
            }
        }
        invoke(chainElement, phoneNumber);
    }

    private void invoke(ChainElement chainElement, int phoneNumber) {
        if(chainElement != null){
            chainElement.doAction(phoneNumber);
        } else {
            System.out.println("Nie znaleziono odpowiedniego elementu");
        }
    }
}
