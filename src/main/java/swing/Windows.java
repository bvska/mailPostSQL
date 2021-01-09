package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Windows {
    private JFrame frame = new JFrame("mail postgres base");
    private final  static String users = "Users";
    private final  static String aliases = "Aliases";
    private final  static String directories = "Directories";
    private final  static String domain = "Domain";
    private final  static String transport = "Transport";
    private final  static String client = "Client";

    public void start() {

        frame.setSize(900, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();
        PanelU panelU = new PanelU();
        panelU.st();

        PanelA panelA = new PanelA();
        panelA.st();

        PanelD panelD = new PanelD();
        panelD.st();

        PanelDi panelDi = new PanelDi();
        panelDi.st();

       PanelT panelT = new PanelT();
       panelT.st();

        PanelC panelC = new PanelC();
        panelC.st();


        tabbedPane.addTab(users, panelU);
        tabbedPane.addTab(aliases, panelA);
        tabbedPane.addTab(domain, panelD);
        tabbedPane.addTab(directories, panelDi);
        tabbedPane.addTab(transport, panelT);
        tabbedPane.addTab(client, panelC);
        frame.add(tabbedPane, BorderLayout.CENTER);

        frame.setVisible(true);

    }
}

