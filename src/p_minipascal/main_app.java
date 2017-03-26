/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p_minipascal;

import java.io.*;
import java.awt.Color;
import org.apache.sling.commons.json.JSONObject;

/**
 *
 * @author ambarsuarez
 */
public class main_app {
    public static void main(String argv[]){
	jTabbedPane1 = new javax.swing.JTabbedPane();
	jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
	treeArea = new javax.swing.JTextArea();
	treeArea.setEditable(false);
        treeArea.setColumns(20);
        treeArea.setRows(5);
        jScrollPane2.setViewportView(treeArea);
	javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                .addContainerGap())
        );
	jTabbedPane1.addTab("AST", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
        try{
            parser p = new parser(new Lexer(new FileReader("procedures.pas")));
            p.parse();
	    Program MPProgram = p.getProgram();
	    try {
                JSONObject json = new JSONObject(programJson);
                treeArea.setText(json.toString(4));
            } catch (Exception e) {
                System.out.println(e);
            }
        }catch(Exception e ){
            e.printStackTrace();
        }
    }
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JTabbedPane jTabbedPane1;
  private javax.swing.JTextArea treeArea; 
}
