class Tiger {
  String forest;
  int rate,sound;
  Tiger() {
   }
  Tiger(String xForest, int xRate, int xSound){
    forest=xForest;rate=xRate; sound=xSound;
   }
  public String toString(){
    return("(" +forest+","+rate + "," + sound + ")");
   }
 }