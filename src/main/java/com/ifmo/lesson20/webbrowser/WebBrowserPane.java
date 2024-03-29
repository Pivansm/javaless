package com.ifmo.lesson20.webbrowser;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.*;


public class WebBrowserPane extends JEditorPane {
    private List history = new ArrayList<>();
    private int historyIndex;

    public WebBrowserPane() {
        setEditable(false);
    }

    public void goToURL(URL url) {
        displayPage(url);
        history.add(url);
        historyIndex = history.size() -1;
    }

    public URL forward() {
        historyIndex++;
        if(historyIndex >= history.size())
            historyIndex = history.size() -1;
        URL url = (URL)history.get(historyIndex);
        displayPage(url);
        return url;
    }

    public URL back() {
        historyIndex--;
        if(historyIndex < 0)
            historyIndex = 0;

        URL url = (URL)history.get(historyIndex);
        displayPage(url);
        return url;
    }

    private void displayPage(URL pageURL) {
        try {
            setPage(pageURL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
