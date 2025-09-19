class Spreadsheet {
    HashMap<String,Integer> map;
    public Spreadsheet(int rows) {
        map=new HashMap<>();
    }
    
    public void setCell(String cell, int value) {
        map.put(cell,value);
    }
    
    public void resetCell(String cell) {
        map.put(cell,0);
    }
    
    public int getValue(String formula) {
        int sum=0;
        for(String x:formula.substring(1).split("\\+")){
            sum+=maps(x);
        }
        return sum;
    }
    private int maps(String sub){
        return (Character.isLetter(sub.charAt(0))?map.getOrDefault(sub,0):Integer.parseInt(sub));
    }
}
