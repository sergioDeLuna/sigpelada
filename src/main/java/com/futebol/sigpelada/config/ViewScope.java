package com.futebol.sigpelada.config;

import java.util.Map;

import javax.faces.context.FacesContext;

import org.springframework.beans.factory.ObjectFactory;

//public class ViewScope implements org.springframework.beans.factory.config.Scope {
//
//    public Object get(String name, ObjectFactory<?> objectFactory) {
//        if (FacesContext.getCurrentInstance().getViewRoot() != null) {
//            Map<String, Object> viewMap = FacesContext.getCurrentInstance().getViewRoot().getViewMap(); //Map do JSF cujo os valores são referentes ao escopo de view
//            if (viewMap.containsKey(name)) {
//                return viewMap.get(name);
//            } else {
//                Object object = objectFactory.getObject();
//                viewMap.put(name, object); //da próxima vez que for requisitado, dentro do escopo de view, ele não precisará ser construído.
//                return object;
//            }
//        } else {
//            return null;
//        }
//    }
//
//    public Object remove(String name) {
//        if (FacesContext.getCurrentInstance().getViewRoot() != null) {
//            return FacesContext.getCurrentInstance().getViewRoot().getViewMap().remove(name); //simplesmente, remove o bean Spring do ViewMap JSF
//        } else {
//            return null;
//        }
//    }
//
//    @Override
//    public void registerDestructionCallback(String name, Runnable callback) {}
//
//    @Override
//    public Object resolveContextualObject(String key) {
//        return null;
//    }
//
//    @Override
//    public String getConversationId() {
//        return null;
//    }
//
//}
