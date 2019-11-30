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

        backButton = new JButton();
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                URL url = webBrowserPane.back();
                urlTextField.setText(url.toString());
            }
        });

        forwardButton = new JButton();
        forwardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                URL url = webBrowserPane.forward();
                urlTextField.setText(url.toString());
            }
        });

        add(backButton);
        add(forwardButton);
        add(urlTextField);
    }

    public void hyperlinkUpdate(HyperlinkEvent event) {
        if(event.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
            URL url = event.getURL();
            webBrowserPane.goToURL(url);
            urlTextField.setText(url.toString());
        }
    }
}
