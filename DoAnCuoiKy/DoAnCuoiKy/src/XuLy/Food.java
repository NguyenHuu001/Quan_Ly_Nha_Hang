/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XuLy;

/**
 *
 * @author dinht
 */
public class Food {
    public Food()
    {
        
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getIdCate() {
        return idCate;
    }

    public float getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdCate(int idCate) {
        this.idCate = idCate;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Food(int id,String name,int idCate,float price) {
        this.id=id;
        this.name=name;
        this.idCate=idCate;
        this.price=price;
    }
    private int id;
    private String name;
    private int idCate;
    private float price;
    
    FoodCate foodCate;
    
    public FoodCate getCate()
    {
        return foodCate;
    }
   public void setCate(FoodCate foodCate) {
        this.foodCate = foodCate;
    }
    
    @Override
    public String toString()
    {
        return this.name;
    }
}
