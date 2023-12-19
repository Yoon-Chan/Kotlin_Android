package com.boostcamp.shoppingapp.model;

import com.google.gson.annotations.SerializedName;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J8\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\t\u00a8\u0006\u001b"}, d2 = {"Lcom/boostcamp/shoppingapp/model/PageInfoResponse;", "", "currentPage", "", "nextPage", "totalPage", "totalItems", "(ILjava/lang/Integer;II)V", "getCurrentPage", "()I", "getNextPage", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTotalItems", "getTotalPage", "component1", "component2", "component3", "component4", "copy", "(ILjava/lang/Integer;II)Lcom/boostcamp/shoppingapp/model/PageInfoResponse;", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
public final class PageInfoResponse {
    @com.google.gson.annotations.SerializedName(value = "currentPage")
    private final int currentPage = 0;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "nextPage")
    private final java.lang.Integer nextPage = null;
    @com.google.gson.annotations.SerializedName(value = "totalPage")
    private final int totalPage = 0;
    @com.google.gson.annotations.SerializedName(value = "totalItems")
    private final int totalItems = 0;
    
    @org.jetbrains.annotations.NotNull
    public final com.boostcamp.shoppingapp.model.PageInfoResponse copy(int currentPage, @org.jetbrains.annotations.Nullable
    java.lang.Integer nextPage, int totalPage, int totalItems) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public PageInfoResponse(int currentPage, @org.jetbrains.annotations.Nullable
    java.lang.Integer nextPage, int totalPage, int totalItems) {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int getCurrentPage() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer getNextPage() {
        return null;
    }
    
    public final int component3() {
        return 0;
    }
    
    public final int getTotalPage() {
        return 0;
    }
    
    public final int component4() {
        return 0;
    }
    
    public final int getTotalItems() {
        return 0;
    }
}