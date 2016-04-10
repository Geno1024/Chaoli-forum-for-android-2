package com.geno.chaoli.forum;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by daquexian on 16-4-8.
 * 保存用户自己的账户信息的类
 */
public class Me {
    private int userId;

    @JSONField(name="avatarFormat")
    private String avatarSuffix;
    private String status;
    private Preferences preferences;
    private static Me me;

    private Me(){}

    private static Me getInstance(){
        if(me == null) me = new Me();
        return me;
    }

    public static int getMyUserId(){
        return Me.getInstance().userId;
    }

    public static String getMyAvatarSuffix(){
        return Me.getInstance().avatarSuffix;
    }

    public static String getMyStatus(){
        return Me.getInstance().status;
    }

    public static String getMySignature(){
        return Me.getInstance().preferences.signature;
    }

    public static Boolean getMyPrivateAdd(){
        return Me.getInstance().preferences.privateAdd;
    }

    public static Boolean getMyStarOnReply(){
        return Me.getInstance().preferences.starOnReply;
    }

    public static Boolean getMyStarPrivate(){
        return Me.getInstance().preferences.starPrivate;
    }

    public static Boolean getMyHideOnline(){
        return Me.getInstance().preferences.hideOnline;
    }

    public Preferences getPreferences() {
        return preferences;
    }

    public void setPreferences(Preferences preferences) {
        this.preferences = preferences;
    }


    public static int getUserId() {
        return Me.getInstance().userId;
    }

    public static void setUserId(int userId) {
        Me.getInstance().userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAvatarSuffix() {
        return avatarSuffix;
    }

    public void setAvatarSuffix(String avatarSuffix) {
        this.avatarSuffix = avatarSuffix;
    }

    public static class Preferences{
        private String signature;
        @JSONField(name="email.privateAdd")
        private Boolean privateAdd;
        private Boolean starOnReply;
        private Boolean starPrivate;
        private Boolean hideOnline;

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public Boolean getPrivateAdd() {
            return privateAdd;
        }

        public void setPrivateAdd(Boolean privateAdd) {
            this.privateAdd = privateAdd;
        }

        public Boolean getStarOnReply() {
            return starOnReply;
        }

        public void setStarOnReply(Boolean starOnReply) {
            this.starOnReply = starOnReply;
        }

        public Boolean getStarPrivate() {
            return starPrivate;
        }

        public void setStarPrivate(Boolean starPrivate) {
            this.starPrivate = starPrivate;
        }

        public Boolean getHideOnline() {
            return hideOnline;
        }

        public void setHideOnline(Boolean hideOnline) {
            this.hideOnline = hideOnline;
        }
    }

    public static void setInstanceFromJSONStr(String jsonStr){
        me = JSON.parseObject(jsonStr, Me.class);
    }
}