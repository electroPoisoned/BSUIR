package AeroflotGUIService;

import AeroflotData.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class AeroflotGUI {
    private static ArrayList<Aeroflot> aeroflotList = new ArrayList<>();
    private static JFrame frame;
    private static JTable allFlightsTable;
    private static JTable searchResultsTable;
    private static JTextField searchField;

    public static void createGUI() {
        frame = new JFrame("Aeroflot Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        JButton addButton = new JButton("Add Flight");
        addButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, addButton.getMinimumSize().height));
        addButton.addActionListener(e -> addFlight());
        buttonPanel.add(addButton);

        JButton saveButton = new JButton("Save Flights");
        saveButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, saveButton.getMinimumSize().height));
        saveButton.addActionListener(e -> saveFlights());
        buttonPanel.add(saveButton);

        JButton loadButton = new JButton("Load Flights");
        loadButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, loadButton.getMinimumSize().height));
        loadButton.addActionListener(e -> loadFlights());
        buttonPanel.add(loadButton);

        JButton sortButton = new JButton("Sort Flights");
        sortButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, sortButton.getMinimumSize().height));
        sortButton.addActionListener(e -> sortFlights());
        buttonPanel.add(sortButton);

        JButton deleteButton = new JButton("Delete Flight");
        deleteButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, deleteButton.getMinimumSize().height));
        deleteButton.addActionListener(e -> deleteFlight());
        buttonPanel.add(deleteButton);

        searchField = new JTextField(20);
        searchField.setMaximumSize(new Dimension(Integer.MAX_VALUE, searchField.getPreferredSize().height));
        buttonPanel.add(searchField);

        JButton searchButton = new JButton("Search Flights");
        searchButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, searchButton.getMinimumSize().height));
        searchButton.addActionListener(e -> searchFlights());
        buttonPanel.add(searchButton);

        allFlightsTable = new JTable();
        JScrollPane allFlightsScrollPane = new JScrollPane(allFlightsTable);

        searchResultsTable = new JTable();
        JScrollPane searchResultsScrollPane = new JScrollPane(searchResultsTable);

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                allFlightsScrollPane,
                searchResultsScrollPane);
        splitPane.setResizeWeight(0.7);

        panel.add(buttonPanel, BorderLayout.EAST);
        panel.add(splitPane, BorderLayout.CENTER);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private static void addFlight() {
        JTextField destinationField = new JTextField(5);
        JTextField flightNumberField = new JTextField(5);
        JComboBox<PlaneType> planeTypeComboBox = new JComboBox<>(PlaneType.values());

        JPanel myPanel = new JPanel();
        myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
        myPanel.add(new JLabel("Destination:"));
        myPanel.add(destinationField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Flight Number:"));
        myPanel.add(flightNumberField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Plane Type:"));
        myPanel.add(planeTypeComboBox);

        int result = JOptionPane.showConfirmDialog(null,
                myPanel,
                "Add Flight",
                JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            Aeroflot aeroflot = new Aeroflot(destinationField.getText(),
                    flightNumberField.getText(),
                    (PlaneType) planeTypeComboBox.getSelectedItem());
            aeroflotList.add(aeroflot);
            updateAllFlightsTable();
        }
    }

    private static void saveFlights() {
        try {
            PrintWriter writer = new PrintWriter("flights.txt", "UTF-8");
            for (Aeroflot aeroflot : aeroflotList) {
                writer.println(aeroflot.getDestination() + ","
                        + aeroflot.getFlightNumber() + ","
                        + aeroflot.getPlaneType());
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void loadFlights() {
        try {
            Scanner scanner = new Scanner(new File("flights.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String destination = parts[0];
                String flightNumber = parts[1];
                PlaneType planeType = PlaneType.valueOf(parts[2]);
                Aeroflot aeroflot = new Aeroflot(destination, flightNumber, planeType);
                aeroflotList.add(aeroflot);
            }
            scanner.close();
            updateAllFlightsTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void sortFlights() {
        String[] options = {"Destination", "Flight Number", "Plane Type"};
        String input = (String) JOptionPane.showInputDialog(null, "Choose field to sort by",
                "Sort Options", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        Comparator<Aeroflot> comparator = switch (input) {
            case "Destination" -> Comparator.comparing(Aeroflot::getDestination);
            case "Flight Number" -> Comparator.comparing(Aeroflot::getFlightNumber);
            case "Plane Type" -> Comparator.comparing(Aeroflot::getPlaneType);
            default -> null;
        };

        if (comparator != null) {
            aeroflotList.sort(comparator);
            updateAllFlightsTable();
        }
    }


    private static void deleteFlight() {
        String flightNumber = JOptionPane.showInputDialog("Enter the flight number of the flight to delete:");
        aeroflotList.removeIf(aeroflot -> aeroflot.getFlightNumber().equals(flightNumber));
        updateAllFlightsTable();
        //updateSearchResultsTable();
    }

    private static void searchFlights() {
        String search = searchField.getText();
        ArrayList<Aeroflot> searchResults = new ArrayList<>();
        for (Aeroflot aeroflot : aeroflotList) {
            if (aeroflot.getDestination().contains(search) ||
                    aeroflot.getFlightNumber().contains(search) ||
                    aeroflot.getPlaneType().toString().contains(search.toUpperCase())) {
                searchResults.add(aeroflot);
            }
        }
        if (searchResults.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "FLIGHTS NOT FOUND!");
        } else {
            updateSearchResultsTable(searchResults);
        }
    }


    private static void updateAllFlightsTable() {
        String[] columnNames = {"Destination", "Flight Number", "Plane Type"};
        String[][] data = new String[aeroflotList.size()][3];
        for (int i = 0; i < aeroflotList.size(); i++) {
            Aeroflot aeroflot = aeroflotList.get(i);
            data[i][0] = aeroflot.getDestination();
            data[i][1] = aeroflot.getFlightNumber();
            data[i][2] = aeroflot.getPlaneType().toString();
        }
        allFlightsTable.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    }

    private static void updateSearchResultsTable(ArrayList<Aeroflot> searchResults) {
        String[] columnNames = {"Destination", "Flight Number", "Plane Type"};
        String[][] data = new String[searchResults.size()][3];
        for (int i = 0; i < searchResults.size(); i++) {
            Aeroflot aeroflot = searchResults.get(i);
            data[i][0] = aeroflot.getDestination();
            data[i][1] = aeroflot.getFlightNumber();
            data[i][2] = aeroflot.getPlaneType().toString();
        }
        searchResultsTable.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    }
}
