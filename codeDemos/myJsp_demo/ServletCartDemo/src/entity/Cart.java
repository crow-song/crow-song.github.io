package entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//购物车类
public class Cart {
    //购买商品的集合
    private HashMap<Items,Integer> goods;

    //购物车总金额
    private double totalPrice;

    public Cart(){
        goods = new HashMap<Items,Integer>();
        totalPrice = 0.0;
    }

    public HashMap<Items, Integer> getGoods() {
        return goods;
    }

    public void setGoods(HashMap<Items, Integer> goods) {
        this.goods = goods;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }


    //添加进购物车的方法
    public boolean addGoodsInCart(Items item,int number){
        if(goods.containsKey(item)){
            goods.put(item,goods.get(item) + number);
        }
        else{
            goods.put(item,number);
        }

        calTotalPrice();//当添加或删除购物车时，重新计算总金额
        return true;
    }

    public boolean removeGoodsFormCart(Items item){
        goods.remove(item);
        calTotalPrice();//当添加或删除购物车时，重新计算总金额
        return true;
    }

    public double calTotalPrice(){
        double sum = 0.0;
        Set<Items> keys = goods.keySet();//获得键的集合
        Iterator<Items> it = keys.iterator();//获得迭代器对象
        while(it.hasNext()){
            Items i = it.next();
            sum += i.getPrice() * goods.get(i);

        }
        this.setTotalPrice(sum);//设置购物车的总金额
        return this.getTotalPrice();
    }

    public static void main(String[] args) {
        Items i1 = new Items(1,"沃特运动鞋","温州",200,500,"001.jpg");
        Items i2 = new Items(2,"李宁运动鞋","广州",300,500,"002.jpg");
        Items i3 = new Items(1,"沃特运动鞋","温州",200,500,"001.jpg");

        Cart c = new Cart();
        c.addGoodsInCart(i1,1);
        c.addGoodsInCart(i2,2);
        //再次购买沃特 3 双
        c.addGoodsInCart(i3,3);

        //遍历购物商品的集合
        Set<Map.Entry<Items,Integer>> items =  c.getGoods().entrySet();
        for(Map.Entry<Items,Integer> obj: items){
            System.out.println(obj);
        }

        System.out.println("总价格：" + c.calTotalPrice());

    }
}
