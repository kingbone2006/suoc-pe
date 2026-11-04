class Pen {
  String owner;
  int price,color;
  Pen() {
   }
  Pen(String xOwner, int xPrice, int xColor){
    owner=xOwner;price=xPrice; color=xColor;
   }
  public String toString(){
    return("(" +owner+","+price + "," + color + ")");
   }
 }