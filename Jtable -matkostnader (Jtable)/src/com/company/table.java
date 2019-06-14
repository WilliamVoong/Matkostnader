package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
public class table extends JFrame{
    JTable table;
    JButton button;
    JButton addrow;

    public table(){
        JTextField item1;
        button=new JButton("calculate");

        Handler handler=new Handler();
        button.setPreferredSize(new Dimension(100,30));
        button.addActionListener(handler);
        add(button);
        setLayout(new FlowLayout());
        String[] columnNames={"Williams kostnader", "Huas kostnader"};
        Object[][] data = new Object[15][2];
        table= new JTable(data,columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500,500));
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
        
        }
  public class Handler implements ActionListener {
  String string="";
      String string1;
  Object[][] data;
      public void actionPerformed(ActionEvent event){
          if(event.getSource()==button){



            // int skillnad=Integer.parseInt(string);
             int suma=sumrowTABLE(table,0);
             int sumb=sumrowTABLE(table,1);
             int skillnad= Math.abs(suma-sumb);
             if(suma<sumb){
                 string= String.format("William ska betala hua " + skillnad/2.0 + " kr ", event.getActionCommand());
             }
             else{
                 string= String.format("hua ska betala william " + skillnad/2.0 + "kr", event.getActionCommand());
             }
             JOptionPane.showMessageDialog( null,string,"Status", JOptionPane.PLAIN_MESSAGE);
      }

    }
    int sumrowTABLE(JTable tabel, int col){
        int sum=0;
        for(int index=0;index<15;index++ ){
            if((table.getValueAt(index,col)!= null && !(table.getValueAt(index,col).toString().isEmpty())))
        sum= Integer.parseInt(table.getValueAt(index,col).toString())+sum;
        }


   return sum; }
    }}


