package com.clx.registerDevices;

import com.clx.registerDevices.services.RegisterDevicesServices;
import com.clx.registerDevices.view.SearchDevices;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

import javax.swing.*;
import java.awt.*;

@SpringBootApplication
@ComponentScan(basePackages = {"com"})
public class SwingApp extends JFrame {

    private JFrame jFrame = null;
    private JPanel jContentPane = null;
    private JMenuBar jJMenuBar = null;
    private JMenu jMenuSearch = null;
    private JMenuItem jMenuItemSearchDevices = null;
    private JMenu jMenuSair = null;
    private JMenuItem jMenuItemSair = null;

    private final RegisterDevicesServices registerDevicesServices;

    public SwingApp(RegisterDevicesServices registerDevicesServices) {
        this.registerDevicesServices = registerDevicesServices;
    }


    /**
     * This method initializes jFrame
     *
     * @return javax.swing.JFrame
     */
    private JFrame getJFrame() {
        if (jFrame == null) {
            jFrame = new JFrame();
            jFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            jFrame.setResizable(false);
            jFrame.setJMenuBar(getJJMenuBar());
            jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            jFrame.setLocationRelativeTo(null);
            Dimension dimensao = Toolkit.getDefaultToolkit().getScreenSize();
            double largura = dimensao.getWidth();
            double altura = dimensao.getHeight();
            jFrame.setSize((int) largura, (int) altura);
            jFrame.setContentPane(getJContentPane());
            jFrame.setTitle("Trusts Devices Hack App");
        }
        return jFrame;
    }

    /**
     * This method initializes jContentPane
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJContentPane() {
        if (jContentPane == null) {
            jContentPane = new JPanel();
            jContentPane.setLayout(new BorderLayout());
        }
        return jContentPane;
    }

    /**
     * This method initializes jJMenuBar
     *
     * @return javax.swing.JMenuBar
     */
    private JMenuBar getJJMenuBar() {
        if (jJMenuBar == null) {
            jJMenuBar = new JMenuBar();
            jJMenuBar.add(getJMenuSearch());
            //jJMenuBar.add(getJMenu());
            jJMenuBar.add(getJMenuExit());
        }
        return jJMenuBar;
    }

    /**
     * This method initializes jMenuPesquisas
     *
     * @return javax.swing.JMenu
     */
    private JMenu getJMenuSearch() {
        if (jMenuSearch == null) {
            jMenuSearch = new JMenu();
            jMenuSearch.setText("Search");
            jMenuSearch.add(getJMenuItemSearchDevices());
        }
        return jMenuSearch;
    }

    /**
     * This method initializes jMenuItemPesquisaMarca
     *
     * @return javax.swing.JMenuItem
     */
    private JMenuItem getJMenuItemSearchDevices() {
        if (jMenuItemSearchDevices == null) {
            jMenuItemSearchDevices = new JMenuItem();
            jMenuItemSearchDevices.setText("Search Devices");
            jMenuItemSearchDevices
                    .addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent e) {
                            SearchDevices p = new SearchDevices(registerDevicesServices);
                            p.getJFrame().setVisible(true);
                        }
                    });
        }
        return jMenuItemSearchDevices;
    }


    /**
     * This method initializes jMenuSair
     *
     * @return javax.swing.JMenu
     */
    private JMenu getJMenuExit() {
        if (jMenuSair == null) {
            jMenuSair = new JMenu();
            jMenuSair.setText("Exit");
            jMenuSair.add(getJMenuItemExit());
        }
        return jMenuSair;
    }

    /**
     * This method initializes jMenuItemSair
     *
     * @return javax.swing.JMenuItem
     */
    private JMenuItem getJMenuItemExit() {
        if (jMenuItemSair == null) {
            jMenuItemSair = new JMenuItem();
            jMenuItemSair.setText("Exit");
            jMenuItemSair.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    System.exit(0);
                }
            });
        }
        return jMenuItemSair;
    }

    public static void main(String[] args) {
        org.springframework.context.ConfigurableApplicationContext ctx = new SpringApplicationBuilder(SwingApp.class).headless(false).run(args);
        EventQueue.invokeLater(() -> {
            SwingApp ex = ctx.getBean(SwingApp.class);
            ex.getJFrame().setVisible(true);
        });
    }


}
