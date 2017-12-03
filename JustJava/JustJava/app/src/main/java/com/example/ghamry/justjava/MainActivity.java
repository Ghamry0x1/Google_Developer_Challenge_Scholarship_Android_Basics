package com.example.ghamry.justjava;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    TextView quantityTextView;
    TextView priceTextView;
    CheckBox whippedCreamChk;
    CheckBox chocolateChk;
    EditText nameTxt;

    int quantity = 0;
    int price = 0;
    int topping = 0;
    boolean hasWhippedCream;
    boolean hasChocolate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        priceTextView = (TextView) findViewById(R.id.price_text_view);
        whippedCreamChk = (CheckBox) findViewById(R.id.whippedCreamChk);
        chocolateChk = (CheckBox) findViewById(R.id.chocolateChk);
        nameTxt = (EditText) findViewById(R.id.name);
    }

    public void increment(View view) {
        quantity++;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        if (quantity > 0)
            quantity--;
        displayQuantity(quantity);
    }

    public void displayQuantity(int quantity) {
        quantityTextView.setText("" + quantity);
    }

    public void calculateTopping() {
        hasWhippedCream = whippedCreamChk.isChecked();
        hasChocolate = chocolateChk.isChecked();

        if (hasWhippedCream)
            topping++;
        if (hasChocolate)
            topping += 2;
    }

    public int calculatePrice(View view) {
        calculateTopping();
        price = (5 + topping) * quantity;
        return price;
    }

    public void displayPrice(View view) {
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(calculatePrice(view)));
        topping = 0;
    }

    public String printOrderDetails() {
        return getString(R.string.name) + ": " + nameTxt.getText()
                + "\n" + getString(R.string.quantity) + ": " + quantity
                + "\n" + getString(R.string.added) + " " + getString(R.string.whippedCream) + ": " + hasWhippedCream
                + "\n" + getString(R.string.added) + " " + getString(R.string.chocolate) + ": " + hasChocolate
                + "\n\n" + getString(R.string.total) + ": " + priceTextView.getText()
                + "\n" + getString(R.string.thankyou);
    }

    public void submitOrder(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "", null));
        intent.putExtra(Intent.EXTRA_SUBJECT, "JustJava " + getString(R.string.orderFor) + " " + nameTxt.getText());
        intent.putExtra(Intent.EXTRA_TEXT, printOrderDetails());

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}
