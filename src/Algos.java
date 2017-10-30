import java.util.ArrayList;


public class Algos{
  public SudokuButtonGUI grid;

  public Algos(SudokuButtonGUI grid) {
      this.grid = grid;
  }



  public MiniSudokuButtonGUI getMiniGrid(int row, int col){
if(row <= 3) {
  if(col <= 3) {
    return grid.miniGrid[0][0];
    }
  else if(col <= 6) {
    return grid.miniGrid[0][1];
  }
  else if(col <= 9) {
    return grid.miniGrid[0][2];
  }
}
else if(row <= 6 && row >= 4) {
  if(col <= 3) {
      return grid.miniGrid[1][0];
    }
  else if(col <= 6) {
    return grid.miniGrid[1][1];
  }
  else if(col <= 9) {
    return grid.miniGrid[1][2];
  }
}
else if(row >= 7 && row <= 9) {
  if(col <= 3) {
    return grid.miniGrid[2][0];
    }
  else if(col <= 6) {
    return grid.miniGrid[2][1];

  }
  else if(col <= 9) {
    return grid.miniGrid[2][2];

  }
}
return null;
}

  public ArrayList<String> getCandidateList(int x, int y){
    ArrayList<String> candidateList = new ArrayList<>();
      for(int i=1;i<10;i++){
        candidateList.add(Integer.toString(i));//1-9  correct
      }
    for(int i =0; i<9; i++){
      candidateList.remove(grid.gridRep[x][i]);
    }
    for(int i =0; i<9; i++){
      candidateList.remove(grid.gridRep[i][y]);
    }

    ArrayList<String> tmp = getMiniGrid(x+1,y+1).miniGridRep;

      for(String val: tmp){
        candidateList.remove(val);
      }
      return candidateList;
  }



  public void Single() {

    ArrayList<String> candidateListTmp = new ArrayList<>();
        for (int i =0; i <9; i++){
          for(int j = 0; j< 9; j++){

            if (grid.gridRep[i][j].equals("0")){
              candidateListTmp = getCandidateList(i,j);
              if(candidateListTmp.size() == 1) {
                  grid.changeButton(i+1, j+1, Integer.parseInt(candidateListTmp.get(0))); //This should work this updates gui, and miniGrid.

                grid.updateGridRep(i,j,candidateListTmp.get(0));
                return;
              }
            }
          }
        }
      }


      public boolean remove(MiniSudokuButtonGUI miniGrid, String val1, String val2){
      for(int i=0; i<3; i++){
        for(int j=0; j<3; j++){
          if(grid.gridRep[miniGrid.jbutton[i][j].getxIndex()][miniGrid.jbutton[i][j].getyIndex()].equals("0")){
          ArrayList <String> currentCandidateList = getCandidateList(miniGrid.jbutton[i][j].getxIndex(), miniGrid.jbutton[i][j].getyIndex());
          currentCandidateList.remove(val1);
          currentCandidateList.remove(val2);
        //  System.out.println(val1 + " REMOVE " + val2);

          if(currentCandidateList.size() == 1){
            grid.changeButton(miniGrid.jbutton[i][j].getxIndex()+1, miniGrid.jbutton[i][j].getyIndex()+1, Integer.parseInt(currentCandidateList.get(0)));
            grid.updateGridRep(miniGrid.jbutton[i][j].getxIndex(), miniGrid.jbutton[i][j].getyIndex(), (currentCandidateList.get(0)));
            return true;
          }
        }
        }
      }

      return false; //We didnt find a single in grid
    }

    public boolean checkGrid(MiniSudokuButtonGUI miniGrid){
      ArrayList <ArrayList <String>> listOfCandidateList = new ArrayList<>();
      ArrayList <Integer> x = new ArrayList<>();
      ArrayList <Integer> y = new ArrayList<>();


      for(int i =0; i<3; i++){
        for (int j =0; j<3; j++){
          if(miniGrid.jbutton[i][j].cell.getText().equals("")){
            ArrayList <String> currentCandidateList = getCandidateList(miniGrid.jbutton[i][j].getxIndex(), miniGrid.jbutton[i][j].getyIndex());
            if( currentCandidateList.size() == 2){
                  if(listOfCandidateList.size() !=0){
                      boolean completed = false;
                      for(ArrayList<String> candidateList: listOfCandidateList){
                          if(currentCandidateList.equals(candidateList)){
                            //Remove values from CandidateList of other cells;
                          completed = remove(miniGrid, currentCandidateList.get(0),currentCandidateList.get(1));
                          if(completed)
                              return true; //We changed something;
                          }
                      }
                      listOfCandidateList.add(currentCandidateList);
                  }

                  else
                      listOfCandidateList.add(currentCandidateList);
              }
            }
          }
        }
        return false; //We'll assume that if we found a single we should have returned and not encounter this line of code...
      }

    public boolean removeRow(String val1, String val2, int row){
    //  System.out.println("REMOVEING ROW");
        for(int i=0; i<9; i++){
          if(grid.gridRep[row][i].equals("0")){
            ArrayList <String> currentCandidateList = getCandidateList(row, i);
            currentCandidateList.remove(val1);
            currentCandidateList.remove(val2);

            if(currentCandidateList.size() == 1){
                grid.changeButton(row+1, i+1, Integer.parseInt(currentCandidateList.get(0)));
                grid.updateGridRep(row,i, currentCandidateList.get(0));
                return true;
            }
        }
      }
        return false;

    }

        public boolean removeCol(String val1, String val2, int col){
        for(int i=0; i<9; i++){
          if(grid.gridRep[i][col].equals("0")){
            ArrayList <String> currentCandidateList = getCandidateList(i, col);
            currentCandidateList.remove(val1);
            currentCandidateList.remove(val2);

            if(currentCandidateList.size() == 1){
                grid.changeButton(i+1, col+1, Integer.parseInt(currentCandidateList.get(0)));
                grid.updateGridRep(i,col, currentCandidateList.get(0));
                return true;
            }
        }
      }
        return false;

    }

    public boolean checkRow(int row){
      ArrayList <ArrayList<String>> listOfCandidateLists = new ArrayList<>();
      boolean completed = false;


      for(int col =0; col<9; col++){
      //  System.out.print("CHECKING ROW" + row + "and Col " + col);
        ArrayList <String> currentCandidateList = new ArrayList<>();
        if(grid.gridRep[row][col].equals("0")){
        //  System.out.print("CHECKING ROW" + row + "and Col " + col);
          currentCandidateList = getCandidateList(row, col);
        if(currentCandidateList.size() == 2){
            if(listOfCandidateLists.size() != 0){
                for(ArrayList<String> candidateList: listOfCandidateLists){
                //  System.out.println(listOfCandidateLists.size() + "SIZE");
                    if(currentCandidateList.equals(candidateList)){
                        completed = removeRow(candidateList.get(0), candidateList.get(1), row);
                        if(completed)
                            return true;
                    }
                    //else
                      //  listOfCandidateLists.add(currentCandidateList);
                }
                listOfCandidateLists.add(currentCandidateList);
            }
            else{
                listOfCandidateLists.add(currentCandidateList);
            }
        }
      }

      }
      return false;
    }

     public boolean checkCol(int col){
      ArrayList <ArrayList<String>> listOfCandidateLists = new ArrayList<>();
      boolean completed = false;
    //  ArrayList <String> candidateList = new ArrayList<>();


      for(int row =0; row<9; row++){
        ArrayList <String> candidateList = new ArrayList<>();
        ArrayList <String> currentCandidateList = getCandidateList(row, col);
        if(grid.gridRep[row][col].equals("0")){
        if(currentCandidateList.size() == 2){
            if(listOfCandidateLists.size() != 0){
                //for(ArrayList<String> candidateList: listOfCandidateLists){
                for(int k=0; k<listOfCandidateLists.size(); k++){
                  candidateList = listOfCandidateLists.get(k);
                //  System.out.println(candidateList.get(0) + " from for " +  candidateList.get(1));
                //  System.out.println(currentCandidateList.get(0)+ " curr " + currentCandidateList.get(1));
                //  System.out.println(row +" col" + col);
                    if(currentCandidateList.equals(candidateList)){
                        completed = removeCol(currentCandidateList.get(0), currentCandidateList.get(1), col);
                        if(completed)
                            return true;
                    }
                  }
                    //else{
                        listOfCandidateLists.add(currentCandidateList);
                    //    System.out.println("I SHOULD BE HERE ONCE!");
                  //    }
              //  System.out.println("FINISH TEST");

            //    System.out.println("OUT OF FOR");
                listOfCandidateLists.add(currentCandidateList);
            }
            else{
                listOfCandidateLists.add(currentCandidateList);
            }
        }
      }

      }
      return false;
    }
    //alters the candidate list and display
    public boolean Naked() {
        ArrayList <Integer> x = new ArrayList<>();
        ArrayList <Integer> y = new ArrayList<>();
        ArrayList <ArrayList<String>> listOfCandidateList = new ArrayList<>();

        boolean completed = false;


        for(int i=0; i<3; i++){
          for(int j=0; j<3; j++){
              completed = checkGrid(getMiniGrid(i+1, j+1));
              if (completed)
                return true;
          }
        }

        if(!completed){
          for(int i=0; i<9; i++){
            completed = checkRow(i);
            if(completed)
              return true;
          }
        }

        if(!completed){
          for(int i=0; i<9; i++){
            completed = checkCol(i);
            if(completed)
              return true;
          }
        }
        //System.out.println("FAILED");
    return false;
}
}
