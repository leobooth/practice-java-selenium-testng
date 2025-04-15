package com.leobooth.practice.framework.elementWrapper;

import com.leobooth.practice.framework.elementWrapper.information.ElementInfo;
import com.leobooth.practice.framework.elementWrapper.interactions.ElementInteractions;

public final class Element {
    private Element() {}

    public static ElementInteractions action = new ElementInteractions();
    public static ElementInfo info = new ElementInfo();


}
