package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {
    // Buttons
    private Button ac;
    private Button addition;
    private Button moin;
    private Button multiply;
    private Button divide;
    private Button equals;
    private TextView textView;

    private Button point ;

    // Numbers
    private Button N_1;
    private Button N_2;
    private Button N_3;
    private Button N_4;
    private Button N_5;
    private Button N_6;
    private Button N_7;
    private Button N_8;
    private Button N_9;
    private Button N_0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Initialize buttons
        ac = findViewById(R.id.ac);
        addition = findViewById(R.id.addition);
        moin = findViewById(R.id.soustraction);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.devision);
        equals = findViewById(R.id.equal);
        textView = findViewById(R.id.textView);
        point = findViewById(R.id.point);


        // Initialize number buttons
        N_1 = findViewById(R.id._1);
        N_2 = findViewById(R.id._2);
        N_3 = findViewById(R.id._3);
        N_4 = findViewById(R.id._4);
        N_5 = findViewById(R.id._5);
        N_6 = findViewById(R.id._6);
        N_7 = findViewById(R.id._7);
        N_8 = findViewById(R.id._8);
        N_9 = findViewById(R.id._9);
        N_0 = findViewById(R.id._0);

        // Set listeners for buttons
        setListeners();
    }

    private void setListeners() {
        // Example listener for number buttons
        N_1.setOnClickListener(v -> textView.append("1"));
        N_2.setOnClickListener(v -> textView.append("2"));
        N_3.setOnClickListener(v -> textView.append("3"));
        N_4.setOnClickListener(v -> textView.append("4"));
        N_5.setOnClickListener(v -> textView.append("5"));
        N_6.setOnClickListener(v -> textView.append("6"));
        N_7.setOnClickListener(v -> textView.append("7"));
        N_8.setOnClickListener(v -> textView.append("8"));
        N_9.setOnClickListener(v -> textView.append("9"));
        N_0.setOnClickListener(v -> textView.append("0"));

        // Example listener for operation buttons
        addition.setOnClickListener(v -> textView.append("+"));
        moin.setOnClickListener(v -> textView.append("-"));
        multiply.setOnClickListener(v -> textView.append("*"));
        divide.setOnClickListener(v -> textView.append("/"));
        ac.setOnClickListener(v -> textView.setText("")); // Clear the text view
        point.setOnClickListener(v-> textView.append("."));

        // Equals button to evaluate the expression
        equals.setOnClickListener(v -> evaluateExpression());
    }

    private void evaluateExpression() {
        String expression = textView.getText().toString();

        try {
            Expression exp = new ExpressionBuilder(expression).build();
            double result = exp.evaluate();
            textView.setText(String.valueOf(result));
        } catch (Exception e) {
            textView.setText("Error");
        }
    }
}