/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XuLy;

import java.util.Vector;

/**
 *
 * @author dinht
 */
public class FoodCate {

    public void setId(int id) {
        this.id = id;
    }

    public void setNameCate(String nameCate){
        this.nameCate = nameCate;
    }
    private int id;
    private String nameCate;
    
    Vector<Food> dsFood=new Vector<Food>();
    
    public FoodCate()
    {
        dsFood=new Vector<Food>();
    }

    public FoodCate(int id, String nameCate) {
        this.id = id;
        this.nameCate = nameCate;
        dsFood=new Vector<Food>();
    }

    public int getId() {
        return id;
    }

    public String getNameCate() {
        return nameCate;
    }

    @Override
    public String toString() {
        return nameCate;
    }
    public Vector<Food> getDsFood() {
        return dsFood;
    }

    public void setDsFood(Vector<Food> dsFood) {
        this.dsFood = dsFood;
    }
    
   
}
