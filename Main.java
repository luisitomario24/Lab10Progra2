package Lab10Progra2;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class Main extends javax.swing.JFrame implements Serializable {

    private final DefaultMutableTreeNode root;
    private final DefaultTreeModel arbol;
    private ArrayList<Planeta> listaplanetas = new ArrayList();
    private ArrayList<Cientifico> listacientificos = new ArrayList();

    public Main() {
        initComponents();
        inicializar();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        MostrarCientificos();
        actualizarCombobox();
        arbol = (DefaultTreeModel) jTree1.getModel();
        root = new DefaultMutableTreeNode("Planetas");
        llenarTree();
    }

    public void inicializar() {
        listaplanetas.add(new Terrestre(5000, 13000, "Planeta Vegeta", 400, 300));
        listaplanetas.add(new Terrestre(5000, 13000, "Mercurio", 400, 300));
        listaplanetas.add(new Terrestre(100000, 15000, "Venus", 640, 260));
        listaplanetas.add(new Terrestre(140000, 17000, "Tierra", 760, 570));
        listaplanetas.add(new Terrestre(90000, 12000, "Marte", 360, 360));
        listaplanetas.add(new Gaseoso(400000, 40000, "Jupiter", 340, 310));
        listaplanetas.add(new Gaseoso(300000, 30000, "Saturno", 560, 450));
        listaplanetas.add(new Gaseoso(200000, 20000, "Urano", 670, 690));
        listaplanetas.add(new Gaseoso(200000, 20000, "Neptuno", 840, 9000));
    }

    private void RegistrarCientifico() {
        try {
            ObjectOutputStream entrada = new ObjectOutputStream(new FileOutputStream("./Cientificos.LMMC"));
            for (Cientifico cienti : listacientificos) {
                entrada.writeObject(cienti);
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    private void MostrarCientificos() {
        try {
            ObjectInputStream salida = new ObjectInputStream(new FileInputStream("./Cientificos.LMMC"));
            Cientifico cientifique;
            try {
                while ((cientifique = (Cientifico) salida.readObject()) != null) {
                    listacientificos.add(cientifique);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public void actualizarCombobox() {
        DefaultComboBoxModel modelo = (DefaultComboBoxModel) comboCientifico.getModel();
        modelo.removeAllElements();
        for (Cientifico cientifique : listacientificos) {
            modelo.addElement(cientifique);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popmenu = new javax.swing.JPopupMenu();
        planetauno = new javax.swing.JMenuItem();
        Planetados = new javax.swing.JMenuItem();
        jProgressBar1 = new javax.swing.JProgressBar();
        jProgressBar2 = new javax.swing.JProgressBar();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        planeta2 = new javax.swing.JTextField();
        jtplaneta1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        comboCientifico = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        agregarCientifico = new javax.swing.JButton();
        Colisionar = new javax.swing.JButton();
        nombreCientifico = new javax.swing.JTextField();

        planetauno.setText("planeta1");
        planetauno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                planetaunoActionPerformed(evt);
            }
        });
        popmenu.add(planetauno);

        Planetados.setText("Planeta2\n");
        Planetados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlanetadosActionPerformed(evt);
            }
        });
        popmenu.add(Planetados);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jCheckBox1.setText("Puesto");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTree1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTree1);

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel1.setText("Cientifico");

        comboCientifico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboCientificoMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel2.setText("Cientifico");

        agregarCientifico.setText("Añadir Cientifico");
        agregarCientifico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarCientificoActionPerformed(evt);
            }
        });

        Colisionar.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        Colisionar.setText("Colisionar");
        Colisionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColisionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(11, 11, 11)
                                    .addComponent(jCheckBox1)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jtplaneta1, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                                .addComponent(planeta2)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboCientifico, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(agregarCientifico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(nombreCientifico))
                            .addGap(28, 28, 28)
                            .addComponent(Colisionar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtplaneta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(Colisionar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(planeta2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboCientifico, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombreCientifico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 14, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox1)
                    .addComponent(agregarCientifico, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void llenarTree() {
        for (Planeta planeta : listaplanetas) {
            DefaultMutableTreeNode hijo = new DefaultMutableTreeNode(planeta.nombre);
            root.add(hijo);
        }
        arbol.setRoot(root);
    }

    public void vaciarArbol() {
    }

    private void jTree1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTree1MouseClicked
        if (evt.isMetaDown()) {
            popmenu.show(evt.getComponent(), evt.getX(), evt.getY());

        }
    }//GEN-LAST:event_jTree1MouseClicked
    public void LLenarCombo() {
        comboCientifico.removeAllItems();
        for (Cientifico cienti : listacientificos) {
            comboCientifico.addItem(cienti.nombreCientifico);
        }
    }
    private void comboCientificoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboCientificoMouseClicked

    }//GEN-LAST:event_comboCientificoMouseClicked

    private void agregarCientificoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarCientificoActionPerformed
        listacientificos.add(new Cientifico(nombreCientifico.getText()));
        LLenarCombo();
        nombreCientifico.setText("");
        RegistrarCientifico();


    }//GEN-LAST:event_agregarCientificoActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        if (jCheckBox1.isSelected()) {
            vaciarArbol();
            llenarTree();
        } else {
            vaciarArbol();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void planetaunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_planetaunoActionPerformed
        try {
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) jTree1.getLastSelectedPathComponent();
            seleccionado1 = (Planeta) selectedNode.getUserObject();
            jtplaneta1.setText(seleccionado1.toString());
        } catch (Exception e) {
        }

    }//GEN-LAST:event_planetaunoActionPerformed

    private void PlanetadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlanetadosActionPerformed
        try {
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) jTree1.getLastSelectedPathComponent();
            seleccionado2 = (Planeta) selectedNode.getUserObject();
            planeta2.setText(planetauno.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_PlanetadosActionPerformed

    private void ColisionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColisionarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ColisionarActionPerformed
    public double calcularDistancia() {
        return 0;
    }

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Colisionar;
    private javax.swing.JMenuItem Planetados;
    private javax.swing.JButton agregarCientifico;
    private javax.swing.JComboBox<String> comboCientifico;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree jTree1;
    private javax.swing.JTextField jtplaneta1;
    private javax.swing.JTextField nombreCientifico;
    private javax.swing.JTextField planeta2;
    private javax.swing.JMenuItem planetauno;
    private javax.swing.JPopupMenu popmenu;
    // End of variables declaration//GEN-END:variables
//    private Planeta mercurio =new Planeta();
//    private Planeta venus =new Planeta();
//    private Planeta Tierra =new Planeta();
//    private Planeta Marte =new Planeta();
//    private Planeta Jupiter =new Planeta();
//    private Planeta Saturno=new Planeta();
//    private Planeta Urano=new Planeta();
//    private Planeta Neptuno=new Planeta();
    private Planeta seleccionado2;
    private Planeta seleccionado1;
    

    class HiloProgressBar extends Thread{
    Random r = new Random();
    private JProgressBar barra;
    private Planeta planeta1;
    private Planeta planeta2;
    private Cientifico cientifico;
    private boolean existe;
    public HiloProgressBar(JProgressBar barra, Planeta planeta1, Planeta planeta2, Cientifico cientifico) {
        this.barra = barra;
        this.planeta1 = planeta1;
        this.planeta2 = planeta2;
        this.cientifico = cientifico;
        existe = true;
    }
    
    @Override
    public void run(){
        while(existe){
            barra.setValue(barra.getValue()+1);
            if(barra.getValue()==barra.getMaximum()){
                existe=false;
                JOptionPane.showMessageDialog(null, "La colision ha terminado");
                barra.setValue(0);
                
                int colision =  r.nextInt(100)+0;
                int x = (planeta1.getCordenadaX()+planeta2.getCordenadaX())/2;
                int y = (planeta1.getCordenaday()+planeta2.getCordenaday())/2;
                int peso = (planeta1.getPeso()+planeta2.getPeso())/2;
                int size = (planeta1.getTamaño()+planeta2.getTamaño())/2;

                if (planeta1 instanceof Terrestre){
                    if(colision <= 25){
                        JOptionPane.showMessageDialog(null, "Nuevo planeta creado");
                        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del planeta nuevo");
                        Terrestre terrestre = new Terrestre (size, peso, nombre, x,y);
                        cientifico.getPlanetasdescubiertos().add(terrestre);
                    }
                }else if (planeta2 instanceof Gaseoso){
                    if(colision <= 20){
                        JOptionPane.showMessageDialog(null, "Nuevo planeta creado");
                        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del planeta nuevo");
                        Gaseoso gaseoso = new Gaseoso ( size,peso,nombre, x, y);
                        cientifico.getPlanetasdescubiertos().add(gaseoso);
                    }
                }

            }                
            
            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {
            }
        }
    }
    
}
}
    



