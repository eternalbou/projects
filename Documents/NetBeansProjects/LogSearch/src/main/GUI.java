package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

public class GUI extends javax.swing.JFrame {

    public GUI() {
        initComponents();
    }

    private ArrayList<String> selected;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jButton3 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Log Searcher");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jButton1.setText("Choose folder");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTree1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Your root");
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTree1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTree1);

        jButton3.setText("Find phrase");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextArea1.setSelectionEnd(3);
        jTextArea1.setSelectionStart(1);
        jScrollPane3.setViewportView(jTextArea1);

        jLabel2.setText("Text for search:");

        jLabel3.setText("Extension:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "log", "txt", "csv", "html", "json", "xml" }));

        jLabel4.setBackground(new java.awt.Color(50, 78, 189));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Please, choose folder and extension to find files");

        jButton5.setText("Search files");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Reset");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(4, 4, 4)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // создаём модель дерева
        DefaultTreeModel model = (DefaultTreeModel) jTree1.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        int j = jTree1.getRowCount() - 1;
        // создаём FileChooser
        final JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(jComboBox1.getSelectedItem().toString() + " files", jComboBox1.getSelectedItem().toString());
        fc.setFileFilter(filter);
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.setDialogTitle("Choose a folder to find ." + jComboBox1.getSelectedItem().toString() + " files");
        jLabel4.setText("Searching files in folder, please wait");
        if (fc.showOpenDialog(jButton3) == JFileChooser.APPROVE_OPTION) {
            // запускаем новый поток run, в котором ищем все файлы с нужным расширением
            ExecutorService service = Executors.newSingleThreadExecutor();
            service.submit(new Runnable() {
                public void run() {
                    root.setUserObject("Your root");
                    jTextArea1.setText("");
                    jTextField1.setText("");
                    if (jTree1.getRowCount() > 0) {
                        for (int i = 0; i < j; i++) {
                            model.removeNodeFromParent((MutableTreeNode) model.getChild(root, 0));
                        }
                    }
                    long startTime = System.currentTimeMillis();
                    File f2 = new File(fc.getSelectedFile().getAbsolutePath());
                    String name2 = "." + jComboBox1.getSelectedItem().toString();
                    ArrayList<File> files = new ArrayList<>();
                    // метод listf для поиска указанного файла в поддиректориях с указанным расширением
                    listf(f2, files, name2);
                    // указываем корневой каталог, равный выбору пользователю
                    root.setUserObject(f2);
                    model.nodeChanged(root);
                    // заполняем найденными файлами ветви дерева
                    for (int i = 0; i < files.size(); i++) {
                        DefaultMutableTreeNode child = new DefaultMutableTreeNode(files.get(i).getAbsolutePath().replace(f2.toString(), ""));
                        root.add(child);
                        model.reload();
                        jLabel4.setText("Done! Now type text to search and press \"Search files\"");
                    }
                    System.out.println("Time used for getting files: " + (System.currentTimeMillis() - startTime) / 1000 + "sec");
                    JOptionPane.showMessageDialog(null, "Directory opened:" + fc.getSelectedFile().getAbsolutePath());
                }
            });
            service.shutdown();
        } else if (fc.showOpenDialog(jButton3) == JFileChooser.CANCEL_OPTION) {
            jLabel4.setText("Please, choose folder and extension to find files");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // создаём массив файлов на удаление
        ArrayList<TreeNode> delfiles = new ArrayList<>();
        jTextArea1.setText("");
        DefaultTreeModel model = (DefaultTreeModel) jTree1.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        jLabel4.setText("Searching text, please wait");
        long startTime = System.currentTimeMillis();
        // запускаем новый поток, ищущий текст в файлах
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.submit(new Runnable() {
            public void run() {
                for (int i = 0; i < jTree1.getRowCount(); i++) {
                    if (jTree1.getPathForRow(i).toString().endsWith(jComboBox1.getSelectedItem().toString() + "]") == false) {
                        continue;
                    }
                    String search = jTextField1.getText();
                    String truepath = jTree1.getPathForRow(i).toString().replace(", ", "/").replace("[", "").replace("]", "");
                    File f2 = new File(truepath);
                    try {
                        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(f2)));
                        String line = null;
                        // находим файлы (как массив строк), где есть указанный текст
                        ArrayList<String> lines = new ArrayList<>();
                        while ((line = in.readLine()) != null) {
                            lines.add(line + "\n");
                        }
                        // находим файлы для удаления
                        if (lines.toString().contains(search) == false) {
                            delfiles.add(root.getChildAt(i - 1));
                        }
                        in.close();
                    } catch (FileNotFoundException ex) {
                        System.out.println(root.getChildAt(i - 1) + " not found");
                    } catch (IOException ex) {
                        System.out.println("---IO Exception---");
                    }
                }
                // удаляем файлы из дерева
                for (int i = 0; i < delfiles.size(); i++) {
                    int d = model.getIndexOfChild(root, delfiles.get(i));
                    model.removeNodeFromParent((MutableTreeNode) model.getChild(root, d));
                }
                System.out.println("Time used for selecting files: " + (System.currentTimeMillis() - startTime) / 1000 + "sec");
                jLabel4.setText("Done! Select file in thread and press \"Find phrase\" to find your text");
            }
        });
        service.shutdown();

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // сброс информации
        DefaultTreeModel model = (DefaultTreeModel) jTree1.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        int j = jTree1.getRowCount() - 1;
        if (jTree1.getRowCount() > 0) {
            for (int i = 0; i < j; i++) {
                model.removeNodeFromParent((MutableTreeNode) model.getChild(root, 0));
            }
        }
        root.setUserObject("Your root");
        jTextArea1.setText("");
        jTextField1.setText("");
        jLabel4.setText("Please, choose folder and extension to find files");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTree1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTree1MousePressed
        // открываем файл по клику пользователя
        jTextArea1.setText("");
        String truepath = jTree1.getSelectionPath().toString().replace(", ", "/").replace("[", "").replace("]", "");
        File f2 = new File(truepath);
        jLabel4.setText("Opening file, please wait");
        long startTime = System.currentTimeMillis();
        // новый поток
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.submit(new Runnable() {
            public void run() {
                try {
                    BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(f2)));
                    String line = null;
                    String res = "";
                    // построчно записываем в массив текст файла
                    while ((line = in.readLine()) != null) {
                        String[] str_mas = line.split("\t");
                        for (int i = 0; i < str_mas.length; i++) {
                            res += str_mas[i] + "\n";
                        }
                    }
                    // выводим содержимое массива в TextArea
                    jTextArea1.append(res);
                    in.close();
                    jLabel4.setText("Done! Press \"Find phrase\" to find your text");
                    System.out.println("Time used for opening file: " + (System.currentTimeMillis() - startTime) / 1000 + "sec");
                } catch (FileNotFoundException ex) {
                    System.out.println("File not found");
                } catch (IOException ex) {
                    System.out.println("---IO Exception---");
                }
            }
        });

    }//GEN-LAST:event_jTree1MousePressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // создаем и открываем новый таб
        if (jTree1.getSelectionPath() == null) {
            JOptionPane.showMessageDialog(null, "Please, select file in thread on the left side");
        } else {
            String a = jTextArea1.getText();
            String b = jTextField1.getText();
            GUIPhraseFinder finder = new GUIPhraseFinder();
            finder.jTextPane1.setText(a);
            finder.jTextField1.setText(b);
            finder.setVisible(true);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            System.err.println("Error in main");

        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    public ArrayList<File> listf(File directory, ArrayList<File> files, String extension) {
        File[] flist = directory.listFiles();
        for (int i = 0; i < flist.length; i++) {
            if (flist[i].isFile() && flist[i].getName().endsWith(extension) == true) {
                files.add(flist[i]);
            } else if (flist[i].isDirectory()) {
                listf(flist[i], files, extension);
            }
        }
        return files;
    }

    public String getText() {
        return jTextArea1.getText();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables

}
