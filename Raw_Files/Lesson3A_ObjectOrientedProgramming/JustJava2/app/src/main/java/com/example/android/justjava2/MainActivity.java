package com.example.android.justjava2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * Create summary of the order.
     *
     * @param addWhippedCream is whether or not the user wants whipped cream topping
     * @param addChocolate is whether or not the user wants whipped cream topping
     * @param price of the order
     * @return text summary
     */
    private String createOrderSummary(int price, boolean addWhippedCream, boolean addChocolate, String name){

        String message = getString(R.string.ask_name) + name;
        message = message + getString(R.string.add_whipped_cream) + addWhippedCream;
        message = message + getString(R.string.add_chocolate) + addChocolate;
        message = message + getString(R.string.final_quantity) + quantity;
        message = message + getString(R.string.final_price) + price;
        message = message + getString(R.string.thanks_message);
        return message;
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        CheckBox ToppingCheckBox = (CheckBox) findViewById(R.id.topping_checkbox);
        CheckBox ChocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        EditText NameText = (EditText) findViewById(R.id.editName_view);
        String clientName = NameText.getText().toString();

        boolean addWhippedCream = ToppingCheckBox.isChecked();
        boolean addChocolate = ChocolateCheckBox.isChecked();
        int price = calculatePrice(addWhippedCream, addChocolate);

        String priceMessage = createOrderSummary(price,addWhippedCream,addChocolate,clientName);
        String subjectMessage = getString(R.string.coffee_order_message) + clientName;

        // When pressing "Order", create an intent to send the priceMessage on an e-mail.
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, subjectMessage);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) { // Check if at least one application that can handle this.
            startActivity(intent);
        }

    }

    /**
     * This method is called when the + button is clicked.
     */
    public void increment(View view) {

        if (quantity == 100) {
            Toast.makeText(this, getString(R.string.tooManyCoffeeMessage), Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the - button is clicked.
     */
    public void decrement(View view) {

        if (quantity == 1) {
            Toast.makeText(this, getString(R.string.tooFewCoffeeMessage), Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);
    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text);
        quantityTextView.setText("" + number);
    }

    /**
     *
     * @param addWhippedCream is whether or not the user wants whipped cream topping
     * @param addChocolate is whether or not the user wants whipped cream topping
     * @return total price
     **/
    private int calculatePrice(boolean addWhippedCream, boolean addChocolate){

        int basePrice = 5;

        if (addWhippedCream)    basePrice += 1;
        if (addChocolate)       basePrice += 2;

        return quantity*basePrice;
    }
}

