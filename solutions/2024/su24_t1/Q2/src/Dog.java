class Dog {
  String place;
  int weight,color;
  Dog() {
   }
  Dog(String xPlace, int xWeight, int xColor){
    place=xPlace;weight=xWeight; color=xColor;
   }
  public String toString(){
    return("(" + place +","+ weight + "," + color + ")");
   }
 }