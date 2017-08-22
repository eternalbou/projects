package main;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

/**
 *
 * @author Kirill
 */
public class GUIPhraseFinder extends javax.swing.JFrame {

    private String name;
    private int start;
    private ArrayList<Integer> locations = new ArrayList<>();

    ;

    /**
     * Creates new form GUIPhraseFinder
     */
    public GUIPhraseFinder() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("sdf");

        jScrollPane1.setMaximumSize(new java.awt.Dimension(8, 22));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(8, 22));

        jTextPane1.setFocusTraversalPolicyProvider(true);
        jTextPane1.setMaximumSize(new java.awt.Dimension(6, 20));
        jTextPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextPane1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTextPane1);
        setTitle(getName());

        jButton1.setText("Select All");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Next");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Previous");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextField1.setMaximumSize(new java.awt.Dimension(6, 20));
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextField1MousePressed(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton4.setText("Reset");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(7, 7, 7)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if ("".equals(jTextField1.getText())) {
            JOptionPane.showMessageDialog(null, "Please, type text to find");
            return;
        }
        int s2 = jTextField1.getText().length();
        String search;
        long startTime = System.currentTimeMillis();
        try {
            search = jTextField1.getDocument().getText(0, s2);
            int s1 = jTextPane1.getText().indexOf(search);
            Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.PINK);
            jTextPane1.getHighlighter().removeAllHighlights();
            // выделяем цветом все фразы
            while (s1 != -1) {
                jTextPane1.getHighlighter().addHighlight(s1, s1 + s2, painter);
                s1 = jTextPane1.getText().indexOf(search, s1 + 1);
            }
        } catch (BadLocationException ex) {
            System.err.println("Bad location");
        }
        System.out.println("Time used for searching text: " + (System.currentTimeMillis() - startTime) / 1000 + "sec");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if ("".equals(jTextField1.getText())) {
            JOptionPane.showMessageDialog(null, "Please, type text to find");
            return;
        }
        int s2 = jTextField1.getText().length();
        String search;
        long startTime = System.currentTimeMillis();
        try {
            search = jTextField1.getDocument().getText(0, s2);
            // проверяем состояние переменной start - отсечка, с какого момента искать текст; если равна нулю, создаём массив местонаходений искомого выражения
            if (start == 0) {
                locations.clear();
                start = jTextPane1.getText().indexOf(search);
                if (start == -1) {
                    JOptionPane.showMessageDialog(null, "Nothing founded");
                    return;
                }
                while (start != -1) {
                    locations.add(start);
                    start = jTextPane1.getText().indexOf(search, start + 1);
                }
                setStart(0);
                getStart();
                setLocations(locations);
            } else if (start == -1) {
                JOptionPane.showMessageDialog(null, "Reached end of a document");
                setStart(0);
                return;
            } else {
                getStart();
            }
            Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.PINK);
            if (jTextPane1.getHighlighter().getHighlights() != null) {
                jTextPane1.getHighlighter().removeAllHighlights();
            }
            // выделяем первое встретившееся слово
            while (start != -1) {
                start = jTextPane1.getText().indexOf(search, start + 1);
                jTextPane1.getHighlighter().addHighlight(start, start + s2, painter);
                jTextPane1.setCaretPosition(start);
                setStart(start);
                if (start == -1) {
                    JOptionPane.showMessageDialog(null, "Reached end of a document");
                    setStart(0);
                    return;
                }
                break;
            }
        } catch (BadLocationException ex) {
            System.err.println("Bad location");
        }
        System.out.println("Time used for searching text: " + (System.currentTimeMillis() - startTime) / 1000 + "sec");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // аналогично, как и для Next - только в данном случае применяется массив местонахождений, выявленный либо при нажатии next, либо при перемещении курсора
        if ("".equals(jTextField1.getText())) {
            JOptionPane.showMessageDialog(null, "Please, type text to find");
            return;
        }
        int s2 = jTextField1.getText().length();
        String search;
        getLocations();
        getStart();
        long startTime = System.currentTimeMillis();
        if (getLocations().indexOf(getStart()) == 0) {
            JOptionPane.showMessageDialog(null, "Reached end of a document");
            jTextPane1.getHighlighter().removeAllHighlights();
            setStart(0);
            return;
        }
        try {
            search = jTextField1.getDocument().getText(0, s2);
            if (start <= -1) {
                setStart(0);
                return;
            } else {
                getStart();
            }
            Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.PINK);
            if (jTextPane1.getHighlighter().getHighlights() != null) {
                jTextPane1.getHighlighter().removeAllHighlights();
            }
            while (start != -1) {
                int i = locations.indexOf((Integer) start);
                if (i == -1) {
                    start = jTextPane1.getText().indexOf(search, start + 1);
                    i = locations.indexOf((Integer) start);
                }
                start = jTextPane1.getText().indexOf(search, start + locations.get(i - 1) - locations.get(i));
                jTextPane1.getHighlighter().addHighlight(start, start + s2, painter);
                setStart(start);
                jTextPane1.setCaretPosition(start);
                break;
            }
        } catch (BadLocationException ex) {
            System.err.println("Bad location");
        }
        System.out.println("Time used for searching text: " + (System.currentTimeMillis() - startTime) / 1000 + "sec");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // при установке курсора в поле текста для поиска обновляем переменную start
        jTextField1.setText("");
        jTextPane1.getHighlighter().removeAllHighlights();
        setStart(0);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextPane1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextPane1MousePressed
        // сброс слова для поиска и выделений текста
        if ("".equals(jTextField1.getText())) {
            return;
        }
        setStart(0);
        int s2 = jTextField1.getText().length();
        String search;
        locations.clear();
        try {
            search = jTextField1.getDocument().getText(0, s2);
            while (start != -1) {
                start = jTextPane1.getText().indexOf(search, start + 1);
                locations.add(start);
            }
        } catch (BadLocationException ex) {
            System.err.println("Bad location");
        }
        setLocations(locations);
        setStart(jTextPane1.getCaretPosition());
        //System.out.println(jTextPane1.getCaretPosition());
    }//GEN-LAST:event_jTextPane1MousePressed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MousePressed
        setStart(0);
        jTextPane1.getHighlighter().removeAllHighlights();
    }//GEN-LAST:event_jTextField1MousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            System.err.println("Error in main method");
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIPhraseFinder().setVisible(true);
            }
        });
    }

    public void setTitle(String name) {
        this.name = name;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public String getTitle() {
        return name;
    }

    public int getStart() {
        return start;
    }

    private ArrayList<Integer> getLocations() {
        return locations;
    }

    private void setLocations(ArrayList<Integer> locations) {
        this.locations = locations;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField jTextField1;
    public javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables

}
