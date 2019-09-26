/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package part2;

/**
 *
 * @author machok
 */
public class Model {
  private String[][] cfg;
  private String[][] cnf;
  private int linescfg;
  public int[] cols;

  public void initiateModel (int x,int[] cols){
    linescfg=x;
    cfg=new String[x][10];

    for(int i=0; i<x; i++){
      for(int j=0; j<10; j++){
        cfg[i][j]="/";
        }
      }

      cnf=new String[20][20];
      for(int i=0; i<20; i++){
        for(int j=0; j<20; j++){
          cnf[i][j]="/";
          }
        }
        this.cols=cols;

  }

  public String[][] getcfg(){
    return cfg;
  }

  public String[][] getcnf(){
    return cnf;
  }

  public void setcfg(String s,int i,int j){
    cfg[i][j]=s;
  }

  public void setcnf(String s,int i,int j){
    cnf[i][j]=s;
  }

  public void copytocnf(int x){
    for(int i=0; i<linescfg; i++){
      for(int j=0; j<10; j++){
        cnf[i+x][j]=cfg[i][j];
      }
  }
}

public void addtoline(String s,int x){
  cnf[x][cols[x]]=s;
  cols[x]++;
}


public void fillthird(int x,int y){
  for(int j=1; j<20; j++){
    if(!cnf[x][j].equals("/")){addtoline(cnf[x][j],y);}
  }

}



}
