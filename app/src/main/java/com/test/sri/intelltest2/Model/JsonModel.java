package com.test.sri.intelltest2.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Srikanth
 */

public class JsonModel {

        @SerializedName("contacts")
        @Expose
        private ArrayList<JsonData> list = new ArrayList<>();
        public ArrayList<JsonData> getContacts() {
            return list;
        }
        public void setContacts(ArrayList<JsonData> list) {
            this.list = list;
        }
    }

