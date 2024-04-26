package AppLoad;

import AeroflotGUIService.AeroflotGUI;

import javax.swing.*;

public class AppLoad {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(AeroflotGUI::createGUI);
    }
}
