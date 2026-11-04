class Plane
 {String owner;
  int price;
  Plane(String xOwner, int xPrice)
   {owner=xOwner;price=xPrice;
   }
  public String toString()
   {return("(" +owner+","+ price + ")");
   }
 }