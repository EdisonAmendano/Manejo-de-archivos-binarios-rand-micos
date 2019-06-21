package ec.edu.ups.vista;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Edison
 */
public class Listar extends javax.swing.JInternalFrame {

    /**
     * Creates new form Listar
     */
    DefaultTableModel modelo;

    public Listar() {
        initComponents();
        llenarDatos();
    }

    public void llenarDatos() {
        modelo = (DefaultTableModel) table.getModel();
        int c = 0;
        int con = 0;
        int posicion;
        // Se obtiene la lista de controladorCliente 
        // Es un arreglo de un objeto
        while (con == 0) {
            try {
                String ruta = "Personas.ups";
                RandomAccessFile archivo = new RandomAccessFile(ruta, "r");
                posicion = c * 152;
                archivo.seek(posicion);
                if (!archivo.readUTF().equals("                                                  ")) {
                    String nombre = archivo.readUTF();
                    archivo.seek(posicion + 52);
                    String apellido = archivo.readUTF();
                    archivo.seek(posicion + 104);
                    String cedula = archivo.readUTF();
                    archivo.seek(posicion + 116);
                    int edad = archivo.readInt();
                    archivo.seek(posicion + 120);
                    String fecha = archivo.readUTF();
                    archivo.seek(posicion + 132);
                    String celular = archivo.readUTF();
                    archivo.seek(posicion + 144);
                    double salario = archivo.readDouble();
                    Object[] datos = {
                        cedula,
                        apellido,
                        nombre,
                        edad,
                        fecha,
                        celular,
                        salario,
                        c};
                    modelo.addRow(datos);
                }
                c++;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Listar.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException e) {
                con = 1;
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnCerrar = new javax.swing.JButton();

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Apellido", "Nombre", "Edad", "Fecha", "Celular", "Salario", "Posicion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCerrar))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
