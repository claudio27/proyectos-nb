package koch;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class KochApplet extends Applet {
    Panel bevelPanel1 = new Panel();
    Button btnDibuja = new Button();
    Panel bevelPanel2 = new Panel();
    Panel bevelPanel3 = new Panel();
    FlowLayout flowLayout1 = new FlowLayout();
    FlowLayout flowLayout2 = new FlowLayout();
    TextField textOrden = new TextField();
    Panel bevelPanel4 = new Panel();
    Label label2 = new Label();
    Choice chCurvas = new Choice();
    FlowLayout flowLayout3 = new FlowLayout();
    BorderLayout borderLayout1 = new BorderLayout();
    BorderLayout borderLayout2 = new BorderLayout();
  Button btnOrden = new Button();
  int orden=0;
    MiCanvas canvas;
//Initialize the applet

    public void init() {
        try {
        jbInit();
        }
        catch (Exception e) {
        e.printStackTrace();
        }
    }
//Component initialization
    
    private void jbInit() throws Exception {
        int ancho = Integer.parseInt(this.getParameter("WIDTH"));
        int alto = Integer.parseInt(this.getParameter("HEIGHT"));
        this.setSize(new Dimension(ancho, alto));
        canvas=new MiCanvas();
        chCurvas.addItem("Koch");
        chCurvas.addItem("Peano");
        chCurvas.addItem("Hilbert");

        bevelPanel1.setBackground(Color.lightGray);
        bevelPanel1.setLayout(borderLayout1);
        btnDibuja.setLabel("Dibuja");
        bevelPanel2.setLayout(flowLayout2);
        bevelPanel3.setBackground(Color.gray);
        bevelPanel3.setLayout(flowLayout1);
        flowLayout1.setAlignment(2);
        flowLayout1.setVgap(1);
        flowLayout2.setAlignment(0);
        flowLayout2.setVgap(1);
        textOrden.setText("0");
        textOrden.setColumns(2);
        textOrden.setEditable(false);
        bevelPanel4.setLayout(flowLayout3);
        label2.setText("Curvas");
    chCurvas.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        chCurvas_itemStateChanged(e);
      }
    });
        flowLayout3.setAlignment(0);
        flowLayout3.setVgap(1);
    btnOrden.setLabel("Orden >>");
    btnOrden.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOrden_actionPerformed(e);
      }
    });
        btnDibuja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnDibuja_actionPerformed(e);
            }
        });
        this.setLayout(borderLayout2);
        this.add(bevelPanel1, BorderLayout.SOUTH);
        bevelPanel1.add(bevelPanel2, BorderLayout.CENTER);
    bevelPanel2.add(btnOrden, null);
        bevelPanel2.add(textOrden, null);
        bevelPanel1.add(bevelPanel3, BorderLayout.EAST);
        bevelPanel3.add(btnDibuja, null);
        bevelPanel1.add(bevelPanel4, BorderLayout.WEST);
        bevelPanel4.add(label2, null);
        bevelPanel4.add(chCurvas, null);
        this.add(canvas, BorderLayout.CENTER);
        textOrden.setEditable(false);
    }
    void btnDibuja_actionPerformed(ActionEvent e) {
        int nCurva=chCurvas.getSelectedIndex();
        canvas.setNuevo(orden, nCurva);
  }


  void chCurvas_itemStateChanged(ItemEvent e) {
    orden=0;
    textOrden.setText("0");
  }

  void btnOrden_actionPerformed(ActionEvent e) {
    orden++;
    if(orden>5)
      orden=0;
    textOrden.setText(String.valueOf(orden));
  }


}

