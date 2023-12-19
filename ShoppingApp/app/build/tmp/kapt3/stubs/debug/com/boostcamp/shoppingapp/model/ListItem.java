package com.boostcamp.shoppingapp.model;

import java.io.Serializable;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\b"}, d2 = {"Lcom/boostcamp/shoppingapp/model/ListItem;", "Ljava/io/Serializable;", "viewType", "Lcom/boostcamp/shoppingapp/model/ViewType;", "getViewType", "()Lcom/boostcamp/shoppingapp/model/ViewType;", "getKey", "", "app_debug"})
public abstract interface ListItem extends java.io.Serializable {
    
    @org.jetbrains.annotations.NotNull
    public abstract com.boostcamp.shoppingapp.model.ViewType getViewType();
    
    public abstract int getKey();
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 3)
    public final class DefaultImpls {
        
        public static int getKey(@org.jetbrains.annotations.NotNull
        com.boostcamp.shoppingapp.model.ListItem $this) {
            return 0;
        }
    }
}