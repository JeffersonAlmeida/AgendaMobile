/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Timer;
import java.util.TimerTask;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

/**
 *
 * @author Junior
 */
public class SplashScreen extends Canvas {

    private Display display;
    private Displayable next;
    Image imagem;
    private Timer timer = new Timer();

    public SplashScreen(Display display, Displayable next) {
        this.display = display;
        this.next = next;
        display.setCurrent(this);
        setFullScreenMode(true);
    }

    protected void paint(Graphics g) {
        try {
            imagem = Image.createImage("/imagem/menu.png");
        } catch (Exception e) {
            System.out.println("Erro ao carregar imagem da tela inicial!");
        }
        Font font1 = Font.getFont(Font.FONT_STATIC_TEXT, Font.STYLE_ITALIC, Font.SIZE_MEDIUM);
        Font font2 = Font.getFont(Font.FONT_STATIC_TEXT, Font.STYLE_BOLD, Font.SIZE_SMALL);
        g.setFont(font1);
        g.setFont(font2);
        g.setColor(100, 50, 100);
        g.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
        g.setColor(255, 255, 255);
        g.drawString("Bem-Vindo", font1.stringWidth(" Seja Bem-Vindo"), 2, Graphics.TOP | Graphics.HCENTER);
        g.setColor(250, 200, 250);
        g.drawString("Agenda", getWidth() / 2, font2.getHeight() / 2 + 6, Graphics.TOP | Graphics.HCENTER);
        g.drawString("Versão x300", getWidth() / 2, font2.getHeight() + 10, Graphics.TOP | Graphics.HCENTER);
        g.setColor(255, 255, 255);
        g.drawString("Autor: JeffersonAlmeida", getWidth() / 2, font2.getHeight() + 24, Graphics.TOP | Graphics.HCENTER);
        g.drawImage(imagem, getWidth() / 2, getHeight() / 2, Graphics.VCENTER | Graphics.HCENTER);
    }

    protected void pointerPressed(int x, int y) {
        dismiss();
    }

    protected void showNotify() {
        int tempo = 5000;
        // timer.schedule(new CountD, tempo);
        timer.schedule(new CountDown(), tempo);
    }

    private void dismiss() {
        timer.cancel();
        display.setCurrent(next);
    }

    private class CountDown extends TimerTask {

        public void run() {
            dismiss();
        }
    }
}
