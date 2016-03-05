package com.grant.q35619180;

import java.util.List;

/**
 * Created by grant on 2016/3/5.
 */
public class FirstModel {

    private String cat;

    private List<SecondModel> secondModels;


    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public List<SecondModel> getSecondModels() {
        return secondModels;
    }

    public void setSecondModels(List<SecondModel> secondModels) {
        this.secondModels = secondModels;
    }
}
