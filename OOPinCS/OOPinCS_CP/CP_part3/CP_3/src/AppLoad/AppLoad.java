package AppLoad;

import javax.swing.*;

import static AeroflotGUIService.AeroflotGUI.*;

public class AppLoad {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createGUI());
    }
}
