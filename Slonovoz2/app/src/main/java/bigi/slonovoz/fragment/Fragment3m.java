package bigi.slonovoz.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import bigi.slonovoz.R;


public class Fragment3m extends Fragment {
    private Button button;
    private int time, loaders, decision;
    public static Fragment3m newInstance() {
        Fragment3m fragment = new Fragment3m();

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
        return inflater.inflate(R.layout.fragment_fragment3m, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        button = (Button)getActivity().findViewById(R.id.button34m);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText1 = (EditText) getActivity().findViewById(R.id.editText4m);
                EditText editText2 = (EditText) getActivity().findViewById(R.id.editText24m);
                TextView textView = (TextView) getActivity().findViewById(R.id.textView54m);
                try {
                    time = Integer.parseInt(editText1.getText().toString());
                    loaders = Integer.parseInt(editText2.getText().toString());

                } catch (NumberFormatException e) {
                    time = 0;
                    loaders = 0;
                }
                decision = time * 490;
                loaders = (time * loaders)*400;
                decision = decision + loaders;

                textView.setText(""+ decision);
            }
        });
    }
}
