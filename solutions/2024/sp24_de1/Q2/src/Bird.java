class Bird {
  String place;
  int weight,color;
  Bird() {
   }
  Bird(String xPlace, int xWeight, int xColor){
    place=xPlace;weight=xWeight; color=xColor;
   }
  public String toString(){
    return("(" + place +","+ weight + "," + color + ")");
   }
 }