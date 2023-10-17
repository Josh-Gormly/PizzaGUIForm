import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class PizzaGUIFrame extends JFrame
{
    JPanel mainPnl;
    JPanel controlPnl;
    JPanel toppingsPnl;
    JPanel comboPizzaPnl;
    JPanel receiptPnl;
    JPanel northPnl;
    JPanel btnPnl;

    JRadioButton thin;
    JRadioButton regular;
    JRadioButton deepDish;
    JComboBox<String> combos;
    JCheckBox pepperoniBox;
    JCheckBox onionBox;
    JCheckBox pineappleBox;
    JCheckBox chickenBox;
    JCheckBox baconBox;
    JCheckBox greenPeppersBox;
    JCheckBox redPeppersBox;
    JCheckBox mushroomBox;
    JCheckBox sausageBox;
    JCheckBox fourCheeseBox;
    JCheckBox spinachBox;
    JCheckBox hamBox;
    JTextArea receipt;
    JScrollPane scroller;
    JButton orderBtn;
    JButton clearBtn;
    JButton quitBtn;

    boolean orderPlaced = false;
    public PizzaGUIFrame()
    {
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());
        northPnl = new JPanel();
        northPnl.setLayout(new BorderLayout());

        createRadioPnl();
        createcomboPizzaPnl();
        createToppingsPnl();
        createReceiptPnl();
        createControlPnl();
        northPnl.add(comboPizzaPnl,BorderLayout.WEST);
        northPnl.add(btnPnl,BorderLayout.CENTER);
        northPnl.add(toppingsPnl,BorderLayout.EAST);
        mainPnl.add(controlPnl,BorderLayout.SOUTH);
        mainPnl.add(receiptPnl,BorderLayout.CENTER);
        mainPnl.add(northPnl,BorderLayout.NORTH);
        add(mainPnl);
        setVisible(true);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(3*(screenWidth / 4), 3*(screenHeight / 4));
        setLocationRelativeTo(null);
    }

    private void createRadioPnl()
    {
        btnPnl = new JPanel();
        btnPnl.setLayout(new GridLayout(0, 1));
        btnPnl.setBorder(new TitledBorder(new EtchedBorder(), "Crust (choose one)"));

        thin = new JRadioButton("Thin");
        regular = new JRadioButton("Regular");
        deepDish = new JRadioButton("Deep Dish");
        btnPnl.add(thin);
        btnPnl.add(regular);
        btnPnl.add(deepDish);

        regular.setSelected(true);
        ButtonGroup crust = new ButtonGroup();
        crust.add(thin);
        crust.add(regular);
        crust.add(deepDish);
    }

    private void createcomboPizzaPnl()
    {
        comboPizzaPnl = new JPanel();
        comboPizzaPnl.setLayout(new GridLayout());
        comboPizzaPnl.setBorder(new TitledBorder(new EtchedBorder(), "Size (choose one"));

        combos = new JComboBox<>();
        combos.addItem("Small ($8.00)");
        combos.addItem("Medium ($12.00");
        combos.addItem("Large ($16.00");
        combos.addItem("Super ($20.00");
        comboPizzaPnl.add(combos);
    }

    private void createReceiptPnl()
    {
        receiptPnl = new JPanel();
        receiptPnl.setLayout(new BorderLayout());
        receiptPnl.setBorder(new TitledBorder(new EtchedBorder(), "Order Details"));

        receipt = new JTextArea(20,30);
        scroller = new JScrollPane(receipt);
        scroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        receipt.setEditable(false);
        receiptPnl.add(scroller);
    }

    private void createToppingsPnl()
    {
        toppingsPnl = new JPanel();
        toppingsPnl.setLayout(new GridLayout(2,4));
        toppingsPnl.setBorder(new TitledBorder(new EtchedBorder(),"Toppings ($1 per additonal topping)"));

        pepperoniBox = new JCheckBox("Pepperoni");
        onionBox = new JCheckBox("Onion");
        pineappleBox = new JCheckBox("Pineapple");
        chickenBox = new JCheckBox("Chicken");
        baconBox = new JCheckBox("Bacon");
        greenPeppersBox = new JCheckBox("Green Peppers");
        redPeppersBox = new JCheckBox("Red Peppers");
        mushroomBox = new JCheckBox("Mushrooms");
        sausageBox = new JCheckBox("Sausage");
        fourCheeseBox = new JCheckBox ("Four Cheese");
        spinachBox = new JCheckBox("Spinach");
        hamBox = new JCheckBox("Ham");

        toppingsPnl.add(pepperoniBox);
        toppingsPnl.add(onionBox);
        toppingsPnl.add(pineappleBox);
        toppingsPnl.add(chickenBox);
        toppingsPnl.add(baconBox);
        toppingsPnl.add(greenPeppersBox);
        toppingsPnl.add(redPeppersBox);
        toppingsPnl.add(mushroomBox);
        toppingsPnl.add(sausageBox);
        toppingsPnl.add(fourCheeseBox);
        spinachBox.add(spinachBox);
        hamBox.add(hamBox);
    }
    private void createControlPnl()
    {
        controlPnl = new JPanel();
        controlPnl.setLayout(new GridLayout(1,3));
        orderBtn = new JButton("Place Your Order");
        orderBtn.addActionListener((ActionEvent ae) -> placeOrder());
        clearBtn = new JButton("Clear");
        clearBtn.addActionListener((ActionEvent ae) ->
        {
            pepperoniBox.setSelected(false);
            onionBox.setSelected(false);
            pineappleBox.setSelected(false);
            chickenBox.setSelected(false);
            baconBox.setSelected(false);
            greenPeppersBox.setSelected(false);
            redPeppersBox.setSelected(false);
            mushroomBox.setSelected(false);
            sausageBox.setSelected(false);
            fourCheeseBox.setSelected(false);
            spinachBox.setSelected(false);
            hamBox.setSelected(false);
            receipt.setText(null);
            combos.setSelectedIndex(0);
            regular.setSelected(true);
            orderPlaced = false;
        });
        quitBtn = new JButton("Quit");
        quitBtn.addActionListener((ActionEvent ae) ->
        {
            int choice = JOptionPane.showConfirmDialog(quitBtn, "Do you want to quit?", "Quit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (choice == JOptionPane.YES_OPTION)
            {
                System.exit(0);
            }});
        controlPnl.add(orderBtn);
        controlPnl.add(clearBtn);
        controlPnl.add(quitBtn);
    }
    private double subTotal;
    public void placeOrder()
    {
        if(!orderPlaced)
        {
            subTotal = 0;
            addSeparators();
            checkCrustAndSizes();
            checkToppings();
            receipt.append("\n\n\n");
            calculatePrice();
            addSeparators();
            orderPlaced=true;
        }
    }

    private void checkCrustAndSizes()
    {
        String chosenCrust = "";
        if(thin.isSelected())
        {
            chosenCrust = "Thin";
        }
        if(regular.isSelected())
        {
            chosenCrust = "Regular";
        }
        if(deepDish.isSelected())
        {
            chosenCrust = "Deep-Dish";
        }
        String chosenSize = Objects.requireNonNull(combos.getSelectedItem()).toString();
        if(Objects.equals(chosenSize, "Small ($8.00"))
        {
            receipt.append("size and Crust Type: Small, " + chosenCrust+ "   $8.00 \n");
            subTotal +=8.0;
        }
        if(Objects.equals(chosenSize, "Medium ($12.00"))
        {
            receipt.append("size and Crust Type: Medium, " + chosenCrust+ "   $12.00 \n");
            subTotal +=12.0;
        }
        if(Objects.equals(chosenSize, "Large ($16.00"))
        {
            receipt.append("size and Crust Type: Large, " + chosenCrust+ "   $16.00 \n");
            subTotal +=16.0;
        }
        if(Objects.equals(chosenSize, "Super ($20.00")) {
            receipt.append("size and Crust Type: Super, " + chosenCrust + "   $20.00 \n");
            subTotal += 20.0;
        }
    }

    public void addSeparators()
    {
        receipt.append("====================================================================");
    }
    public void calculatePrice()
    {
        double taxes = subTotal * 0.07;
        double totalPrice = subTotal + taxes ;

        receipt.append("Subtotal:        $" + String.format("%.2f",subTotal) + "\n");
        receipt.append("Tax:                $" + String.format("%.2f",totalPrice) + "\n");
        receipt.append("-------------------------------------------------------------------");
        receipt.append("Total Price:      $" + String.format("%.2f",totalPrice) + "\n");
    }
    public void checkToppings()
    {
        ArrayList<JCheckBox> toppingsButtons = new ArrayList<>(Arrays.asList(pepperoniBox,onionBox,pineappleBox,chickenBox,baconBox,greenPeppersBox,redPeppersBox,mushroomBox,sausageBox,fourCheeseBox,spinachBox,hamBox));
        ArrayList<String> selectedToppings = new ArrayList<>();
        for (int i = 0; i < 12; i++)
        {
            if(toppingsButtons.get(i).isSelected())
            {
                selectedToppings.add(toppingsButtons.get(i).getText());
            }
        }
        receipt.append("Toppings: ");
        for(int j = 0; j < selectedToppings.size(); j++)
        {
            subTotal +=1.0;
            if(j < selectedToppings.size() - 1)
            {
                receipt.append(selectedToppings.get(j) + ", ");
            }
            else
            {
                receipt.append(selectedToppings.get(j));
            }
            receipt.append("      $" + selectedToppings.size() + ".00\n");
        }
    }
}