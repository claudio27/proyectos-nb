package canvas2;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class CanvasApplet2 extends Applet {
  Scrollbar sbRadio = new Scrollbar();
  BorderLayout borderLayout1 = new BorderLayout();
  MiCanvas canvas;

  public CanvasApplet2() {
  }

  public void init() {
    try {
    jbInit();
    }
    catch (Exception e) {
    e.printStackTrace();
    }
  }
  private void jbInit() throws Exception {
    int ancho = Integer.parseInt(this.getParameter("WIDTH"));
    int alto = Integer.parseInt(this.getParameter("HEIGHT"));
    this.setSize(new Dimension(ancho, alto));
    canvas=new MiCanvas();
    sbRadio.setOrientation(0);
    sbRadio.setValue(10);
    sbRadio.setMaximum(110);
    sbRadio.setMinimum(10);
    sbRadio.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
      public void adjustmentValueChanged(AdjustmentEvent ev) {
        sbRadio_adjustmentValueChanged(ev);
      }
    });
    this.setLayout(borderLayout1);
    this.add(sbRadio, BorderLayout.NORTH);
    this.add(canvas, BorderLayout.CENTER);
  }
   void sbRadio_adjustmentValueChanged(AdjustmentEvent ev) {
     canvas.setRadio(ev.getValue());
  }

}

