class Boat {
  String owner;
  int color,size;
  Boat() {
   }
  Boat(String xOwner, int xColor, int xSize){
    owner=xOwner;color=xColor; size=xSize;
   }
  public String toString(){
    return("(" +owner+","+color + "," + size + ")");
   }
 }