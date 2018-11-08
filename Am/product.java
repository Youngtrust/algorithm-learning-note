backtracking 最优解法，可以比较突出

解法，先根据productID 对order分类使用group方法
然后利用getFastest每个仓库找到最快的到其他任何一个地方的运输方法
最后新建一个类Max里面，把一堆order和有该product的仓库，扔到使用backtrack对每个订单进行搜索，比较暴力，不过数据量不大，所以可以达到满足100%，cost也非常低
最后得到的List<OrderProcess> 可以进行订单的处理

这里只是大概的代码，具体的你就还需要小修改. 

public class MileStone{
    static List<Order> orders;
    static List<ProductInventory> inventory;. visit 1point3acres for more.
    static List<ShippingCost> costs;
    public static void milestone2() {
        Map<ProductInventory, Map<Region, ShippingCost>> map = new HashMap<>();
        for(ProductInventory productInventory : inventory){
             Map<Region, ShippingCost> fastShipping = getFastest(productInventory);
             map.put(productInventory, fastShipping);. From 1point 3acres bbs
        }
        Map<Integer, List<Order>> orders = group(orders);
        for(int productID : orders.keySet()){
            List<Order> orderList = groupOrder.get(productID);. 牛人云集,一亩三分地
            Max max = new Max();
            List<OrderProcess> res = new LinkedList<>();
            List<ProductInventory> inventoryList = ProductInventoryExplorer.getProductInventoryList(productID, inventory);
            max.dfs(orderList, inventoryList, map, 0, res);
            res = max.list;
            if(res != null){
            for(OrderProcess op: res){
                ship(op);//此处要改写
            }
            }
        }
       
       

    }
   

   
   
    public static Map<Integer, List<Order>> group(List<Order> orders){. 1point 3acres 论坛
        Map<Integer, List<Order>> orderGroup = new HashMap<>(); 来源一亩.三分地论坛. 
        for(Order order: orders){
            int productID = order.getOrderID();
            if(!orderGroup.containsKey(productID))
                orderGroup.put(productID, new LinkedList<Order>());.1point3acres网
            orderGroup.get(productID).add(order);
        }.
    }

   
    public static Map<Region, ShippingCost> getFastest(ProductInventory inventory){
        Map<Region, ShippingCost> map = new HashMap<>();
        Region from = inventory.region;
        for(ShippingCost cost : costs){. From 1point 3acres bbs
            if(cost.getFrom()== from){
                Region to = cost.getTo();
                if(!map.containsKey(to))
                    map.put(to, cost);
                else if(cost.days < map.get(to).days){
                    map.put(to, cost);
                }. 
            }.
        }
        return map;}


}
class Max{
    int max = 0;
    List<OrderProcess> list;
   
   
    public  void dfs(List<Order> orderGroup, List<ProductInventory> inventoryList,Map<ProductInventory, Map<Region, ShippingCost>> map, int i, List<OrderProcess> temp){
        if(i == orderGroup.size()){
            if(temp.size() > max)
                list = new LinkedList<>(temp);
                max = temp.size();
            return;
           
        }
        Order order = orderGroup.get(i);
        Region to = order.region;
        boolean found = false;.
        for(ProductInventory inv: inventoryList){
            if(inv.getQuantity() >= order.quantity && map.containsKey(inv)&&map.get(inv).containsKey(to)){
                found = true;
                inv.reduceQuantity(order.quantity);
                temp.add(new OrderProcess(order, inv,map.get(inv).get(to)));
                dfs(orderGroup, inventoryList,map,i+1, temp);.
                temp.remove(temp.size()-1);
                inv.reduceQuantity(0-order.quantity);
               
            }
        }
        if(!found){
            //dfs(orderGroup, inventoryList,map,i+1, temp); //此处为拼单
        }
    }
   
class OrderProcess{
    Order order;
    ProductInventory inventory;
    ShippingCost cost;
    public OrderProcess(Order order,ProductInventory inventory,ShippingCost cost){
        this.order = order;
        this.inventory = inventory;
        this.cost = cost;
    }
}
