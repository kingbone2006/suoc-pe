class Cape {
  String tailor;
  int color,type;
  Cape() {
   }
  Cape(String xTailor, int xColor, int xType){
    tailor=xTailor;color=xColor; type=xType;
   }
  public String toString(){
    return("(" +tailor+","+color + "," + type + ")");
   }
 }