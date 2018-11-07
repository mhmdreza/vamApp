package com.example.mhmdreza_j.vamapp;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        initializeViews(view);
        return view;
    }

    private void initializeViews(View view) {
        initializeProfileImage(view);
        initializeEditTexts(view);
        initializeButtons(view);
    }

    private void initializeButtons(View view) {
        view.findViewById(R.id.profileSubmitButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSubmitButtonClicked(view);
            }
        });
        view.findViewById(R.id.profileCancelButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCancelButtonClicked(view);
            }
        });
    }

    private void onCancelButtonClicked(View view) {
        Toast.makeText(view.getContext(), "onCancelButtonClicked", Toast.LENGTH_SHORT).show();
    }

    private void onSubmitButtonClicked(View view) {
        Toast.makeText(view.getContext(), "onSubmitButtonClicked", Toast.LENGTH_SHORT).show();
    }

    private void initializeProfileImage(View view) {
        ImageView profileImageView = view.findViewById(R.id.profileImageView);
        profileImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onProfileImageClicked(view);
            }
        });
        Glide.with(view.getContext())
                .load("data:image/png;base64,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")
                .apply(new RequestOptions().circleCrop())
                .into(profileImageView);
    }

    private void onProfileImageClicked(View view) {
        Toast.makeText(view.getContext(), "onProfileImageClicked", Toast.LENGTH_SHORT).show();
    }

    private void initializeEditTexts(View view) {
        EditText nameEditText = view.findViewById(R.id.nameEditText);
        final TextView nameHintTextView = view.findViewById(R.id.nameHintTextView);
        initThisEditText(nameEditText, nameHintTextView);
        EditText phoneNumberEditText = view.findViewById(R.id.phoneNumberEditText);
        final TextView phoneNumberHintTextView = view.findViewById(R.id.phoneNumberHintTextView);
        initThisEditText(phoneNumberEditText, phoneNumberHintTextView);
        EditText creditNumberEditText = view.findViewById(R.id.creditNumberEditText);
        final TextView creditNumberHintTextView = view.findViewById(R.id.creditNumberHintTextView);
        initThisEditText(creditNumberEditText, creditNumberHintTextView);
        EditText emailEditText = view.findViewById(R.id.emailEditText);
        final TextView emailHintTextView = view.findViewById(R.id.emailHintTextView);
        initThisEditText(emailEditText, emailHintTextView);
        EditText addressEditText = view.findViewById(R.id.addressEditText);
        final TextView addressHintTextView = view.findViewById(R.id.addressHintTextView);
        initThisEditText(addressEditText, addressHintTextView);

    }

    private void initThisEditText(EditText editText, final TextView hintTextView) {
        hintTextView.bringToFront();
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() > 0) {
                    hintTextView.setVisibility(View.VISIBLE);
                } else {
                    hintTextView.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

}
