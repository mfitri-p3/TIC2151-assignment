/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package part2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author machok
 */
public class Control {
  private View view;
  private Model model;

  private int rows;
  private int[] cols; //how field in each line

  private String[][] newstate;
  private int newst;

  public Control(View view,Model model){
    this.view=view;
    this.model=model;
    cols= new int[10];
    for(int i=0; i<10; i++){
      cols[i]=2;
    }

    rows=1;

    newstate=new String[5][2];
    newst=0;
    for(int i=0; i<5; i++){
      newstate[i][0]=Character.toString((char)86+i);
      newstate[i][1]="/";
    }


  //  view.or.addActionListener(new orclick());
    view.addline.addActionListener(new newlineclick());
    view.orbtn[0].addActionListener(new orclick(0));
    view.transform.addActionListener(new trasnform());
  }

public void restart(){
  model=new Model();
  cols= new int[10];
  for(int i=0; i<10; i++){
    cols[i]=2;
  }

  rows=1;

}

  public void printdata()
  {
    for(int i=0; i<20; i++){
      for(int j=0; j<20; j++){
       System.out.print(model.getcnf()[i][j]+" ");
        }
        System.out.println();
      }
    }

    public void printnewstate()
    {
      for(int i=0; i<5; i++){
         System.out.println(newstate[i][0]+" -> "+newstate[i][1]);

        }
      }


    public String[][] first(){
      String[][] data=model.getcfg();
      boolean T=false;
    for (int j=1; j<cols[0]; j++){
    if(data[0][j].contains(data[0][0])){
    model.setcnf("S0",0,0);
    model.setcnf(model.getcfg()[0][0],0,1);
    model.copytocnf(1);

    //data[0][0]="x";
    T=true;
    break;}

      }

      if(T==false){model.copytocnf(0);}

  return data;
  }


  public String[][] second(){
    String[][] data=model.getcnf();

    for(int k=19; k>=0; k--){
      for(int y=0; y<20; y++){
        if(data[k][y].equals("e")){
          model.setcnf("/",k,y);
           String var=model.getcnf()[k][0];
           data=model.getcnf();
           for(int i=19; i>=0; i--){
             for(int j=1; j<20; j++){
               if(data[i][j].contains(var)){
                 if(data[i][j].length()==1){model.addtoline("e",i);} //in case contain 1 var
                  else{
                    if(containhowmany(data[i][j],var)==1){model.addtoline(data[i][j].replace(var,""),i);}
                    if(containhowmany(data[i][j],var)==2){
                      model.addtoline(var+data[i][j].replace(var,""),i);
                      model.addtoline(data[i][j].replace(var,"")+var,i);
                      model.addtoline(data[i][j].replace(var,""),i);
                      break;
                    }
                  }
               }

             }
        }
      }
    }}
    return data;
  }


public String[][] third(){
  String[][] data=model.getcnf();

  for(int i=0; i<20; i++){
    for(int j=1; j<20; j++){
      if(data[i][j].length()==1 && data[i][j].equals(data[i][j].toUpperCase()) && data[i][0].equals(data[i][j])){
        model.setcnf("/",i,j);
      }}}

  for(int i=0; i<20; i++){
    for(int j=1; j<20; j++){
      if(data[i][j].length()==1 && data[i][j].equals(data[i][j].toUpperCase())){
        String var=data[i][j];
        model.setcnf("/",i,j);
        for(int k=0; k<20; k++){
          if(data[k][0].equals(var) &&  k!=i ){
            model.fillthird(k,i);
          }
        }

      }

    }}

  return data;
}

public String[][] forth(){
  String[][] data=model.getcnf();
  for(int i=0; i<20; i++){
    for(int j=1; j<20; j++){
      if(data[i][j].length()==2  && !data[i][j].equals(data[i][j].toUpperCase())){
        String temp=Character.toString(data[i][j].charAt(0));
        Boolean T=false;
        for(int k=0; k<5; k++){
          if(temp.equals(newstate[k][1])){ model.setcnf(data[i][j].replace(temp,newstate[k][0]),i,j); T=true;}
          }
          if(T==false){
            newstate[newst][1]=temp;
            model.setcnf(data[i][j].replace(temp,newstate[newst][0]),i,j);
            newst++;

          }

      }
      if(data[i][j].length()==3 && data[i][j].equals(data[i][j].toUpperCase())){
            String temp=Character.toString(data[i][j].charAt(0));
             temp=temp+Character.toString(data[i][j].charAt(1));

             Boolean T=false;
             for(int k=0; k<5; k++){
               if(temp.equals(newstate[k][1])){ model.setcnf(data[i][j].replace(temp,newstate[k][0]),i,j); T=true;}
               }
               if(T==false){
                 newstate[newst][1]=temp;
                 model.setcnf(data[i][j].replace(temp,newstate[newst][0]),i,j);
                 newst++;

               }
      }
    }}
    return data;
}



public int containhowmany(String s,String var){
  int x;
  x=s.length()-s.replace(var,"").length()/var.length();
  return x;
}





   class orclick implements  ActionListener{
     public int x; //row number
     public orclick(int x){
       this.x=x;
     }
     public void actionPerformed(ActionEvent e) {

       view.createor(x,cols[x]++);
   }}

   class newlineclick implements  ActionListener{
     public void actionPerformed(ActionEvent e) {
     view.newline(rows);
    view.orbtn[rows].addActionListener(new orclick(rows));
     rows++;
   }}

   class trasnform implements  ActionListener{
     public void actionPerformed(ActionEvent e) {

       model.initiateModel(rows,cols);



      for(int i=0; i<rows; i++){
        for(int j=0; j<cols[i]; j++){
          String s=view.field[i][j].getText();
         if(!s.equals("")){  model.setcfg(s,i,j);}
          }
        }


         first();
         second();
         third();
          printdata();
          forth();
          System.out.println();
          printdata();
          printnewstate();

      //  restart();

   }}


}
