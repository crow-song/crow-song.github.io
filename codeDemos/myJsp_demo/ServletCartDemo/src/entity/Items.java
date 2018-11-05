package entity;
//商品实体类
public class Items {
    private int id;
    private String name;
    private String city;
    private int price;
    private int number;
    private String picture;

    public Items(int id,String name,String city,int price,int number,String picture){
        this.id = id;
        this.name = name;
        this.city = city;
        this.price = price;
        this.number = number;
        this.picture = picture;
    }
    public Items(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String sicy) {
        this.city = sicy;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "商品编号:" + this.getId() + " 商品名称：" + this.getName();
    }

    @Override
    public int hashCode() {
        return this.getId() + this.getName().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        if(obj instanceof Items){
            Items i = (Items)obj;
            if(this.getId()==i.getId() && this.getName().equals(i.getName())){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
}
