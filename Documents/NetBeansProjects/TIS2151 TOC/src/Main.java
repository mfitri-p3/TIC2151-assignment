/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package part2;

/**
 *
 * @author machok
 */
public class Main {

    public static void main(String[] args) {
      View view = new  View();
      Model model = new Model();
      Control control = new Control(view,model);
      view.setVisible(true);
    }

}
