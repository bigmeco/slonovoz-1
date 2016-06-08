package bigi.slonovoz.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import bigi.slonovoz.R;


public class Fragment4m extends Fragment {
    private Button button;
    private int a, b, c;
    public static Fragment4m newInstance() {
        Fragment4m fragment = new Fragment4m();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment4m, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        button = (Button)getActivity().findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText1 = (EditText) getActivity().findViewById(R.id.editText);
                EditText editText2 = (EditText) getActivity().findViewById(R.id.editText2);
                TextView textView = (TextView) getActivity().findViewById(R.id.textView5);
                try {
                    a = Integer.parseInt(editText1.getText().toString());
                    b = Integer.parseInt(editText2.getText().toString());

                } catch (NumberFormatException e) {
                    a = 0;
                    b = 0;
                }
                c = a * 590;
                b = (a*b)*400;
                c = c+b;

                textView.setText(""+c);
            }
        });
    }
}
