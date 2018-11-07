package com.example.mhmdreza_j.vamapp;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.github.florent37.androidslidr.Slidr;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoanRequestFragment extends Fragment {


    public LoanRequestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_loan_request, container, false);
        initializeView(view);
        return view;
    }

    private void initializeView(final View view) {
        initializePaymentButtons(view);
        final TextView seekBarAmountTextView = view.findViewById(R.id.seekBarAmountTextView);
        Slidr slider = view.findViewById(R.id.loanAmountSlider);
        float maxValue = 1000;
        float minValue = 0;
        float currentValue = 333;
        slider.setMax(maxValue);
        slider.setMin(minValue);
        slider.setCurrentValue(currentValue);
        int progress = ((int) slider.getCurrentValue());
        seekBarAmountTextView.setText(String.format(getString(R.string.loanAmount), changeNumberToPersian(String.valueOf(progress))));
        slider.setListener(new Slidr.Listener() {
            @Override
            public void valueChanged(Slidr slidr, float currentValue) {
                int value = (int) currentValue;
                seekBarAmountTextView.setText(String.format(getString(R.string.loanAmount), changeNumberToPersian(String.valueOf(value))));
            }

            @Override
            public void bubbleClicked(Slidr slidr) {

            }
        });
    }

    private String changeNumberToPersian(String number){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if(c <= '9' && c >= '0'){
                result.append((char) ('۰' + c - '0'));
            }
            else result.append(c);
        }
        return result.toString();
    }

    private void initializePaymentButtons(View view) {
        final ArrayList<Button> buttons = new ArrayList<>();
        Button _12monthsPaymentButton = view.findViewById(R.id._12monthsPaymentButton);
        Button _6monthsPaymentButton = view.findViewById(R.id._6monthsPaymentButton);
        Button _3monthsPaymentButton = view.findViewById(R.id._3monthsPaymentButton);
        Button otherPaymentButton = view.findViewById(R.id.otherPaymentButton);
        buttons.add(_12monthsPaymentButton);
        buttons.add(_6monthsPaymentButton);
        buttons.add(_3monthsPaymentButton);
        buttons.add(otherPaymentButton);
        _12monthsPaymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeButtonBackground(0, buttons);
            }
        });
        _6monthsPaymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeButtonBackground(1, buttons);
            }
        });
        _3monthsPaymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeButtonBackground(2, buttons);
            }
        });
        otherPaymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeButtonBackground(3, buttons);
            }
        });
    }

    @SuppressLint("ResourceAsColor")
    private void changeButtonBackground(int i, ArrayList<Button> buttons) {
        for (int j = 0; j < 4; j++) {
            Button button = buttons.get(j);
            if (j == i){
                button.setBackgroundResource(R.drawable.payment_button_selected_background);
                button.setTextColor(R.color.paymentButtonSelectedTextColor);
            }
            else {
                button.setBackgroundResource(R.drawable.payment_button_background);
                button.setTextColor(Color.WHITE);
            }
        }
    }

}
