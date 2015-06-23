package com.example.hw3_a;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentCal extends Fragment {
	EditText txt_Amount;
	EditText txt_Other;
	RadioButton rbtn_15;
	RadioButton rbtn_20;
	RadioButton rbtn_Other;
	TextView result;
	TextView tip_txt;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		// ---Inflate the layout for this fragment---
		return inflater.inflate(R.layout.tip_calculator, container, false);
	}

	public void onStart() {
		super.onStart();
		// ---Button view---
		Button btnGetText = (Button) getActivity().findViewById(R.id.btn_cal);

		btnGetText.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				double total = 0;
				double tip = 0;
				double other = 0;

				result = (TextView) getActivity().findViewById(R.id.txt_result);
				tip_txt = (TextView) getActivity().findViewById(R.id.txt_tip);
				rbtn_15 = (RadioButton) getActivity().findViewById(R.id.per_15);
				rbtn_20 = (RadioButton) getActivity().findViewById(R.id.per_20);
				rbtn_Other = (RadioButton) getActivity().findViewById(
						R.id.per_other);
				txt_Amount = (EditText) getActivity().findViewById(
						R.id.tot_amount);
				txt_Other = (EditText) getActivity().findViewById(
						R.id.edt_other);

				if (rbtn_15.isChecked()) {
					/*
					 * if 15% tip.
					 */
					if (txt_Amount.getText().length() == 0) {
						/*
						 * if user isn't input the value
						 */
						Toast.makeText(getActivity(), "Enter the total amount",
								Toast.LENGTH_SHORT).show();
					} else {
						total = Double.parseDouble(txt_Amount.getText()
								.toString());
						tip = total * 0.15;
						/*
						 * setting result value
						 */
						result.setText("Total Amount : "
								+ Double.toString(total + tip));
						tip_txt.setText("Tip : " + Double.toString(tip));
					}
				} else if (rbtn_20.isChecked()) {
					/*
					 * if 20% tip.
					 */
					if (txt_Amount.getText().length() == 0) {
						/*
						 * if user isn't input the value
						 */
						Toast.makeText(getActivity(), "Enter the total amount",
								Toast.LENGTH_SHORT).show();
					} else {
						total = Double.parseDouble(txt_Amount.getText()
								.toString());
						tip = total * 0.20;
						/*
						 * setting result value
						 */
						result.setText("Total Amount : "
								+ Double.toString(total + tip));
						tip_txt.setText("Tip : " + Double.toString(tip));
					}
				} else if (rbtn_Other.isChecked()) {
					/*
					 * if Other% tip.
					 */
					if (txt_Amount.getText().length() == 0) {
						/*
						 * if user isn't input the value
						 */
						Toast.makeText(getActivity(), "Enter the total amount",
								Toast.LENGTH_SHORT).show();
					} else if (txt_Other.getText().length() == 0) {
						/*
						 * if user isn't input the value
						 */
						Toast.makeText(getActivity(), "Enter the percentage",
								Toast.LENGTH_SHORT).show();
					} else {
						/*
						 * setting result value
						 */
						total = Double.parseDouble(txt_Amount.getText()
								.toString());
						other = Double.parseDouble(txt_Other.getText()
								.toString());
						tip = total * (other / 100);

						result.setText("Total Amount : "
								+ Double.toString(total + tip));
						tip_txt.setText("Tip : " + Double.toString(tip));
					}
				} else {
					/*
					 * If user isn't select % button.
					 */
					Toast.makeText(getActivity(), "Select percentage of tip",
							Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
}
