package com.example.lewin.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentThree extends Fragment {
    Button changeButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view_three = inflater.inflate(R.layout.fragment_fragment_one, container, false);

        changeButton = (Button) view_three.findViewById(R.id.button);

        // Get the passed string parameter from first fragment
        String className = "";
        if (getArguments() != null) {
            className = getArguments().getString("FragTwoClassName");
        }

        // Display on Text box
        TextView t_view = (TextView) view_three.findViewById(R.id.display);
        t_view.setText(className);

        // Add Third_Fragment to the string
        final String concatName = className + "Third_Fragment ";

        // Function to handle button click
        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {

                // Set up Bundle for the current string
                Bundle bundle = new Bundle();
                bundle.putString("FragThreeClassName", concatName);

                // Set up Fragment manager and fragment transaction
                FragmentManager frag_manager = getActivity().getSupportFragmentManager();
                FragmentTransaction frag_transaction = frag_manager.beginTransaction();

                // Pass the string to the first fragment
                FragmentOne fragment_one = new FragmentOne();
                fragment_one.setArguments(bundle);

                // Put the first fragment to the screen
                frag_transaction.replace(R.id.frame, fragment_one);
                frag_transaction.addToBackStack(null);
                frag_transaction.commit();
            }
        });

        return view_three;
    }
}
