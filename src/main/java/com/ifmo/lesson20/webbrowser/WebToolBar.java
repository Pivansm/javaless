package com.ifmo.lesson20.webbrowser;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

public class WebToolBar extends JToolBar implements HyperlinkListener {
    private WebBrowserPane webBrowserPane;
    private JButton backButton;
    private JButton forwardButton;
    private JTextField urlTextField;

    public WebToolBar(WebBrowserPane browserPane) {
        super("Web Navigation");
        webBrowserPane = browserPane;
        webBrowserPane.addHyperlinkListener(this);

        urlTextField = new JTextField(25);
        urlTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    URL url = new URL(urlTextField.getText());
                    webBrowserPane.goToURL(url);
                } catch (MalformedURLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public void hyperlinkUpdate(HyperlinkEvent event) {

    }
}
